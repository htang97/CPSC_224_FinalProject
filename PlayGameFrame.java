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

   private boolean[][]cooperate;//this array stores player 1's response at [0][0-29]
   //Player 2 is [1][0-29]
   private int round;
   private boolean player1Ready;
   private boolean player1Choice;
   private boolean player2Ready;
   private boolean player2Choice;

	PlayGameFrame() {
		setVisible(true);
		setTitle("1v1 Game");
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
		add(gamePanel);

		coButton1.addActionListener(new ButtonListener1());
		notcoButton1.addActionListener(new ButtonListener1());
		coButton2.addActionListener(new ButtonListener2());
		notcoButton2.addActionListener(new ButtonListener2());
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

      for(int i = 0; i < 29; i++){
         if(cooperate[self][i]){//if the player chose to cooperate
            if(cooperate[other][i]){//if the opponent also cooperated
               total += 3;//3 points if both cooperated
            } else {//if the opponent defected
               total += 0;//0 points if player was the sucker
            }
         } else {//if the player chose not to cooperate
            if(cooperate[other][i]){//if the opponent cooperated
               total += 4;//4 points if the opponent is a sucker
            } else {//if the opponent also defected
               total += 1;//1 points if both players defected
            }
         }
      }
      return total;
   }

	private class ButtonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
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

   //Will move to next round if both players have inputted a move for this round.
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
         }
      }
   }

	public static void main(String [] args) {
		new PlayGameFrame();
	}
}
