package edu.ucsb.cs56.w16.drawings.xiaohe.advanced;

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
    /** Draw a picture with a few girls
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	LittleGirl girl1 = new LittleGirl(100,250,50,150);
	g2.setColor(Color.CYAN); g2.draw(girl1);
       
	
	Shape girl2 = ShapeTransforms.scaledCopyOfLL(girl1,0.5,0.5);
	girl2 = ShapeTransforms.translatedCopyOf(girl2,150,0);
	g2.setColor(Color.BLACK); g2.draw(girl2);

	Shape girl3 = ShapeTransforms.scaledCopyOfLL(girl2,4,4);
        girl3 = ShapeTransforms.translatedCopyOf(girl3,150,0);
	

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(girl3); 

	GirlWithHeels gw1 = new GirlWithHeels(350,30,40,120);
	GirlWithHeels gw2 = new GirlWithHeels(350,200,70,210);
	
	g2.draw(gw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(gw2);

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few girls by Xiaohe He", 20,20);
    }
    
    
    /** Draw a picture with a few weird and drunk girls
     */
    public static void drawPicture2(Graphics2D g2) {
	
	
        LittleGirl large = new LittleGirl(100,50,100,270);
	LittleGirl smallCC = new LittleGirl(20,50,20,50);
	LittleGirl tallSkinny = new LittleGirl(20,150,30,150);
	LittleGirl shortFat = new LittleGirl(20,250,50,90);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
        LittleGirl h1 = new LittleGirl(100,250,35,75);
	g2.setColor(Color.CYAN); g2.draw(h1);

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);

	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 

	
        GirlWithHeels hw1 = new GirlWithHeels(50,350,40,75);
        GirlWithHeels hw2 = new GirlWithHeels(200,350,30,80);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	

	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few weird and drunk girls by Xiaohe He", 20,20);
    }
    
    /** Draw a different picture with some tall girls with heels
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Some tall girls with heels by Xiaohe he", 20,20);
	
	
	// Draw some coffee cups.
	
        GirlWithHeels large = new GirlWithHeels(100,50,40,160);
        GirlWithHeels smallCC = new GirlWithHeels(20,50,50,280);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
