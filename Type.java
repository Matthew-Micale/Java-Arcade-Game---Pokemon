
/**
 * Matt Micale
 * Type Class
 * 8/13/2020
 */
public class Type
{
    // Global Type variables
    public String typeName;
    public Type[] weaknesses;
    int weakLoc;
    public Type[] strengths;
    int strengthLoc;

    // Type constuctor with only the type name as a parameter
    public Type(String tn)
    {
     typeName = tn;
     weaknesses = new Type[5]; // No type has more than 5 weaknesses
     weakLoc = 0; // To keep track of how many weaknesses a type has
     strengths = new Type[5]; // No type has more than 5 strengths
     strengthLoc = 0; // To keep track of how many strengths a type has
    }
    
    public String getTypeName()
    {
     return typeName;   
    }
    
    public Type(String tn, Type[] w, Type[] s)
    {
     typeName = tn;
     weaknesses = w;
     strengths = s;
    }
    
    // Pokedex class uses this method to add types to this types weaknesses
    public void addWeakness(Type w)
    {
        if(weakLoc <= 4)
        {
        weaknesses[weakLoc] = w;
        weakLoc++;
       }
    }
    
    public int getWeakLength()
    {
        return weakLoc;
    }
    
    // Pokedex class uses this method to add types to this types strengths
    public void addStrength(Type s)
    {
     if(strengthLoc <= 4)
     {
     strengths[strengthLoc] = s;
     strengthLoc++;
     }
    }
    
    public int getStrengthLength()
    {
     return strengthLoc;   
    }
    
    public Type[] getWeaknesses()
    {
     return weaknesses;   
    }
    
    public Type[] getStrengths()
    {
     return strengths;   
    }
}
