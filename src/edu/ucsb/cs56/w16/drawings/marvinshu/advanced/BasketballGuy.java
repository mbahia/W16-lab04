package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;
import edu.ucsb.cs56.w16.drawings.marvinshu.simple.Circle;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A basketball guy for the animation
      
   @author Marvin Shu
   @version for CS56, W16, UCSB
   
*/
public class BasketballGuy extends GeneralPathWrapper
{
    /**
       Constructor
       @param x the x coord of basketball guy
       @param y the y coord of basketball guy
    **/
    public BasketballGuy(double x, double y)
    {
	Circle head = new Circle(x,y,25);
	Line2D.Double body = new Line2D.Double(x,y+25,x,y+100);
	Line2D.Double leftArm = new Line2D.Double(x,y+50,x-40,y+75);
	Line2D.Double leftLeg = new Line2D.Double(x,y+100,x-25,y+125);
	Line2D.Double rightLeg = new Line2D.Double(x,y+100,x+25,y+125);
	
	GeneralPath guy = this.get();
	guy.append(head,false);
	guy.append(body,false);
	guy.append(leftArm,false);
	guy.append(leftLeg,false);
	guy.append(rightLeg,false);
    }
}
