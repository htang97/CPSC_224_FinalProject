// Customize a Game
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TournamentFrame extends JFrame {
   private int width = 900;
	private int height = 600;
   private int numOfRounds;
   private int numOfPlayers;
   private int numOfStrats;
   private Strategy[] players;

	private JPanel gamePanel;//The panel the game is played on

   PlayGameFrame() {//Constructor
		setVisible(true);
		setTitle("1v1 Game");
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

   }

   private int calculateAverage(String name){

   }

   private int calculateTotalPoints(){

   }


}
