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

	PlayGameFrame() {
		setVisible(true);
		setTitle("1v1 Game");
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

      round = 1;

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
		label2 = new JLabel("No Trust");
		gamePanel.add(label2);
		gamePanel.add(Box.createRigidArea(new Dimension(150, 10)));
		notcoButton2 = new JButton("O");
		gamePanel.add(notcoButton2);
		label1 = new JLabel("Trust");
		gamePanel.add(label1);
		gamePanel.add(Box.createRigidArea(new Dimension(40, 10)));
		coButton2 = new JButton("X");
		gamePanel.add(coButton2);
		label2 = new JLabel("No Trust");
		gamePanel.add(label2);
		add(gamePanel);

		coButton1.addActionListener(new ButtonListener1());
		notcoButton1.addActionListener(new ButtonListener1());
		coButton2.addActionListener(new ButtonListener2());
		notcoButton2.addActionListener(new ButtonListener2());
	}

	private class ButtonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == coButton1) {



			}else if(e.getSource() == notcoButton1) {


			}
		}
	}
	private class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			//show another player's chose
			if(e.getSource() == coButton1) {



			}else if(e.getSource() == notcoButton1) {


			}
		}
	}
	public static void main(String [] args) {
		new PlayGameFrame();
	}
}
