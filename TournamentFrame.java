// Customize a Game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
   private int width = 500;
	private int height = 600;
   private final int TOTAL_STRATEGIES = 7;
   private int numOfRounds;
   private int numOfPlayers;
   private int numOfStrats;
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
         int[][] uniqueGames = new int[TOTAL_STRATEGIES * TOTAL_STRATEGIES][4];
         //first value is just a number to assign to the game
         //the second integer here is:
         //    0: identity of player 1
         //    1: identity of player 2
         //    2: points of player 1 in this game
         //    3: points of player 2 in this game
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
                     uniqueGames[placemarker][2] = scoreHolder1;
                     uniqueGames[placemarker][3] = scoreHolder2;
                     placemarker++;
                  }
               }
            }
         }


         setUpResults();
		}
	}

   private void calculateGame(int player1, int player2){
      boolean[] player1Choices = new boolean[numOfRounds];
      boolean[] player2Choices = new boolean[numOfRounds];
      

   }

   private void setUpResults(){

   }

   private int calculateAverage(String name){
      return 1;
   }

   private int calculateTotalPoints(){
      return 1;
   }

   public static void main(String[] args){
      TournamentFrame theFrame = new TournamentFrame();
   }
}
