
/**
 * Matt Micale
 * StatusBoosterMove class inherited from Move base class
 * 8/15/20
 */
public class StatBoosterMove extends Move
{
    public int stat;
    //1 -> attack
    //2 -> defense
    //3 -> special attack
    //4 -> special defense
    //5 -> speed
    public int modifier;
    
    // Stat booster move constructor that takes move name, move type, the stat the move boosts, and how much it increases the stat by
    public StatBoosterMove(String mn, Type n, int s, int m)
    {
       super(mn,n);
       stat = s;
       modifier = m;
    }
    
    // Method called from simulator whenever a stat boosting move is selected
    public void useMove(Pokemon user, Pokemon target)
    {
       // Switch statement that increases the a stat of the user
       // If the stat variable is 1, increases attack, use key above for other stats
       // If the modifier is 1, increase the stat by 1 stage, formula for stages is in the Pokemon class
       switch(stat)
       {
           
           case 1:
           user.setAttackStage(modifier);
           System.out.println(user.getName() + "'s attack rose!");
           break;
           case 2:
           user.setDefenseStage(modifier);
           System.out.println(user.getName() + "'s defense rose!");
           break;
           case 3:
           user.setSpecialAttackStage(modifier);
           System.out.println(user.getName() + "'s special attack rose!");
           break;
           case 4:
           user.setSpecialDefenseStage(modifier);
           System.out.println(user.getName() + "'s special defense rose!");
           break;
           case 5:
           user.setSpeedStage(modifier);
           System.out.println(user.getName() + "'s speed rose!");
           break;
           default:
           System.out.println("error");
           
        }
    }
}
