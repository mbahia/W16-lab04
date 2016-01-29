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
    */
    public Clock(double x, double y, double R)
    {
	//R = Outer Radius
	//r = inner Radius (start of tick line)



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

	//draw Tickmarks and hands
	for(int i = 0; i < 12; i++){
	
		double theta = Math.toRadians(30 * i);
		
		//long clock hand at 9
		if(i == 0){
			wholeClock.moveTo(x - (R - R * .1) * Math.cos(theta), y - (R - R * .1) * Math.sin(theta));
			wholeClock.lineTo(x, y);
		}


		//short clock hand at 1
		else if(i == 4){
			wholeClock.moveTo(x - (R - R * .4) * Math.cos(theta), y - (R - R * .4) * Math.sin(theta));
			wholeClock.lineTo(x, y);
			wholeClock.moveTo(x - (R - R * .1) * Math.cos(theta), y - (R - R * .1) * Math.sin(theta));
			wholeClock.lineTo(x - r * Math.cos(theta), y - r * Math.sin(theta));
		}

		else{
			wholeClock.moveTo(x - (R - R * .1) * Math.cos(theta), y - (R - R * .1) * Math.sin(theta));
			wholeClock.lineTo(x - r * Math.cos(theta), y - r * Math.sin(theta));
		}
	}   
	
	
		
	
    }
}
