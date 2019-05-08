public class Strategy {
   private String name;
	private boolean bool1;
	private boolean bool2;
	private int num1;
   private int turn;

	public Strategy() {
      turn = 1;
	}

   public void refresh(){
      turn = 1;
      setStrategy(name);
   }

   public void setStrategy(String givenName){
      name = givenName;

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
         case "Forgiving Tit for Tat":
            bool1 = true;//Cooperates turn 1
            bool2 = true;// This will store what the opponent did 2 turns ago
            break;
         case "Vengeful Tit for Tat":
            bool1 = true;//Cooperates turn 1
            bool2 = true;// This will store what the opponent did 2 turns ago
            break;
         case "Collaborator":
            bool1 = true;//This will store the value to return in turns 1-10
            bool2 = true;//This will become false once an opponent does not do it's code
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
         case "Forgiving Tit for Tat":
            choice = getForgiving(priorOppMove);
            break;
         case "Vengeful Tit for Tat":
            choice = getVengeful(priorOppMove);
            break;
         case "Collaborator":
            choice = getCollaborator(priorOppMove);
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

   private boolean getForgiving(boolean priorOppMove){
      bool1 = bool2;
      bool2 = priorOppMove;

      if(bool1 || bool2)
         return true;
      else
         return false;
   }

   private boolean getVengeful(boolean priorOppMove){
      bool1 = bool2;
      bool2 = priorOppMove;

      if(bool1 && bool2)
         return true;
      else
         return false;
   }

   private boolean getCollaborator(boolean priorOppMove){
      if(bool2){//if it thinks the opponent is the same code
         switch(turn) {
            case 1:
               bool1 = true;
               break;
            case 2:
               bool1 = true;
               if(!(priorOppMove == true))
                  bool2 = false;
               break;
            case 3:
               bool1 = false;
               if(!(priorOppMove == true))
                  bool2 = false;
               break;
            case 4:
               bool1 = true;
               if(!(priorOppMove == false))
                  bool2 = false;
               break;
            case 5:
               bool1 = false;
               if(!(priorOppMove == true))
                  bool2 = false;
               break;
            case 6:
               bool1 = true;
               if(!(priorOppMove == false))
                  bool2 = false;
               break;
            case 7:
               bool1 = true;
               if(!(priorOppMove == true))
                  bool2 = false;
               break;
            case 8:
               bool1 = false;
               if(!(priorOppMove == true))
                  bool2 = false;
               break;
            case 9:
               bool1 = false;
               if(!(priorOppMove == false))
                  bool2 = false;
               break;
            case 10:
               bool1 = false;
               if(!(priorOppMove == false))
                  bool2 = false;
               break;
            default:
               bool1 = true;
               break;
         }
      } else {
         bool1 = false;
      }

      return bool1;
   }


}
