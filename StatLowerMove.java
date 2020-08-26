
/**
 * Matt Micale
 * StatLowerMove that is inherited from Move base class
 * 8/17/20
 */
public class StatLowerMove extends Move
{
    public int stat;
    //1 -> attack
    //2 -> defense
    //3 -> special attack
    //4 -> special defense
    //5 -> speed
    public int modifier;
    
    // Constructor for a Stat lowering move that takes the move name, move type, the stat the move lowers, and how much it lowers it by
    public StatLowerMove(String mn, Type n, int s, int m)
    {
     super(mn,n);
     stat = s;
     modifier = m;
    }
    
    // Method that is called whenever a stat lowering move is selected in the simulator
    public void useMove(Pokemon user, Pokemon target)
    {
     // Switch statement that lowers a stat of the target based on the stat key
     // if the stat variable is 1, lower the target's attack, use the key above for the other stats
     // If the modifier variable is 1, lower the stat by 1 stage
     // The formula for stages effect on stats is in the Pokemon class
     switch(stat)
     {
         case 1:
         target.setAttackStage(modifier);
         System.out.println(target.getName() + "'s attack fell!");
         break;
         case 2:
         target.setDefenseStage(modifier);
         System.out.println(target.getName() + "'s defense fell!");
         break;
         case 3:
         target.setSpecialAttackStage(modifier);
         System.out.println(target.getName() + "'s special attack fell!");
         break;
         case 4:
         target.setSpecialDefenseStage(modifier);
         System.out.println(target.getName() + "'s special defense fell!");
         break;
         case 5:
         target.setSpeedStage(modifier);
         System.out.println(target.getName() + "'s speed fell!");
         break;
         default:
         System.out.println("error");
        }
    }
}
