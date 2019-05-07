// Start a 1v1 game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlayGameFrame extends JFrame{
	private int width = 900;
	private int height = 600;
	private JPanel gamePanel;//The panel the game is played on
	private JButton coButton1;//Buttons for player 1
	private JButton notcoButton1;
	private JButton coButton2;//Buttons for player 2
	private JButton notcoButton2;
	private JLabel label1;
   private JLabel label2;

   private JPanel resultsPanel;//The panel the results are shown on
   /*We should have a label above the buttons for player 1 and player 2,
      We should have a label that shows the round number
      At round 30, it will move to a results panel with a button to exit
      The results panel will have a few charts showing what each player did in
         each round and how many total points they each scored
   */
   private JButton exitButton;
   private JLabel score1;
   private JLabel score2;
   private JTable choices;

   private boolean[][] cooperate;//this array stores player 1's response at [0][0-29]
   //Player 2 is [1][0-29]
   private String[] names = {"Player 1", "Player 2"};
   private int round;
   private boolean player1Ready;
   private boolean player1Choice;
   private boolean player2Ready;
   private boolean player2Choice;

	PlayGameFrame() {
		setVisible(true);
		setTitle("1v1 Game");
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      cooperate = new boolean[2][30];
      round = 1;
      player1Ready = false;
      player1Choice = false;
      player2Ready = false;
      player2Choice = false;

		gamePanel = new JPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
		gamePanel.add(Box.createRigidArea(new Dimension(140, 10)));

		coButton1 = new JButton("O");
		gamePanel.add(coButton1);
		label1 = new JLabel("Trust");
		gamePanel.add(label1);
		gamePanel.add(Box.createRigidArea(new Dimension(40, 10)));
		notcoButton1 = new JButton("X");
		gamePanel.add(notcoButton1);
		label2 = new JLabel("Defect");
		gamePanel.add(label2);
		gamePanel.add(Box.createRigidArea(new Dimension(150, 10)));
		notcoButton2 = new JButton("O");
		gamePanel.add(notcoButton2);
		label1 = new JLabel("Trust");
		gamePanel.add(label1);
		gamePanel.add(Box.createRigidArea(new Dimension(40, 10)));
		coButton2 = new JButton("X");
		gamePanel.add(coButton2);
		label2 = new JLabel("Defect");
		gamePanel.add(label2);
		setContentPane(gamePanel);

		coButton1.addActionListener(new ButtonListener1());
		notcoButton1.addActionListener(new ButtonListener1());
		coButton2.addActionListener(new ButtonListener2());
		notcoButton2.addActionListener(new ButtonListener2());

      resultsPanel = new JPanel();
      score1 = new JLabel();
      resultsPanel.add(score1);
      score2 = new JLabel();
      resultsPanel.add(score2);

      Object[] columnNames = {"P1 Choice", "P2 Choice", "P1 Score", "P2 Score"};
      Object[][] data = new Object[4][30];
      choices = new JTable(data, columnNames);
      resultsPanel.add(choices);

      exitButton = new JButton("Exit");
      exitButton.addActionListener(new ButtonListener3());
      resultsPanel.add(exitButton);
	}

   //Gets the score for a given player for a specific round
   private int calculateRoundScore(int self, int other, int roundNum){
      int score;

      if(cooperate[self][roundNum]){//if the player chose to cooperate
         if(cooperate[other][roundNum]){//if the opponent also cooperated
            score = 3;//3 points if both cooperated
         } else {//if the opponent defected
            score = 1;//0 points if player was the sucker
         }
      } else {//if the player chose not to cooperate
         if(cooperate[other][roundNum]){//if the opponent cooperated
            score = 5;//4 points if the opponent is a sucker
         } else {//if the opponent also defected
            score = 2;//1 points if both players defected
         }
      }
      return score;
   }

   //Returns the final score for a player
   //Should be given a 1 or a 2 for the int player
   private int calculateFinalScore(int player){
      int total = 0;
      int self = player - 1;
      int other;
      if(player == 1){
         other = 1;
      } else {
         other = 0;
      }

      for(int i = 0; i < 30; i++){
         total += calculateRoundScore(self, other, i);
      }
      return total;
   }

   //Puts data into the JTable choices
   private void setUpTable(){
      for(int i = 0; i < 30; i++){

      }
   }

	private class ButtonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e)
			if(e.getSource() == coButton1) {
            player1Ready = true;
            player1Choice = true;
            nextRound();


			}else if(e.getSource() == notcoButton1) {
            player1Ready = true;
            player1Choice = false;
            nextRound();

			}
		}
	}

	private class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			//show another player's chose
			if(e.getSource() == coButton2) {
            player2Ready = true;
            player2Choice = true;
            nextRound();

			}else if(e.getSource() == notcoButton2) {
            player2Ready = true;
            player2Choice = false;
            nextRound();

			}
		}
	}

   private class ButtonListener3 implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         //dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
      }
   }

   //Will move to next round if both players have inputed a move for this round.
   //Will not advance round if one player is not ready
   private void nextRound(){
      if(player1Ready && player2Ready){
         cooperate[0][round] = player1Choice;
         cooperate[1][round] = player2Choice;
         round++;
         player1Ready = false;
         player1Choice = false;
         player2Ready = false;
         player2Choice = false;

         if(round > 30){
            //This is where the results panel comes up once the game is over
            getContentPane().removeAll();

            score1.setText("Player 1 Scored: " + calculateFinalScore(1)
               + "\nPlayer 2 Scored: " + calculateFinalScore(2));
            setUpTable();
            setContentPane(resultsPanel);
            revalidate();
            repaint();
         }
      }
   }
}
