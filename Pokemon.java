
/**
 * Matt Micale
 * Pokemon Class
 * 8/13/2020
 */
public class Pokemon
{
    // Global variables for Pokemon objects
    // Each stat has a stage that changes throughout a signle battle and determines the stat
    public String pokeName;
    public Type type1;
    public double startingHp;
    public double attack;
    public int attackStage = 0;
    public double specialAttack;
    public int specialAttackStage = 0;
    public double defense;
    public int defenseStage = 0;
    public double specialDefense;
    public int specialDefenseStage = 0;
    public double speed;
    public int speedStage = 0;
    public Move[] moves = new Move[4];
    int moveLoc = 0;
    double currentHp;
    
    // Constructor for Pokemon object that takes in all base stats
    public Pokemon(String pn, Type t1, double hp, double a, double sa, double d, double sd, double s)
    {
        pokeName = pn;
        type1 = t1;
        startingHp = hp;
        attack = a;
        specialAttack = sa;
        defense = d;
        specialDefense = sd;
        speed = s;
        currentHp = startingHp;
    }
    
    // Method used by the Pokedex class to connect this Pokemon to four different moves
    public void addMove(Move m)
    {
     if(moveLoc < 4)
     {
      moves[moveLoc] = m;
      moveLoc++;
        }
    }
    
    public String getName()
    {
     return pokeName;   
    }
    
    // A series of set and get methods that return this Pokemons stat based on the stat's stage
    // Stage cannot be greater than 6 or less than -6
    
    public double getAttack()
    {
     return getStat(attack,attackStage);   
    }
    
    public void setAttackStage(int modifier)
    {
      if(attackStage < 6 && attackStage > -6)
      attackStage = attackStage + modifier;  
    }
    
    public double getDefense()
    {
     return getStat(defense,defenseStage);   
    }
    
    public void setDefenseStage(int modifier)
    {
     if(defenseStage < 6 && defenseStage > -6)
     defenseStage = defenseStage + modifier;   
    }
    
    public double getSpecialAttack()
    {
     return getStat(specialAttack,specialAttackStage);   
    }
    
    public void setSpecialAttackStage(int modifier)
    {
     if(specialAttackStage < 6 && specialAttackStage > -6)
     specialAttackStage = specialAttackStage + modifier;
    }
    
    public double getSpecialDefense()
    {
     return getStat(specialDefense,specialDefenseStage);   
    }
    
    public void setSpecialDefenseStage(int modifier)
    {
     if(specialDefenseStage < 6 && specialDefenseStage > -6)
     specialDefenseStage = specialDefenseStage + modifier;   
    }
    
    public double getSpeed()
    {
     return getStat(speed,speedStage);   
    }
    
    public void setSpeedStage(int modifier)
    {
     if(speedStage < 6 && speedStage > -6)
     speedStage = speedStage + modifier;   
    }
    
    public Type getType()
    {
     return type1;   
    }
    
    // Returns this Pokemon's HP to the battle
    // Conversion to int for enhanced readability
    public int getHp()
    {
     return (int)currentHp;   
    }
    
    // Used by the useMove method to inflict damage to thiss Pokemon
    public void setHp(double damage)
    {
     currentHp = currentHp - damage;   
    }
    
    // Sends the move chosen to the Pokemon battle
    public Move getMove(int index)
    {
     return moves[index];   
    }
    
    // Calculates this Pokemon's current stat based on the stat stage
    // The higher the stage, the higher the stat
    // The lower the stage, the lower the stat
    public double getStat(double stat, int stage)
    {
        // A max of 6 stages
        if(stage > 6)
        {
         return stat*4;   
        }
        // A minimum of -6 stages
        else if(stage < -6)
        {
         return stat*.25;   
        }
        switch(stage)
        {
         case -6:
         return stat*.25;
         case -5:
         return stat*.285;
         case -4:
         return stat*.33;
         case -3:
         return stat*.4;
         case -2:
         return stat*.5;
         case -1:
         return stat*.66;
         case 0:
         return stat;
         case 1:
         return stat*1.5;
         case 2:
         return stat*2;
         case 3:
         return stat*2.5;
         case 4:
         return stat*3;
         case 5:
         return stat*3.5;
         case 6:
         return stat*4;
         default:
         return stat;
        }
    }
    
    // Method used at the end of a battle to reset this Pokemon's stats
    public void resetStats()
    {
     currentHp = startingHp;
     attackStage = 0;
     defenseStage = 0;
     specialAttackStage = 0;
     specialDefenseStage = 0;
     speedStage = 0;
    }
}
