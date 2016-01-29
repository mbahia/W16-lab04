package edu.ucsb.cs56.w16.drawings.wkzhuang.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad (original file)
 * @author Weikun Zhuang
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /**
     Draw a picture with different sizes of a big circle with two smaller
     and identical circles inside
     */
    
    public static void drawPicture1(Graphics2D g2) {

	CircleWithTwoSmallerOnes c1 = new CircleWithTwoSmallerOnes(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(c1);

	// Make a black Circle w/ two smaller circles that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a Circle w/ two smaller circles that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 

	// add a message
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Circles by Weikun Zhuang", 20,20);
    }
    
    /** Draw a picture with Yin-Yang symbols
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// label and add a message                                             
        g2.drawString("A bunch of Yin-Yang Symbols by Weikun Zhuang", 20,20);

	// Draw a bunch of  Yin-Yang symbol
	
	YinYangSymbol yy1 = new YinYangSymbol(50,350,40);
	YinYangSymbol yy2 = new YinYangSymbol(200,350,100);
	
	g2.draw(yy1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(yy2);
	
	YinYangSymbol yy3 = new YinYangSymbol(500,200,125);
	YinYangSymbol yy4 = new YinYangSymbol(250,100,40);
	
	g2.setColor(Color.RED);     g2.draw(yy3);
	g2.setColor(Color.GREEN);   g2.draw(yy4);

    }
    

    /** Draw a different picture with different Yin-Yang symbols
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Another bunch of Yin-Yang by Weikun Zhuang", 20,20);
	
	
	YinYangSymbol y1 = new YinYangSymbol(500,300,100);
	YinYangSymbol y2 = new YinYangSymbol(150,100,40);
	
	g2.setColor(Color.BLUE);   g2.draw(y1);
	g2.setColor(Color.CYAN);   g2.draw(y2);
	
	// Rote the second one by 45 degrees around its center.
	Shape y3 = ShapeTransforms.rotatedCopyOf(y2, Math.PI/4.0);
	g2.draw(y3);
	
    }       
}
