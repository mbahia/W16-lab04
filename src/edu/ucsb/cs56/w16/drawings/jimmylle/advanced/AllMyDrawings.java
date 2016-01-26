package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;

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
 * @author Jimmy Le
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture of a few blades and swords
     */
    
    public static void drawPicture1(Graphics2D g2) {

  // Draw a blue blade
  Blade b1 = new Blade(100,350,25,200);
  g2.setColor(Color.BLUE); g2.draw(b1);

  // Draw a red Sword
  Sword s1 = new Sword(400,300,30,240);
  g2.setColor(Color.RED); g2.draw(s1);

  // Draw a green sword
  Sword s2 = new Sword(200,150,10,40);
  g2.setColor(Color.GREEN); g2.draw(s2);

  // Draw a orange blade 1/3 the size of the blue blade
  // Shift it right 150 and down 40
  Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,.33,.33);
  b2 = ShapeTransforms.translatedCopyOf(b2,150,40);
  g2.setColor(Color.ORANGE); g2.draw(b2);

  // Draw a black blade 1.5 times the size of the blue blade
  // Shift it right 400 and up 50
  Shape b3 = ShapeTransforms.scaledCopyOfLL(b1,1.5,1.5);
  b3 = ShapeTransforms.translatedCopyOf(b3,400,-50);
  g2.setColor(Color.BLACK); g2.draw(b3);


  // A Line telling what's in the drawing
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of blades and swords by Jimmy Le", 20,20);

    }
    
    
    /** Draw a picture with a bunch of blades and swords
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some blades.
	
	Blade b1 = new Blade(50,100,10,30);
	Blade b2 = new Blade(400,200,100,40);
	Blade b3 = new Blade(200,200,200,150);
	Blade b4 = new Blade(125,350,50,120);
	
	g2.setColor(new Color(0x2e8b57)); g2.draw(b1);
	g2.setColor(new Color(0x152d3e)); g2.draw(b2);
	g2.setColor(new Color(0x8a2be2)); g2.draw(b3);
	g2.setColor(new Color(0xb20d47)); g2.draw(b4);
	
	Sword s1 = new Sword(10,255,70,95);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a sword 3/4 the size of s1 
	// and move it over 250 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.75,0.75);
	s2 = ShapeTransforms.translatedCopyOf(s2,250,0);
	g2.setColor(new Color(0x081212)); g2.draw(s2);
	
	// Make a sword that's 2 times as big as s2
	// and moved over 60 pixels to the right and
	// 100 pixels down
	Shape s3 = ShapeTransforms.scaledCopyOfLL(s2,2,2);
	s3 = ShapeTransforms.translatedCopyOf(s3,60,100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x341919)); 
	g2.draw(s3); 
	
	// Draw a rotated 135 degree sword
	Sword s4 = new Sword(500,75,40,120);
	g2.setColor(new Color(0xf13477));
	Shape s5 = ShapeTransforms.rotatedCopyOf(s4, Math.PI*(3/4.0));
	g2.draw(s5);
	
	
	// Label that tells what's in the drawing
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of blades and a bunch of swords by Jimmy Le", 20,20);
    }
    
    /** Draw a different picture with swords
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// Label that tells what's in the drawing
	g2.drawString("Swords in cool positions by Jimmy Le", 20,20);
	
	// Draw some swords
	Sword s1 = new Sword(300,250,20,200);
	Sword s2 = new Sword(300,250,20,200);
	Sword s3 = new Sword(300,250,20,200);
	
	g2.setColor(new Color(0x1c67ef));
	Shape s4 = ShapeTransforms.rotatedCopyOf(s1,Math.PI*(11/16.0));
	g2.draw(s4);

	g2.setColor(new Color(0x67ef1c));
	Shape s5 = ShapeTransforms.rotatedCopyOf(s2,Math.PI*(-11/16.0));
	g2.draw(s5);

	g2.setColor(new Color(0xef1c67));
	g2.draw(s3);
	
    }       
}
