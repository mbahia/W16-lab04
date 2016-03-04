
package edu.ucsb.cs56.w16.drawings.shunjizhan.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing Monsters and Pyramids
 * 
 * @author Shunji Zhan 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with Monsters
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Monster m1 = new Monster(100,50,50,75);
	g2.setColor(Color.BLUE); g2.draw(m1);
		
	Shape h2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,100,100);
        g2.setColor(Color.BLACK); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,1.7,3);
	h2 = ShapeTransforms.translatedCopyOf(h2,650,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.RED); 
        g2.draw(h2); 

	
	// Draw two Monster With Bottles
	
	MonsterWithBottle hw1 = new MonsterWithBottle(150,350,140,275);
        MonsterWithBottle hw2 = new MonsterWithBottle(500,230,100,300);

	g2.setColor(Color.BLUE);
        g2.draw(hw1);
	g2.setColor(Color.YELLOW); g2.draw(hw2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.GREEN); 
	g2.drawString("some monsters by Shunji Zhan", 20,20);
    }
    
    
    /** Draw a picture with a few Monsters and Pyramids
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some Pyramids
	
        Pyramid large = new Pyramid(70,50,225,150);
        Pyramid small = new Pyramid(20,30,80,60);
        Pyramid tallSkinny = new Pyramid(30,250,40,80);
        Pyramid shortFat = new Pyramid(20,450,80,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Monster h1 = new Monster(100,150,50,75);
	g2.setColor(Color.ORANGE); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.7,0.9);
	h2 = ShapeTransforms.translatedCopyOf(h2,200,200);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,3,2.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two Monsters With bottles
	
        MonsterWithBottle hw1 = new MonsterWithBottle(50,350,40,75);
        MonsterWithBottle hw2 = new MonsterWithBottle(550,350,100,300);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second monster 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some Monsters and Pyramids by Shunji Zhan", 20,20);
    }
    
    /** Draw a different picture with some pyramids
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("some hurricane pyramid by Shunji Zhan", 30,30);
	
	
	// Draw some pyramid
	
	Pyramid large = new Pyramid(0,100,525,450);
	Pyramid medium = new Pyramid(500,100,325,250);
        Pyramid small = new Pyramid(20,100,40,60);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLACK);   g2.draw(medium);
    }       
}
