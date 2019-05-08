// Customize a Game
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
	private int WINDTH = 500;
	private int HEIGHT = 600;
	private JButton button1;
	private JTextField tx1 = new JTextField(20);
	private JTextField tx2 = new JTextField(20);
	private JTextField tx3 = new JTextField(20);
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JPanel panel;
		
	public TournamentFrame() {
		setVisible(true);
		panel = new JPanel();
		panel.setLayout (new GridLayout());
		setTitle("Customize Your Game");
		setSize(WINDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tx1.setBounds(10,10,30,20);
		lb1 = new JLabel("# Rounds");
		panel.add(lb1);
		panel.add(tx1);
		tx2.setBounds(10,10,30,20);
		lb2 = new JLabel("# Players");
		panel.add(lb2);
		panel.add(tx2);
		tx3.setBounds(10,10,30,20);
		lb3 = new JLabel("# unique strategies");
		panel.add(lb3);
		panel.add(tx3);
		button1 = new JButton("Next");
		panel.add(button1);
		add(panel);
		button1.addActionListener(new ButtonListener());
	}
	
	// Go to another setting frame, close this one
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		
			String actionCommand = e.getActionCommand();
			
			if(actionCommand.equals("Next")) {
				
				new setupPanel2();
				setVisible(false);

			}
				
		}
	}

	public static void main(String [] args) {
		new TournamentFrame();
	}
		
}
