// Customize a Game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
   private int width = 350;
	private int height = 500;
   private int numOfRounds;
   private int numOfPlayers;
   private int numOfStrats;
   private Strategy[] players;

	private JPanel setUpPanel1;//First Panel in tournaments
   private JLabel roundsLabel;
   private JTextField roundsField;
   private JLabel playersLabel;
   private JTextField playersField;
   private JLabel strategiesLabel;
   private JTextField strategiesField;
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
      roundsLabel = new JLabel("# of Rounds:");
      setUpPanel1.add(roundsLabel);
      playersLabel = new JLabel("# of Players:");
      setUpPanel1.add(playersLabel);
      strategiesLabel = new JLabel("# of Unique Strategies:");
      setUpPanel1.add(strategiesLabel);
      //JTextField really just is not working on my computer right now
      // I reinstalled java and it still jsut is not working
      //roundsField = new JTextField("This Constructor?");
      //setUpPanel1.add(roundsField);
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
