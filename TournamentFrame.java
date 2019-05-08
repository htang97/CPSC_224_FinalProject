import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
   private int width = 500;
	private int height = 600;
   private final int TOTAL_STRATEGIES = 7;
   private int numOfRounds;
   private int scoreHolder1, scoreHolder2;
   private String[] stratNames = {"Lucifer", "Jesus", "Grim Trigger",
      "Tit for Tat", "Forgiving Tit for Tat", "Vengeful Tit for Tat",
      "Collaborator"};
   private int[] stratNums = new int[TOTAL_STRATEGIES];

	private JPanel setUpPanel;//First Panel in tournaments
   private JLabel roundsLabel;
   private JLabel[] stratLabels = new JLabel[TOTAL_STRATEGIES];
   private JTextField roundsField = new JTextField("100", 20);
   private JTextField luciField = new JTextField("0", 20);
   private JTextField jesuField = new JTextField("0", 20);
   private JTextField grimField = new JTextField("0", 20);
   private JTextField titfField = new JTextField("0", 20);
   private JTextField forgField = new JTextField("0", 20);
   private JTextField vengField = new JTextField("0", 20);
   private JTextField collField = new JTextField("0", 20);
   private JLabel results;
   private JLabel aveScore;
   private JLabel totalScore;
   private JButton runButton;
   GridBagConstraints gc = new GridBagConstraints();

   private JPanel resultsPanel;

   TournamentFrame() {//Constructor
		setVisible(true);
		setTitle("Tournament");
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      scoreHolder1 = 0;
      scoreHolder2 = 0;

      setUpPanel = new JPanel(new GridBagLayout());
      gc.gridx = 0;
      gc.gridy = 0;
      roundsField.setBounds(10,10,30,20);
      roundsLabel = new JLabel("# of Rounds:");
      setUpPanel.add(roundsLabel, gc);
      gc.gridx++;
      setUpPanel.add(roundsField, gc);
      gc.gridx--;

      buildSetUp(luciField, 0);
      buildSetUp(jesuField, 1);
      buildSetUp(grimField, 2);
      buildSetUp(titfField, 3);
      buildSetUp(forgField, 4);
      buildSetUp(vengField, 5);
      buildSetUp(collField, 6);

      gc.gridx = 1;
      gc.gridy++;
      runButton = new JButton("Run");
		runButton.addActionListener(new ButtonListener1());
      setUpPanel.add(runButton, gc);

      add(setUpPanel);
	   resultsPanel = new JPanel();
       resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
	   results = new JLabel("RESULTS");
	   resultsPanel.add(results);
       resultsPanel.add(Box.createRigidArea(new Dimension(120, 20)));
	   aveScore = new JLabel();
	   resultsPanel.add(aveScore);
	   resultsPanel.add(Box.createRigidArea(new Dimension(120, 20)));
	   totalScore = new JLabel();
	   resultsPanel.add(totalScore);
   }

   private void buildSetUp(JTextField theField, int i){
      gc.gridy++;
      theField.setBounds(10,10,30,20);
      stratLabels[i] = new JLabel(stratNames[i]);
      setUpPanel.add(stratLabels[i], gc);
      gc.gridx++;
      setUpPanel.add(theField, gc);
      gc.gridx--;
   }

   private class ButtonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
         int[][] uniqueGames = new int[TOTAL_STRATEGIES * TOTAL_STRATEGIES][5];
         //first value is just a number to assign to the game
         //the second integer here is:
         //    0: identity of player 1
         //    1: identity of player 2
         //    2: points of player 1 in this game
         //    3: points of player 2 in this game
         //    4: the number of these games that occurred
         int placeMarker = 0;

			numOfRounds = Integer.parseInt(roundsField.getText());
         stratNums[0] = Integer.parseInt(luciField.getText());
         stratNums[1] = Integer.parseInt(jesuField.getText());
         stratNums[2] = Integer.parseInt(grimField.getText());
         stratNums[3] = Integer.parseInt(titfField.getText());
         stratNums[4] = Integer.parseInt(forgField.getText());
         stratNums[5] = Integer.parseInt(vengField.getText());
         stratNums[6] = Integer.parseInt(collField.getText());


         for(int i = 0; i < TOTAL_STRATEGIES; i++){
            if(stratNums[i] > 0){
               for(int j = i; j < TOTAL_STRATEGIES; j++){
                  if(stratNums[j] > 0){
                     uniqueGames[placeMarker][0] = i;
                     uniqueGames[placeMarker][1] = j;
                     calculateGame(i, j);
                     uniqueGames[placeMarker][2] = scoreHolder1;
                     uniqueGames[placeMarker][3] = scoreHolder2;
                     uniqueGames[placeMarker][4] = stratNums[i] * stratNums[j];
                     placeMarker++;
                  }
               }
            }
         }


         setUpResults(uniqueGames, placeMarker);
		}
	}

   private void calculateGame(int player1, int player2){
      boolean[] player1Choices = new boolean[numOfRounds];
      boolean[] player2Choices = new boolean[numOfRounds];
      Strategy strat1 = new Strategy(stratNames[player1]);
      Strategy strat2 = new Strategy(stratNames[player2]);
      int player1Total = 0;
      int player2Total = 0;

      //First round must be done outside of the loop
      player1Choices[0] = strat1.getCoop(true);
      player2Choices[0] = strat2.getCoop(true);

      for(int i = 1; i < numOfRounds; i++){
         player1Choices[i] = strat1.getCoop(player2Choices[i - 1]);
         player2Choices[i] = strat2.getCoop(player1Choices[i - 1]);
      }

      for(int i = 0; i < numOfRounds; i++){
         if(player1Choices[i]){//if the player chose to cooperate
            if(player2Choices[i]){//if the opponent also cooperated
               player1Total += 4;//3 points if both cooperated
               player2Total += 4;
            } else {//if the opponent defected
               player1Total += 1;//1 points if player was the sucker
               player2Total += 5;
            }
         } else {//if the player chose not to cooperate
            if(player2Choices[i]){//if the opponent cooperated
               player1Total += 5;//5 points if the opponent is a sucker
               player2Total += 1;
            } else {//if the opponent also defected
               player1Total += 2;//2 points if both players defected
               player2Total += 2;
            }
         }
      }

      scoreHolder1 = player1Total;
      scoreHolder2 = player2Total;
   }

   private void setUpResults(int[][] uniqueGames, int totalUniqueGames){
      String scoreText = "<html>Average Score of each strategy: ";
      getContentPane().removeAll();
	   setSize(400,500);
      setTitle("Results");

      for(int i = 0; i < TOTAL_STRATEGIES; i++){
         if(stratNums[i] > 0){
            scoreText = scoreText + "<br>" + stratNames[i] + ": " + calculateAverage(uniqueGames, i, totalUniqueGames);
         }
      }


      aveScore.setText(scoreText);
      totalScore.setText("Total score accumulated: " + calculateTotalPoints(uniqueGames, totalUniqueGames));


      setContentPane(resultsPanel);
      revalidate();
      repaint();
   }

   //gives the average score per game for a strategy
   private int calculateAverage(int[][] uniqueGames, int chosenStrat,
      int totalUniqueGames){

      int totalScore = 0;
      int totalGames = 0;

      for(int i = 0; i < totalUniqueGames; i++){
         if(uniqueGames[i][0] == chosenStrat){
            totalScore += uniqueGames[i][2] * uniqueGames[i][4];
            totalGames += uniqueGames[i][4];
         } else if (uniqueGames[i][1] == chosenStrat){
            totalScore += uniqueGames[i][3] * uniqueGames[i][4];
            totalGames += uniqueGames[i][4];
         }
      }

      if(totalGames == 0)
         return 0;
      else
         return totalScore / totalGames;
   }

   //Gives the overall number of points generated per capita
   //    This is useful for telling how cooperative the game was overall
   private int calculateTotalPoints(int[][] uniqueGames, int totalUniqueGames){
      int numOfPlayers = 0;
      int total = 0;

      for(int i = 0; i < TOTAL_STRATEGIES; i++){
         numOfPlayers += stratNums[i];
      }

      for(int i = 0; i < totalUniqueGames; i++){
         total += (uniqueGames[i][2] * uniqueGames[i][4]);
         total += (uniqueGames[i][3] * uniqueGames[i][4]);
      }


      return total / numOfPlayers;
   }
}
