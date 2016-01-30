package edu.ucsb.cs56.w16.drawings.xiaohe.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a little girl that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Xiaohe He
   @version for CS56, W16, UCSB
   
*/
public class LittleGirl extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of the framing rectangle of the girl
       @param y y coord of lower left corner of the framign rectangle of the girl
       @param width width of the girl
       @param height of the girl
    */
    public LittleGirl(double x, double y, double width, double height)
    {

        
        double faceWidth = .90 * width;
        double faceLength = .33 * height;
        
        double bodyLength = .33 * height;
       
        
        Ellipse2D.Double face = 
            new Ellipse2D.Double(x + width*0.05, y,
				   faceWidth, faceLength);
        
        Line2D.Double body1 = 
            new Line2D.Double (x, y + faceLength + bodyLength,
                               x + width/2.0, y + faceLength);
	
        Line2D.Double body2 =
            new Line2D.Double (x + width, y + faceLength + bodyLength,
                               x + width/2.0, y + faceLength);

	Line2D.Double body3 =
	    new Line2D.Double (x, y + faceLength + bodyLength,
			       x + width, y + faceLength + bodyLength);

	Line2D.Double leftLeg =
	    new Line2D.Double (x + width/3.0, y + faceLength + bodyLength,
			       x + width/3.0, y + height);

       	Line2D.Double rightLeg =
	    new Line2D.Double (x + width*2/3.0, y + faceLength + bodyLength,
			       x + width*2/3.0, y + height);
	
        // put the whole house together
	
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(face, false);
        wholeHouse.append(body1, false);
        wholeHouse.append(body2, false);
	wholeHouse.append(body3, false);
	wholeHouse.append(leftLeg, false);
	wholeHouse.append(rightLeg, false);
    }
}

//import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
//import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
