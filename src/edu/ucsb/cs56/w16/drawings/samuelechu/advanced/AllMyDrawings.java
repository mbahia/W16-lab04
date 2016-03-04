package edu.ucsb.cs56.w16.drawings.samuelechu.advanced;

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
 * @author Samuel Chu
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few watches and clocks
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Clock c1 = new Clock(300,250, 30, 3.75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,100,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two watches
	Watch w1 = new Watch(50, 225, 40, 1.5);
	Watch w2 = new Watch(200, 350, 50, 1.5);
	g2.draw(w1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(w2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few timepieces by Samuel Chu", 20,20);
    }
    
    
    /** Draw a picture with a few clocks and a watch
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some watches.
	Clock large = new Clock(150, 200, 100, 1.5);
	Clock small = new Clock(150, 200, 40, 1.5);
	Clock medium = new Clock(150, 200, 75, 1.5);
	//rotate medium 120 degrees
	Shape mediumRotated = ShapeTransforms.rotatedCopyOf(medium, 4 * Math.PI/6.0);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.BLUE);    g2.draw(small);
	g2.setColor(Color.MAGENTA); g2.draw(mediumRotated);
	
	Watch w1 = new Watch(400,250,30, 1.5);
	Shape w1Rotated = ShapeTransforms.rotatedCopyOf(w1, Math.PI/6.0);
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(w1Rotated); 
	
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A collection of clocks and a watch by Samuel Chu", 20,20);
    }
    
    /** Draw a different picture with a square of watches
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A square of Watches by Samuel Chu", 20,20);

	Shape north = new Watch(50, 225, 40, 1.5);
	north = ShapeTransforms.rotatedCopyOf(north, Math.PI/2.0);
	north = ShapeTransforms.translatedCopyOf(north, 40 * 4 , 40 * 4);
	Shape south = new Watch(50, 225, 40, 1.5);
	south = ShapeTransforms.rotatedCopyOf(south, Math.PI/2.0);
	south = ShapeTransforms.translatedCopyOf(south, 40 * 4 , -40 * 4);

	Shape east = new Watch(50, 225, 40, 1.5);
	east = ShapeTransforms.translatedCopyOf(east,40 * 2 * 4,0);
	Watch west = new Watch(50, 225, 40, 1.5);

	

	g2.draw(north); 
	g2.draw(south);
	g2.draw(east);
	g2.draw(west);
	
    }       
}
