package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;
import java.awt.geom.GeneralPath;

import edu.ucsb.cs56.w16.drawings.marvinshu.simple.Circle;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A basketball for the animation
      
   @author Marvin Shu
   @version for CS56, W16, UCSB
   
*/
public class Basketball extends GeneralPathWrapper
{
     /**
       Constructor
       @param x the x coord of the basketball
       @param y the y coord of the basketball
    **/
    public Basketball(double x, double y)
    {
	Circle ball = new Circle(x+45,y+75,15);

	GeneralPath guy = this.get();
	guy.append(ball,false);
    }
}
