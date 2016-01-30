package edu.ucsb.cs56.w16.drawings.nivek325.advanced;

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
    /** Draw a picture with a few slices of cheese 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	SwissCheese sc1 = new SwissCheese(75,75,100);
	g2.setColor(Color.BLACK); g2.draw(sc1);

	
	Shape sc2 = ShapeTransforms.scaledCopyOf(sc1,3.0,3.0);
	sc2 = ShapeTransforms.translatedCopyOf(sc2,200.0,0.0);
	sc2 = ShapeTransforms.rotatedCopyOf(sc2, Math.PI/2);
	g2.draw(sc2);

	Shape sc3 = ShapeTransforms.scaledCopyOf(sc1,1.5,1.5);
	sc3 = ShapeTransforms.translatedCopyOf(sc3,-25,175);
	sc3 = ShapeTransforms.rotatedCopyOf(sc3, Math.PI/4);
	g2.draw(sc3);

	g2.setColor(Color.BLACK);
	g2.drawString("Scaled, rotated, and translated swiss cheese. , Kevin Lee", 30,30);
    }
    
    
    /** Draw a picture with a few cheeses
     */
    public static void drawPicture2(Graphics2D g2) {
	Stroke orig=g2.getStroke();
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	// Draw some cheese slices.
	
	SwissCheese sc1 = new SwissCheese(30,30,200);
	g2.setColor(Color.GREEN);
	g2.setStroke(thick);  
	g2.draw(sc1);
	
	Shape sc2 = ShapeTransforms.translatedCopyOf(sc1, 220, 220);
	sc2 = ShapeTransforms.rotatedCopyOf(sc2, Math.PI/2);
	g2.setColor(Color.BLACK); 
	g2.draw(sc2);
	
	SwissCheese sc3 = new SwissCheese(250, 30, 200);
	g2.setColor(Color.CYAN);
	g2.draw(sc3);

	Shape sc4 = ShapeTransforms.translatedCopyOf(sc3, -220, 220);
	g2.setColor(Color.RED);
	g2.draw(sc4);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Translated and colored cheese, Kevin Lee", 20,20);
    }

    
    public static void drawPicture3(Graphics2D g2) {
	Stroke orig=g2.getStroke();
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	// label the drawing
	SwissCheese sc1 = new SwissCheese(30,30,150);
	g2.setColor(Color.GREEN);
	g2.setStroke(thick);  
	g2.draw(sc1);
	
	Shape sc2 = ShapeTransforms.translatedCopyOf(sc1, 200, 0);
	sc2 = ShapeTransforms.scaledCopyOf(sc2, 0.75, 0.75);
	sc2 = ShapeTransforms.rotatedCopyOf(sc2, Math.PI/4);
	g2.setColor(Color.BLACK);
	g2.draw(sc2);

	Shape sc3 = ShapeTransforms.translatedCopyOf(sc1, 0, 200);
	sc3 = ShapeTransforms.scaledCopyOf(sc3, 1.25, 1.25);
	sc3 = ShapeTransforms.rotatedCopyOf(sc3, Math.PI/3);
	g2.setColor(Color.CYAN);
	g2.draw(sc3);

	Shape sc4 = ShapeTransforms.translatedCopyOf(sc1, 200, 200);
	sc4 = ShapeTransforms.scaledCopyOf(sc4, 0.5, 0.5);
	sc4 = ShapeTransforms.rotatedCopyOf(sc4, Math.PI/2);
	g2.setColor(Color.YELLOW);
	g2.draw(sc4);
	

	g2.setColor(Color.BLACK);
	g2.setStroke(orig);
	g2.drawString("Translated, rotated, scaled, and colored cheese!, Kevin Lee", 20,20);
	
	
	// Draw some coffee cups.
	
	
    }       
}
