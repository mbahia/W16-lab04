package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few beetles and ladybugs
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Beetle b1 = new Beetle(100,250,10);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black beetle that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a beetle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two ladybugs
	
	LadyBug lb1 = new LadyBug(50,350,40,75);
	LadyBug lb2 = new LadyBug(200,350,40,40);
	
	g2.draw(lb1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(lb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some beetles and ladybugs, by Marvin Shu", 20,20);
    }
    
    
    /** Draw a picture with a few beetles and ladybugs
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some ladybugs.
	
	LadyBug lb01 = new LadyBug(20,50,40,30);
	LadyBug lb02 = new LadyBug(20,150,20,40);
	LadyBug lb03 = new LadyBug(20,100,100,20);
	
	g2.setColor(Color.GREEN);   g2.draw(lb01);
	g2.setColor(Color.BLUE);    g2.draw(lb02);
	g2.setColor(Color.MAGENTA); g2.draw(lb03);
	
	Beetle b1 = new Beetle(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black beetle that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a beetle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two ladybugs
	
	LadyBug lb1 = new LadyBug(50,350,40,75);
	LadyBug lb2 = new LadyBug(200,350,100,50);
	
	g2.draw(lb1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second beetle 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(lb2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("LadyBugs and Beetles by Marvin Shu", 20,20);
    }
    
    /** Draw a different picture with a few ladybugs
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A couple of ladybugs", 20,20);
	
	
	// Draw some ladybugs.
	
	LadyBug large = new LadyBug(100,50,225,150);
	LadyBug smallCC = new LadyBug(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
