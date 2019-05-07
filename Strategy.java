package gameTheoryApp;

public class Strategy {
   private String name;
	private boolean bool1;
	private boolean bool2;
	private int num1;
   private int turn;

	public Strategy(String givenName) {
      name = givenName;
      turn = 1;

      switch(givenName) {
         case "Lucifer"://Lucifer programs only need the name
            break;
         case "Jesus"://Jesus programs only need the name
            break;
         case "Grim Trigger":
            bool1 = true;//Will use this to determined if betrayed before
            break;
         case "Tit for Tat":
            bool1 = true;//Tit for Tat cooperates turn 1
            break;
		}
	}

   public boolean getCoop(boolean priorOppMove){
      boolean choice = false;

      switch(name) {
         case "Lucifer":
            choice = false;
            break;
         case "Jesus":
            choice = true;
            break;
         case "Grim Trigger":
            choice = getGrimTrigger(priorOppMove);
            break;
         case "Tit for Tat":
            choice = getTitForTat(priorOppMove);
            break;
      }

      turn++;
      return choice;
   }

   private boolean getGrimTrigger(boolean priorOppMove){
      if(priorOppMove = false){
         bool1 = false;
      }
      return bool1;
   }

   private boolean getTitForTat(boolean priorOppMove){
      return priorOppMove;
   }


}
