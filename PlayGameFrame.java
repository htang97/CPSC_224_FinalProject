// Start a 1v1 game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PlayGameFrame extends JFrame{
	private int width = 900;
	private int height = 600;
	private JPanel panel;
	private JButton coButton1;
	private JButton notcoButton1;
	private JButton coButton2;
	private JButton notcoButton2;
	
	public PlayGameFrame() {
		setVisible(true);
		panel = new JPanel();
		setTitle("1v1 Game");
		setSize(width, height);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(Box.createRigidArea(new Dimension(20, 10)));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		coButton1 = new JButton("Trust another player");
		panel.add(coButton1);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		notcoButton1 = new JButton("Do Not Trust another player");
		panel.add(notcoButton1);
		panel.add(Box.createRigidArea(new Dimension(150, 10)));
		notcoButton2 = new JButton("Do Not Trust another player");
		panel.add(notcoButton2);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		coButton2 = new JButton("Trust another player");
		panel.add(coButton2);
		add(panel);
		coButton1.addActionListener(new ButtonListener1());
		notcoButton1.addActionListener(new ButtonListener1());
		coButton2.addActionListener(new ButtonListener2());
		notcoButton2.addActionListener(new ButtonListener2());
	}
	
	private class ButtonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			// Show what player have chosen
			if(actionCommand.equals("Trust another player")) {

				
				
			}else if(actionCommand.equals("Do Not Trust another player")) {
				
				
			}
		}
	}
	private class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			//show another player's chose
			if(actionCommand.equals("Trust another player")) {

				
				
			}else if(actionCommand.equals("Do Not Trust another player")) {
				
				
			}
		}
	}
	public static void main(String [] args) {
		new PlayGameFrame();
	}
}
