// Customize a Game
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class setupPanel2 extends JFrame {
	private int WINDTH = 300;
	private int HEIGHT = 600;
	private JButton button2;
	private JTextField tx1 = new JTextField(10);
	private JTextField tx2 = new JTextField(10);
	private JTextField tx3 = new JTextField(10);
	private JTextField tx4 = new JTextField(10);
	private JTextField tx5 = new JTextField(10);
	private JTextField tx6 = new JTextField(10);
	private JTextField tx7 = new JTextField(10);
	private JTextField tx8 = new JTextField(10);
	private JTextField tx9 = new JTextField(10);
	private JTextField tx10 = new JTextField(10);
	private JTextField tx11 = new JTextField(10);
	private JTextField tx12 = new JTextField(10);
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JLabel lb6;
	private JLabel lb7;
	private JLabel lb8;
	private JLabel lb9;
	private JLabel lb10;
	private JLabel lb11;
	private JLabel lb12;
	private JPanel panel;
	GridBagConstraints gc = new GridBagConstraints();
	
	public setupPanel2() {
		setVisible(true);
		panel = new JPanel(new GridBagLayout());
		
		setTitle("Strategies Apply");
		setSize(WINDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gc.gridx = 0;
		gc.gridy = 0;
		
		lb1 = new JLabel("Tit for tat");
		panel.add(lb1,gc);
		gc.gridy++;
		
		lb2 = new JLabel("Forgiving tit for tat");
		panel.add(lb2,gc);
		gc.gridy++;
		
		lb3 = new JLabel("Grim Trigger");
		panel.add(lb3,gc);
		gc.gridy++;

		lb4 = new JLabel("Lucifer");
		panel.add(lb4,gc);
		gc.gridy++;
		
		lb5 = new JLabel("End ahead tit for tat");
		panel.add(lb5,gc);
		gc.gridy++;
		
		lb6 = new JLabel("Tester");
		panel.add(lb6,gc);
		gc.gridy++;
		
		lb7 = new JLabel("Collaborator together");
		panel.add(lb7,gc);
		gc.gridy++;

		lb8 = new JLabel("Collaborator loser");
		panel.add(lb8,gc);
		gc.gridy++;

		lb9 = new JLabel("collaborator winner");
		panel.add(lb9,gc);
		gc.gridy++;
	
		lb10 = new JLabel("Random");
		panel.add(lb10,gc);
		gc.gridy++;

		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(tx1,gc);
		gc.gridy++;
		panel.add(tx2,gc);
		gc.gridy++;
		panel.add(tx3,gc);
		gc.gridy++;
		panel.add(tx4,gc);
		gc.gridy++;
		panel.add(tx5,gc);
		gc.gridy++;
		panel.add(tx6,gc);
		gc.gridy++;
		panel.add(tx7,gc);
		gc.gridy++;
		panel.add(tx8,gc);
		gc.gridy++;
		panel.add(tx9,gc);
		gc.gridy++;
		panel.add(tx10,gc);
		
		add(panel);
		
		gc.gridx = 1;
		gc.gridy = 10;
		button2 = new JButton("Done");
		panel.add(button2,gc);
		button2.addActionListener(new ButtonListener());
	}
	
	// Done with setting, ready to play the game
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		
			String actionCommand = e.getActionCommand();
			
			if(actionCommand.equals("Done")) {
				
				setVisible(false);

			}
				
		}
	}

	public static void main(String [] args) {
		new setupPanel2();
	}
		
}
