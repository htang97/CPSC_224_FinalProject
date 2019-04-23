// Get Help
import javax.swing.*;

public class HelpFrame extends JFrame {
	private int WIN_WIDTH = 300;
	private int WIN_HEIGHT = 500;

   //This is a series or text and images to help explain how to use the app
   //    and the basics of game theory tournaments
	public HelpFrame() {
		setVisible(true);
		setTitle("Helper");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
