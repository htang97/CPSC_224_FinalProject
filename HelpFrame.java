// Get Help
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame {
	private int WIN_WIDTH = 300;
	private int WIN_HEIGHT = 500;
   private int count;
   private JPanel helpPanel;
   private JLabel text;
   private JButton next;

   //This is a series or text and images to help explain how to use the app
   //    and the basics of game theory tournaments
	public HelpFrame() {
		setVisible(true);
		setTitle("Instructions");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      count = 1;
      helpPanel = new JPanel();
      text = new JLabel("This window will walk you through the basics of \nthis software.");
      helpPanel.add(text);
      next = new JButton("Next");
      next.addActionListener(new ButtonListener());
      helpPanel.add(next);
      add(helpPanel);
	}

   private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			switch(count){
            case 1://intro to prisoner's dilemna
               break;
            case 2://Specifics of Playable game
               break;
            case 3://Specifics of setup tournament
               break;
            case 4://Specifics of different strategies
               break;
            case 5:
               dispose();
               break;
         }
         count++;
		}
	}

   //public static void main(String[] args) {
      //HelpFrame theFrame = new HelpFrame();
   //}
}
