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
        double newx = x-width/2;
	double newy = y-height/2;
	double newwidth = 2*width;
	double newheight = 2*height;
	
	Rectangle2D.Double line1 =
	    new Rectangle2D.Double(newx,newy, newx+newwidth,newy);
	Rectangle2D.Double line2 =
	    new Rectangle2D.Double(newx,newy, newx,newy+newheight);
	Rectangle2D.Double line3 =
	    new Rectangle2D.Double(newx,newy+newheight, newx+newwidth,newy+newheight);
	Rectangle2D.Double line4 =
	    new Rectangle2D.Double(newx+newwidth,newy, newx+newwidth,newy+newheight);
        
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeMonster = this.get();
        wholeMonster.append(line1, false);
        //wholeMonster.append(line4, false);
        //wholeMonster.append(line3, false);
	//wholeMonster.append(line2, false); 
    }    
}
