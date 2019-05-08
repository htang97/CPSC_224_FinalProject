// Customize a Game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
   private int width = 500;
	private int height = 600;
   private int numOfRounds;
   private int numOfPlayers;
   private int numOfStrats;
   private Strategy[] players;

	private JPanel setUpPanel1;//First Panel in tournaments
   private JLabel roundsLabel;
   private JTextField roundsField = new JTextField(20);
   private JLabel playersLabel;
   private JTextField playersField = new JTextField(20);
   private JLabel strategiesLabel;
   private JTextField strategiesField = new JTextField(20);
   private JButton nextButton1;

   private JPanel setUpPanel2;
   private JPanel resultsPanel;

   TournamentFrame() {//Constructor
		setVisible(true);
		setTitle("Tournament");
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      setUpPanel1 = new JPanel();
      setUpPanel1.setLayout(new GridLayout(4, 2));
      roundsField.setBounds(10,10,30,20);
      roundsLabel = new JLabel("# of Rounds:");
      setUpPanel1.add(roundsLabel);
      setUpPanel1.add(roundsField);
      playersField.setBounds(10,10,30,20);
      playersLabel = new JLabel("# of Players:");
      setUpPanel1.add(playersLabel);
      setUpPanel1.add(playersField);
      strategiesField.setBounds(10,10,30,20);
      strategiesLabel = new JLabel("# of Unique Strategies:");
      setUpPanel1.add(strategiesLabel);
      setUpPanel1.add(strategiesField);

      nextButton1 = new JButton("Next");
      setUpPanel1.add(nextButton1);

      add(setUpPanel1);
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
//////////////Fixed Tournament Frame///////////////////////////
/* Changed Window Size, Frame looking with GridBagLayout//////

// Customize a Game
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
	private int WINDTH = 300;
	private int HEIGHT = 300;
	private JButton button1;
	private JTextField tx1 = new JTextField(10);
	private JTextField tx2 = new JTextField(10);
	private JTextField tx3 = new JTextField(10);
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JPanel panel;
	GridBagConstraints gc = new GridBagConstraints();
	public TournamentFrame() {
		setVisible(true);
		panel = new JPanel(new GridBagLayout());
		setTitle("Customize Your Game");
		setSize(WINDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gc.gridx = 0;
		gc.gridy = 0;
		
		lb1 = new JLabel("# Rounds");
		panel.add(lb1,gc);
		gc.gridy++;
		lb2 = new JLabel("# Players");
		panel.add(lb2,gc);
		gc.gridy++;
		lb3 = new JLabel("# unique strategies");
		panel.add(lb3,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(tx1,gc);
		gc.gridy++;
		panel.add(tx2,gc);
		gc.gridy++;
		panel.add(tx3,gc);
		
		gc.gridx = 1;
		gc.gridy = 10;
		button1 = new JButton("Next");
		panel.add(button1,gc);
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
*/
