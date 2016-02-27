package edu.ucsb.cs56.w16.drawings.saber.advanced;

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
 * @author Shaoyi Zhang 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few sabers 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Saber s1 = new Saber(100,250,50,150);
	g2.setColor(Color.BLACK); g2.draw(s1);
	

	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	

	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	g2.drawString("A few sabers by Shaoyi Zhang", 20,20);
    }
    
    
    /** Draw a picture with a few Saber with avalons
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some saber with avalon.
	
	SaberWithAvalon large = new SaberWithAvalon(100,50,50,275,150,50);
	SaberWithAvalon smallCC = new SaberWithAvalon(350,50,70,350,400,50);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.BLUE);   g2.draw(smallCC);
	
	

	Shape h2 = ShapeTransforms.scaledCopyOfLL(large,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	

	h2 = ShapeTransforms.scaledCopyOfLL(smallCC,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,200);
	
	
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	 
	g2.drawString("A bunch of Saber with their avalons by Shaoyi Zhang", 20,20);
    }
    
    /** Draw a different picture with a few saber and avalons
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Saber out of avalon by Shaoyi Zhang", 20,20);
	
	
	// Draw some sabers with avalon.
	
	SaberWithAvalon large = new SaberWithAvalon(100,50,50,300,150,50);
	SaberWithAvalon smallCC = new SaberWithAvalon(300,200,100,500,350,300);
	Shape d1 = ShapeTransforms.scaledCopyOfLL(large,1,1);
	Shape d2 = ShapeTransforms.scaledCopyOfLL(smallCC,0.5,0.5);
	//double degreeInRadian = angle*3.14159/180;
	d1 = ShapeTransforms.rotatedCopyOf(d1,30*3.14159/180);
	d2 = ShapeTransforms.rotatedCopyOf(d2,-60*3.14159/180);
	g2.setColor(Color.RED);     g2.draw(d1);
	g2.setColor(Color.BLACK);   g2.draw(d2);
	
    }       
}
