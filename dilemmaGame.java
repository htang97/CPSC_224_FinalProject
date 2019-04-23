import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class dilemmaGame extends JFrame{

	private JPanel panel;
	private int WINDOW_WIDTH = 500;
	private int WINDOW_HEIGHT = 500;
	private JButton playButton;
	private JButton customButton;
	private JButton helpButton;
	private JButton quitButton;

   //Sets up menu and lets the user open oup the other panels
	public dilemmaGame() {
		setTitle("Menu");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.add(Box.createRigidArea(new Dimension(150, 50)));
		playButton = new JButton("Set up a 1v1 game");
		panel.add(playButton);
		panel.add(Box.createRigidArea(new Dimension(150, 50)));
		customButton = new JButton("Set up a tournament");
		panel.add(customButton);
		panel.add(Box.createRigidArea(new Dimension(150, 50)));
		helpButton = new JButton("Get Help");
		panel.add(helpButton);
		panel.add(Box.createRigidArea(new Dimension(150, 50)));
		quitButton = new JButton("Quit");
		panel.add(quitButton);
		add(panel);
		setVisible(true);

      //This frame does not go away when the user is in the other frame
	   playButton.addActionListener(new ButtonListener());
		customButton.addActionListener(new ButtonListener());
		helpButton.addActionListener(new ButtonListener());
		quitButton.addActionListener(new ButtonListener());

	}

		private class ButtonListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {

				String actionCommand = e.getActionCommand();

				if(actionCommand.equals("Set up a 1v1 game")) {

					new PlayGameFrame();

				}else if(actionCommand.equals("Set up a tournament")) {

					new TournamentFrame();

				}else if(actionCommand.equals("Get Help")){

					new HelpFrame();

				}else if(actionCommand.equals("Quit")) {
               System.exit(0);
				}

			}
		}


	public static void main (String [] args){
		new dilemmaGame();
	}

}
