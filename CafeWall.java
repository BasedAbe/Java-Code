// Abel Kassa
// 4/21/2019
// CSE142
// TA: Daniel He
// Section: BE
// HW #3: Cafe Wall

// This program produces rows and grids that appear to be an illusion when the location shift.

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
   public static void main (String[] args){     
      DrawingPanel panel = new DrawingPanel(650,400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      drawRow(g,4,20,0,0);
      drawRow(g,5,30,50,70);
      
      drawGrid(g,4,25,10,0,150); 
      drawGrid(g,5,20,425,10,180);
      drawGrid(g,3,25,250,10,200);
      drawGrid(g,2,35,400,35,20);
 
   }
   
   //Makes the groundwork for the grids size, location, number of boxes, and offsets
   public static void drawGrid(Graphics g, int numBox, int size, int startX, int offset, int startY){
      for(int i=0; i<numBox; i++){
         drawRow(g,numBox,size,startX,startY);   
         drawRow(g,numBox,size,startX+offset,startY+size+MORTAR);
         startY += 2*(size+MORTAR);
      }
   }
   
   //Makes the groundwork for the rows size, location, and number of boxes
   public static void drawRow(Graphics g, int numBox, int size, int startX, int startY) {
      for (int i = 0; i < numBox; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(i * size * 2 + startX, startY, size, size);
         g.setColor(Color.WHITE);
         g.fillRect(i* size * 2 + startX + size, startY, size, size);            
      }
   }
}