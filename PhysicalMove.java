
/**
 * Matt Micale
 * PhysicalMove Class inherited from the Move base class
 * 8/15/20
 **/

 import java.util.Random;
public class PhysicalMove extends Move
{
    // Physical move global variables including a Pokedex varaible for accessing the typeDex
    Pokedex p = new Pokedex();
    public int damage;
    public int accuracy;
    
    // Physical move constructor that calls the base class constructor
    public PhysicalMove(String mn, Type t, int d, int a)
    {
     super(mn,t);
     damage = d;
     accuracy = a;
     p.typeDex();
    }
    
    // Physical move useMove method that is called from the simulator whenever a physical move is selected
    public void useMove(Pokemon user, Pokemon target)
    {
     // Fetches the user's attack stat
     double attack = user.getAttack();
     // Fetches the target's defense stat
     double defense = target.getDefense();
     // Fetches the move's type
       Type moveType = this.t1;
     // Fetches the target Pokemon's type
     Type targetType = target.getType();
     // Calculates the effectiveness of the move on the target based on types
     double typeDamage = p.checkTypeEffectiveness(moveType,targetType);
     // Same type attack bonus is one if the move type and user type are different
     double stab = 1;
     // Compare the user type to the move type, if they are the same, increase the damage inflicted by a factor of 1.5
        String userType = user.getType().getTypeName();
        if(userType == moveType.getTypeName())
        {
         stab = 1.5;   
        }
        // Formula for calculating the damage inflicted
        double damage = ((((22*this.damage) * (attack/defense)) / 50) + 2) * typeDamage * stab;
        // Determines if the attack will hit based on the moves accuracy
        // If the accuracy stat is 90, there is a 90% chance the attack will hit
        Random rand = new Random();
        if(rand.nextInt(100)+1 >= this.accuracy)
        {
            System.out.println("The attack missed!");
        }
        // If the attack hits, lower the targets hp by the damage calculated above
        else
        {
        target.setHp(damage);
        }
        
    }
}