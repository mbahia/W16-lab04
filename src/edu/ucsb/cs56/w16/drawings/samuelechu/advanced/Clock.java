package edu.ucsb.cs56.w16.drawings.samuelechu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a clock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author Samuel Chu
   @version for CS56, W16, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of clock center
       @param y y coord of clock center
       @param R radius of clock
       @param shortHandAt location of short clock hand
    */


private double theta = 0.0;

public void setTheta(double degrees) {
	theta = Math.toRadians(degrees);
}
    public Clock(double x, double y, double R, double shortHandAt)
    {
	//R = Outer Radius
	//r = inner Radius (start of tick line)

	//shortHandAt - double between 0 and 12

        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	//distance from center to start drawing tick
	double r = R/1.4;        
	 

        Circle clockFace = 
            new Circle
            (
	     x,
	     y,
	     R
	     );
        
        GeneralPath wholeClock = this.get();
        wholeClock.append(clockFace, false);

	//draw Tickmarks
	for(int i = 0; i < 12; i++){
	
		setTheta(30 * i);
		

	
		wholeClock.moveTo(x - (R - R * .1) * Math.cos(theta), y - (R - R * .1) * Math.sin(theta));
		wholeClock.lineTo(x - r * Math.cos(theta), y - r * Math.sin(theta));
		
	}  



//set clock hands
//0 = hand at 9
	setTheta(30 * (shortHandAt + 3));
	//short clock hand at 1
	wholeClock.moveTo(x - (R - R * .4) * Math.cos(theta), y - (R - R * .4) * Math.sin(theta));
	wholeClock.lineTo(x, y);

	
	setTheta(360 * (shortHandAt - (int)shortHandAt) + 30 * 3);
	//long clock hand at 9
	wholeClock.moveTo(x - (R - R * .1) * Math.cos(theta), y - (R - R * .1) * Math.sin(theta));
	wholeClock.lineTo(x, y);
 
	
    }
}
