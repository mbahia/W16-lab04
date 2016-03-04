package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;

import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A basketball guy's arm for the animation
      
   @author Marvin Shu
   @version for CS56, W16, UCSB
   
*/
public class Arm extends GeneralPathWrapper
{
     /**
       Constructor
       @param x the x coord of the arm
       @param initY the initial y coord of the arm
       @param newY the new updated y coord of the arm
    **/
    public Arm(double x, double initY, double newY)
    {
	Line2D.Double arm = new Line2D.Double(x,initY,x+50,newY);
	
	GeneralPath rightArm = this.get();
	rightArm.append(arm,false);
    }
}
