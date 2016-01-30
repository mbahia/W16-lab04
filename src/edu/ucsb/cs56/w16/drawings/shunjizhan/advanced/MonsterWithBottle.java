package edu.ucsb.cs56.w16.drawings.shunjizhan.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   Monster Drink
      
   @author Shunji Zhan 
   @version for CS56, W16, UCSB
   
*/
public class MonsterWithBottle extends Monster implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public MonsterWithBottle(double x, double y, double width, double height)
    {
	// construct the Monster logo
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// build the bottle
        double newx = x-width/3;
	double newy = y-height/3;
	double newwidth = 2*width;
	double newheight = 2*height;
	
	Rectangle2D.Double bottle =
	    new Rectangle2D.Double(newx,newy, newwidth,newheight);
       	
        GeneralPath wholeMonster = this.get();
        wholeMonster.append(bottle, false);
        
    }    
}
