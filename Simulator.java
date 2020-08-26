
/**
 * Matt Micale
 * Pokemon Simulator
 * 8/13/2020
 */

import java.util.Scanner;
import java.util.Random; 
public class Simulator
{
    public static void main(String[] args)
    {
        Pokedex dex = new Pokedex();
        dex.typeDex(); // Creates all type objects for the dex
        dex.moveDex(); // Creates all move objects for the dex
        dex.createPokemon(); // Creates all Pokemon objects for the dex
        welcomeMessage();
        Pokemon[] allPokemon = dex.getPokemonArray(); // Transfers every Pokemon object to the Simulator
        Pokemon user = choosePokemon(allPokemon);
        Pokemon enemy = randomPokemon(allPokemon);
        // Keep selecting enemy Pokemon until it is different than the user Pokemon
        while(user == enemy)
        {
         enemy = randomPokemon(allPokemon);   
        }
        // Send the selections to the Pokemon battle method
        pokemonBattle(user,enemy);
    }
    
    // Simply prints the Welcome Message
    public static void welcomeMessage()
    {
     System.out.println("Welcome to the Pokemon battle simulator! Now featuring types, physical attacks, special attacks, and stat modifying moves!");
    }
    
    // Allows the user to select any Pokemon based on its index in the allPokemon array
    public static Pokemon choosePokemon(Pokemon[] ap)
    {
        System.out.println("Time to choose your Pokemon!");
        int index;
        for(index = 0; index < ap.length; index++)
        {
          System.out.println("Press " + index + " to select " + ap[index].getName());  
        }
        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
        System.out.println("You selected " + ap[selection].getName());
        return ap[selection];
    }
    
    // Selects a random Pokemon for the generated enemy
    public static Pokemon randomPokemon(Pokemon[] ap)
    {
     int length = ap.length;
     Random rand = new Random();
     int selection = rand.nextInt(length);
     return ap[selection];
    }
    
    // While loop where the Pokemon Battle takes place until someone wins
    public static void pokemonBattle(Pokemon user, Pokemon target)
    {
        System.out.println("Let the battle begin!");
        // Will be used to select a random move to be used by the enemy
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        // Continue until either the user or the target goes below 0 health points
        while(user.getHp() > 0 && target.getHp() > 0)
        {
        printPokemon(user,target); // prints the Pokemon names and current HP
        int userMoveSelection = moveSelection(user); // allow the user to select one of the user Pokemons four moves
        Move m1 = user.getMove(userMoveSelection); // Saves the user selected move
        int targetMoveSelection = rand.nextInt(4); // Selects a random move for the enemy
        Move m2 = target.getMove(targetMoveSelection);
        // The speed stat determines who attacks first
        // If the user's speed is higher than the enemy's speed, the user goes first
        if(user.getSpeed() >= target.getSpeed())
        {
            System.out.println(user.getName() + " used " + m1.getMoveName());
            m1.useMove(user,target); // Sends Pokemon objects to the useMove function
            scan.nextLine(); // Makes the user hit enter
            if(target.getHp() <= 0) // if the attack lowers the enemy's HP to below 0, break out of the while loop
            {
             System.out.println(target.getName() + " fainted!");
             break;
            }
            System.out.println(target.getName() + " used " + m2.getMoveName());
            m2.useMove(target,user); // Sends Pokemon objects to the useMove function
            scan.nextLine(); // Makes the user hit enter
            if(user.getHp() <= 0) // if the attack lowers the user's HP to below 0, break out of the while loop
            {
             System.out.println(user.getName() + " fainted!");
             break;
            }
            
        }
        // If the target's speed is higher than the user's speed, skip to this block
        else
        {
            System.out.println(target.getName() + " used " + m2.getMoveName());
            m2.useMove(target,user);
            scan.nextLine();
            if(user.getHp() <= 0) // if the attack lowers the user's HP to below 0, break out of the while loop
            {
             System.out.println(user.getName() + " fainted!");
             break;
            }
            System.out.println(user.getName() + " used " + m1.getMoveName());
            m1.useMove(user,target);
            scan.nextLine();
            if(target.getHp() <= 0) // if the attack lowers the enemy's HP to below 0, break out of the while loop
            {
             System.out.println(target.getName() + " fainted!");
             break;
            }
        }
        
       }
    }
    
    // Prints the battle screen
    public static void printPokemon(Pokemon user, Pokemon target)
    {
     System.out.println("         " + target.getName() + " HP: " + target.getHp());
     System.out.println();
     System.out.println();
     System.out.println();
     System.out.println(user.getName() + " HP: " + user.getHp());
    }
    
    // Sends the index of the user selected move to the Pokemon Battle
    public static int moveSelection(Pokemon user)
    {
     Scanner scan = new Scanner(System.in);
     int loc;
     // Prints the 4 moves to select between
     for(loc = 0; loc < 4; loc++)
     {
         Move m = user.getMove(loc);
         System.out.println(loc + ": " + m.getMoveName());
        }
     // User inputted index of the Pokemon's move
     int selection = scan.nextInt();
     return selection;
    }
    
}
