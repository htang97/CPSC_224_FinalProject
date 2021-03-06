// Get Help
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame {
	private int WIN_WIDTH = 400;
	private int WIN_HEIGHT = 500;
   private int pageNumber;
   private JPanel helpPanel;
   private JLabel text;
   private JButton next;
   private JButton back;

   //This is a series or text and images to help explain how to use the app
   //    and the basics of game theory tournaments
	public HelpFrame() {
		setVisible(true);
		setTitle("Instructions");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      pageNumber = 0;
      helpPanel = new JPanel();
      text = new JLabel("<html>This window will walk you through the basics of this software.");
      helpPanel.add(text);
      back = new JButton("Back");
      back.addActionListener(new ButtonListener());
      helpPanel.add(back);
      next = new JButton("Next");
      next.addActionListener(new ButtonListener());
      helpPanel.add(next);
      add(helpPanel);
	}

   private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
         if(e.getSource() == next){
            pageNumber++;
         } else {
            pageNumber--;
         }

			switch(pageNumber){
            case 1://intro to prisoner's dilemna
               text.setText("<html>While game theory attempts to cover any game in which the "
                  + "<br>player rationally pursues its self-interest, this software"
                  + "<br>will focus on the famous Prisoner's Dilemma."
                  + "<br>This exercise is based on the premise that if both players"
                  + "<br>choose to work together, the most overall points are gained."
                  + "<br>But if one player chooses to betray the other, then they get"
                  + "<br>more points personally. However, if both players betray, then"
                  + "<br>everybody loses and they get only 2 points."
                  + "<br>The most rational choice if you are only playing the game"
                  + "<br>once is to betray the other player, but doing the game"
                  + "<br>multiple times allows players to build trust, increasing"
                  + "<br>the likelihood of cooperation.");
               break;
            case 2://Specifics of Playable game
               text.setText("<html>In the playable 1v1 game, two users put in moves"
                  + "<br>and accumlate points for 10 rounds. Users should ideally"
                  + "<br>decide their moves simultaneously and then enter the choice."
                  + "<br><br>If both players cooperate/trust then they will get 4 points."
                  + "<br>If only one player cooperates, then the defector gets 5 points"
                  + "<br>while the sucker only gets 1."
                  + "<br>If both players defect then they both get 2 points."
                  + "<br><br>Results will show at the end of the tenth round.");
               break;
            case 3://Specifics of setup tournament
               next.setText("Next");
               text.setText("<html>In a tournament, the goal is not win every individual game,"
                  + "<br>but to accumlate the most point over the course of the"
                  + "<br>tournament. Every individual automated strategy will play"
                  + "<br>agaisnt every other strategy once."
                  + "<br><br>The user can decide How many there will be of each"
                  + "<br>strategy, and this distribution will likely affect which"
                  + "<br>program ends up being the most effective. Feel free to"
                  + "<br>experiement and find interesting sets of strategies that"
                  + "<br>cause certain ones to be more effective."
                  + "<br><br>Once the tournament has been calculated, you will be"
                  + "<br>shown the results.");
               break;
            case 4://Specifics of different strategies
               next.setText("Quit");
               text.setText("<html>List of all strategies:"
                  + "<br><br>Lucifer- Will always defect no matter what"
                  + "<br><br>Jesus- Will always cooperate no matter what"
                  + "<br><br>Grim Trigger- Will cooperate until its opponent defects"
                  + "<br>Then it will never cooperate again."
                  + "<br><br>Tit for Tat- Will repay the opponent by copying their prior"
                  + "<br>move. Essentially, it is retributive."
                  + "<br><br>Forgiving Tit for Tat- Will forgive an opponent for one"
                  + "<br>turn of defecting if they immediately go back to cooperating"
                  + "<br><br>Vengeful Tit for Tat- Will expect an additional free turn"
                  + "<br>of the other strategy being the sucker to make up for defection"
                  + "<br><br>Collaborator- Will send out a special code and always cooperate"
                  + "<br> with other identical strategies, and defect against anything"
                  + "<br>different");
               break;
            case 5:
               dispose();
               break;
         }
		}
	}
}
