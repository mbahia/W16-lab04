package edu.ucsb.cs56.w16.drawings.samuelechu.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
/**
   A Watch
      
   @author Phill Conrad
   @author Samuel Chu
   @version for CS56, W16, UCSB
   
*/
public class Watch extends Clock implements Shape
{
    /**
     * Constructor for objects of class Watch
     */
    public Watch(double x, double y, double R)
    {
	// construct the basic house shell
	super(x, y, R);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;
	
	
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeWatch = this.get();
        
	double theta = Math.toRadians(30);
	double x1 = x - (R - R * .1) * Math.sin(theta);
	double y1 = y - (R - R * .1) * Math.cos(theta);
	wholeWatch.moveTo(x1, y1);
	wholeWatch.lineTo(x1, y1 - R * 4);

	wholeWatch.moveTo((x1 - x)*-1 + x, y1);
	wholeWatch.lineTo((x1 - x)*-1 + x, y1 - R * 4);

	wholeWatch.moveTo(x1, y1 - R * 4);
	wholeWatch.lineTo((x1 - x)*-1 + x, y1 - R * 4);

	

	double y2 = (y1 - y)*-1 + y;
	wholeWatch.moveTo(x1, y2);
	wholeWatch.lineTo(x1, y2 + R * 4);

	wholeWatch.moveTo((x1 - x)*-1 + x, y2);
	wholeWatch.lineTo((x1 - x)*-1 + x, y2 + R * 4);

	wholeWatch.moveTo(x1, y2 + R * 4);
	wholeWatch.lineTo((x1 - x)*-1 + x, y2 + R * 4);













    }    
}
