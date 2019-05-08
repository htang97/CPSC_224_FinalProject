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
