package edu.ucsb.cs56.w16.drawings.ayung.advanced;

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
 * @author Angela Yung
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Doll d1 = new Doll(100,250,100);
	g2.setColor(Color.PINK); g2.draw(d1);
	
	// 1/2x sized doll moved over 150 pixels in x direction
	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	

	// 4x sized doll moved over 300 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// draw doll with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	

	
	//signed and labeled	
	g2.setStroke(thick);
	g2.setColor(Color.BLACK); 
	g2.drawString("A doll family by Angela Yung", 20,20);
    }
    
    
    /** Draw a picture with a few voodoo dolls
     */
    public static void drawPicture2(Graphics2D g2) {
	// Draw two voodoo dolls
	
	VoodooDoll vd1 = new VoodooDoll(50,50,40);
	VoodooDoll vd2 = new VoodooDoll(200,100,200);
	
	g2.setColor(Color.RED);           g2.draw(vd1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(vd2);
	
	Shape vd3 = ShapeTransforms.scaledCopyOfLL(vd2,2,2);
	vd3 = ShapeTransforms.translatedCopyOf(vd3,300,300);
	g2.setColor(Color.BLACK); g2.draw(vd3);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(vd3); 
	
		
	// Sign and label
	g2.setColor(Color.BLACK); 
	g2.drawString("Perspective: voodoo dolls", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	g2.drawString("An incomplete satanic circle of voodoo dolls", 20,20);
	
	
	VoodooDoll vd1 = new VoodooDoll(200,100,200);
	g2.setColor(Color.BLACK); g2.draw(vd1);
	
	// Rotate 45 degrees around
	Shape vd2 = ShapeTransforms.rotatedCopyOf(vd1, Math.PI/4.0);
	vd2 = ShapeTransforms.translatedCopyOf(vd2,100, 40);
	g2.draw(vd2);

	// Rotate 45 degrees other way
	Shape vd3 = ShapeTransforms.rotatedCopyOf(vd1, -Math.PI/4.0);
	vd3 = ShapeTransforms.translatedCopyOf(vd3,-100,40);
	g2.draw(vd3);
     
	
    }       
}
