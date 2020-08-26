
/**
 * Matt Micale
 * Pokemon Moves base class with 4 different inherited classes
 * 8/13/2020
 */
public class Move
{
    // All moves have a name and a type
    public String moveName;
    public Type t1;
      
    public Move(String mn, Type t)
    {
     moveName = mn;
     t1 = t;
    }
    
    public String getMoveName()
    {
     return moveName;   
    }
    
    public Type getMoveType()
    {
     return t1;   
    }
    
    // Overridden method which is selected based on the inherited object class
    public void useMove(Pokemon user, Pokemon target)
    {
     System.out.println(user.getName() + " used " + moveName + "!");   
    }
    
}
