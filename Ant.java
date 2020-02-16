//	Abel Kassa
//	6/5/2019
//	CSE142
//	TA: Daniel He
//	Section:	BE
//	HW	#8: Critters

//	This object makes the ant critter class which always eats and 
// scratches. The ants movements are dependent on the moveCount and
// the symbol for ant is %.

import java.awt.*;

public class Ant extends Critter {
   private boolean walkSouth;
   private int moveCount;
   private boolean hungry;
   
   public Ant (boolean walkSouth) {
      this.walkSouth = walkSouth;
      moveCount = -1;
      
   }
   
   // Ant always eats, so returns true at all times
   public boolean eat() {
      if (hungry){
         return true;
      }
      return true;
   }
   
   // Ant attacks by scratching, returns Attack.SCRATCH
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   // Ants direction of movement depends on if moveCount is even or odd,
   // returns direction of Ant
   public Direction getMove() {
      moveCount++;
      if (moveCount % 2 == 1) {
         return Direction.EAST;
      }
      if (walkSouth) {
         return Direction.SOUTH;      
      }else{
         return Direction.NORTH;     
      }   
   }
   
   // Sets Ant color to red, returns color red
   public Color getColor() {
      return Color.RED;
   }
   
   // Makes Ant symbol into %, returns % symbol
   public String toString() {
      return "%";
   }
}