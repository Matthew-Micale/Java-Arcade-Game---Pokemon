
/**
 * Matt Micale
 * SpecialMove Class inherited from the Move base class
 * 8/15/20
 */

import java.util.Random; 
public class SpecialMove extends Move
{
 
    // Special moves inflict damage based on the user's special attack, and the target's special defense
    // Creates a Pokedex object to access the typeDex
    Pokedex p = new Pokedex();
    public int damage = 0;
    public int accuracy = 0;
    
    // Special move constructor that accepts move name, move type, move damage, and move accuracy ratings
    public SpecialMove(String mn, Type t, int d, int a)
    {
     super(mn,t);
     damage = d;
     accuracy = a;
     p.typeDex();
    }
    
    // useMove method that is called from the simulator whenever a special move is selected
    public void useMove(Pokemon user, Pokemon target)
    {
        // fetches the user's special attack stat
        double spAttack = user.getSpecialAttack();
        // fetches the target's special defense stat
        double spDefense = target.getSpecialDefense();
        // fetches the moves type
        Type moveType = this.t1;
        // fetches the target's type
        Type targetType = target.getType();
        // calculates the move's effectiveness on the target based on the move's type and the target's type
        double typeDamage = p.checkTypeEffectiveness(moveType,targetType);
        // same type attack bonus is one if the move type and user type are different
        double stab = 1;
        String userType = user.getType().getTypeName();
        // if the move type and user type are the same, increase the damage by a factor of 1.5
        if(userType == moveType.getTypeName())
        {
         stab = 1.5;   
        }
        
        // formula for calculating the damage inflicted on the target
        double damage = ((((22*this.damage) * (spAttack/spDefense)) / 50) + 2) * typeDamage * stab;
        
        // determines whether the attack will hit or miss
        // if the attack's accuracy is 90, there is a 90% chance the attack will hit
        Random rand = new Random();
        if(rand.nextInt(100)+1 >= this.accuracy)
        {
            System.out.println("The attack missed!");
        }
        // if the attack hits, decrease the target's hp by the damage variable
        else
        {
        target.setHp(damage);
        }
        
        
    }
    
}
