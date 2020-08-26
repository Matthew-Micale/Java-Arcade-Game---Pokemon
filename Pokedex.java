
/**
 * Matt Micale
 * Pokedex class that instantiates every Pokemon object, every move, and every type
 * 8/13/2020
 */
public class Pokedex
{
    public Pokemon[] allPokemon;
    public Move[] allMoves;
    public Type[] allTypes;
    
    public Pokedex()
    {
     allPokemon = new Pokemon[4]; // array that stores every Pokemon
     allMoves = new Move[11]; // array that stores every Move
     allTypes = new Type[6]; // array that stores every Pokemon type
    }
    
    // String pn, Type t1, Type t2, int h, int a, int sa, int d, int sd, int s
    // Creates every Pokemon and links 4 moves from allMoves to each object
    public void createPokemon()
    {
        
        Pokemon Pikachu = new Pokemon("Pikachu", allTypes[4], 274, 209, 199, 159, 179, 279);
        Pikachu.addMove(allMoves[1]);
        Pikachu.addMove(allMoves[4]);
        Pikachu.addMove(allMoves[5]);
        Pikachu.addMove(allMoves[7]);
        allPokemon[0] = Pikachu;
        
        Pokemon Charmander = new Pokemon("Charmander", allTypes[1], 282, 203, 219, 185, 199, 229);
        Charmander.addMove(allMoves[0]);
        Charmander.addMove(allMoves[3]);
        Charmander.addMove(allMoves[6]);
        Charmander.addMove(allMoves[7]);
        allPokemon[1] = Charmander;
        
        Pokemon Squirtle = new Pokemon("Squirtle", allTypes[0], 292, 195, 199, 229, 227, 185);
        Squirtle.addMove(allMoves[2]);
        Squirtle.addMove(allMoves[6]);
        Squirtle.addMove(allMoves[7]);
        Squirtle.addMove(allMoves[8]);
        allPokemon[2] = Squirtle;
        
        Pokemon Sandshrew = new Pokemon("Sandshrew", allTypes[3], 304, 249, 139, 269, 159, 179);
        Sandshrew.addMove(allMoves[1]);
        Sandshrew.addMove(allMoves[7]);
        Sandshrew.addMove(allMoves[9]);
        Sandshrew.addMove(allMoves[10]);
        allPokemon[3] = Sandshrew;
        
        
    }
    
    // Used in the simulator to send all Pokemon to the method
    public Pokemon[] getPokemonArray()
    {
     return allPokemon;   
    }
    
    // Creates a number of Pokemon types
    // Every Move has a type
    // Every Pokemon has a type
    // Each type has strengths and weaknesses that determine move strengths
    public void typeDex()
    {
     Type water = new Type("water");
     allTypes[0] = water;
     Type fire = new Type("fire");
     allTypes[1] = fire;
     Type grass = new Type("grass");
     allTypes[2] = grass;
     Type ground = new Type("ground");
     allTypes[3] = ground;
     Type electric = new Type("electric");
     allTypes[4] = electric;
     Type normal = new Type("normal");
     allTypes[5] = normal;
     
     //water
     allTypes[0].addWeakness(allTypes[0]);
     allTypes[0].addWeakness(allTypes[2]);
     allTypes[0].addWeakness(allTypes[4]);
     
     allTypes[0].addStrength(allTypes[1]);
     allTypes[0].addStrength(allTypes[3]);
     
     //fire
     allTypes[1].addWeakness(allTypes[0]);
     allTypes[1].addWeakness(allTypes[1]);
     allTypes[1].addWeakness(allTypes[3]);
     
     allTypes[1].addStrength(allTypes[2]);
     
     //grass
     allTypes[2].addWeakness(allTypes[1]);
     allTypes[2].addWeakness(allTypes[2]);
     
     allTypes[2].addStrength(allTypes[0]);
     allTypes[2].addStrength(allTypes[3]);
     
     //ground
     allTypes[3].addStrength(allTypes[1]);
     allTypes[3].addStrength(allTypes[4]);
     
     //electric
     allTypes[4].addWeakness(allTypes[2]);
     allTypes[4].addWeakness(allTypes[3]);
     
     allTypes[4].addStrength(allTypes[0]);
     
     
    }
    
    // Creates all Moves
    // Physical Moves depend on the user's attack stat
    // Special Moves depend on the user's special attack stat
    // Stat Booster Moves raises a specific stat of the user
    // Stat Lower Moves lowers a specific stat of the target
    public void moveDex()
    { 
 
     Move m0 = new StatBoosterMove("Growth",allTypes[5],3,1);
     allMoves[0] = m0;
     
     Move m1 = new PhysicalMove("Tackle",allTypes[5],40,100);
     allMoves[1] = m1;
     
     Move m2 = new SpecialMove("Water Gun",allTypes[0],40,100);
     allMoves[2] = m2;
     
     Move m3 = new SpecialMove("Ember",allTypes[1],40,100);
     allMoves[3] = m3;
     
     Move m4 = new SpecialMove("Thunder Shock",allTypes[4],40,100);
     allMoves[4] = m4;
     
     Move m5 = new StatLowerMove("Growl",allTypes[5],1,-1);
     allMoves[5] = m5;
     
     Move m6 = new PhysicalMove("Strength",allTypes[5],80,90);
     allMoves[6] = m6;
     
     Move m7 = new StatBoosterMove("Defense Curl",allTypes[5],2,1);
     allMoves[7] = m7;
     
     Move m8 = new StatLowerMove("Tail Whip",allTypes[5],2,-1);
     allMoves[8] = m8;
     
     Move m9 = new SpecialMove("Mud Slap",allTypes[3],40,100);
     allMoves[9] = m9;
     
     Move m10 = new StatBoosterMove("Swords Dance",allTypes[5],1,2);
     allMoves[10] = m10;
    }
    
    // Determines the effectiveness of an attack based on type strengths and weaknesses
    public double checkTypeEffectiveness(Type t1, Type t2)
    {
        double modifier = 1;
        String moveTypeName = t1.getTypeName(); //type of the move being used
        String targetTypeName = t2.getTypeName(); //type of the target Pokemon object
        int loc = 0;
        // finds the type based on the name
        for(loc = 0; loc < allTypes.length; loc++)
        {
            // once the type is found, exit the for loop
            // keep tabs on the type based on it's index in the allTypes array
            // loc is the index
            if(moveTypeName == allTypes[loc].getTypeName())
            {
             break;   
            }
            
        }
        
        Type[] w = allTypes[loc].getWeaknesses();
        Type[] s = allTypes[loc].getStrengths();
        
        // if the type of the target Pokemon is in the move's weakness array, the attack deals half the damage
        for(int x = 0; x < allTypes[loc].getWeakLength(); x++)
        {
         if(targetTypeName == w[x].getTypeName())
         {
             modifier = .5;
             System.out.println("It's not very effective!");
             break;
            }
        }
        
        // if the type of the target Pokemon is in the move's strengths array, the attack deals double the damage
        for(int x = 0; x < allTypes[loc].getStrengthLength(); x++)
        {
         if(targetTypeName == s[x].getTypeName())
         {
         modifier = 2;
         System.out.println("It's super effective!");
         break;
            }
        }
        
        return modifier;
        
    }
    
}
