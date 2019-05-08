// Customize a Game
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class setupPanel2 extends JFrame {
	private int WINDTH = 500;
	private int HEIGHT = 600;
	private JButton button2;
	private JTextField tx1 = new JTextField(20);
	private JTextField tx2 = new JTextField(20);
	private JTextField tx3 = new JTextField(20);
	private JTextField tx4 = new JTextField(20);
	private JTextField tx5 = new JTextField(20);
	private JTextField tx6 = new JTextField(20);
	private JTextField tx7 = new JTextField(20);
	private JTextField tx8 = new JTextField(20);
	private JTextField tx9 = new JTextField(20);
	private JTextField tx10 = new JTextField(20);
	private JTextField tx11 = new JTextField(20);
	private JTextField tx12 = new JTextField(20);
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
		
	public setupPanel2() {
		setVisible(true);
		panel = new JPanel();
		panel.setLayout (new GridLayout());
		setTitle("second setting");
		setSize(WINDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tx1.setBounds(10,10,30,20);
		lb1 = new JLabel("Tit for tat");
		panel.add(lb1);
		panel.add(tx1);
		tx2.setBounds(10,10,30,20);
		lb2 = new JLabel("Forgiving tit for tat");
		panel.add(lb2);
		panel.add(tx2);
		tx3.setBounds(10,10,30,20);
		lb3 = new JLabel("Grim Trigger");
		panel.add(lb3);
		panel.add(tx3);
		tx4.setBounds(10,10,30,20);
		lb4 = new JLabel("Lucifer");
		panel.add(lb4);
		panel.add(tx4);
		tx5.setBounds(10,10,30,20);
		lb5 = new JLabel("End ahead tit for tat");
		panel.add(lb5);
		panel.add(tx5);
		tx6.setBounds(10,10,30,20);
		lb6 = new JLabel("Tester");
		panel.add(lb6);
		panel.add(tx6);
		tx7.setBounds(10,10,30,20);
		lb7 = new JLabel("Collaborator together");
		panel.add(lb7);
		panel.add(tx7);
		tx8.setBounds(10,10,30,20);
		lb8 = new JLabel("Collaborator loser");
		panel.add(lb8);
		panel.add(tx8);
		tx9.setBounds(10,10,30,20);
		lb9 = new JLabel("collaborator winner");
		panel.add(lb9);
		panel.add(tx9);
		tx10.setBounds(10,10,30,20);
		lb10 = new JLabel("Random");
		panel.add(lb10);
		panel.add(tx10);
		add(panel);
		button2 = new JButton("Done");
		panel.add(button2);
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
