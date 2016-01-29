package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w16.drawings.marvinshu.simple.Circle;

/**
   A vector drawing of a beetle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Marvin Shu
   @version for CS56, W16, UCSB
   
*/

public class Beetle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       @param x the x coord of the beetle
       @param y the y coord of the beetle
       @param size the size of the beetle
    **/
    public Beetle(double x, double y, double size)
    {
	double headRadius = size;
	double thoraxRadius = 2 * size;
	Arc2D.Double head = new Arc2D.Double(x-headRadius/2,y-headRadius * 2.5
					     ,headRadius,headRadius,
					     0, 180, Arc2D.OPEN);
	Circle thorax = new Circle(x,y,thoraxRadius);
	Line2D.Double leftAntenna = new Line2D.Double(x-headRadius/2.2, y-headRadius*2.3,
						      x-headRadius, y-headRadius *3);
	Line2D.Double rightAntenna = new Line2D.Double(x+headRadius/2.2, y-headRadius*2.3,
							      x+headRadius, y-headRadius *3);
	GeneralPath wholeBug = this.get();
	wholeBug.append(head, false);
	wholeBug.append(thorax,false);
	wholeBug.append(leftAntenna,false);
	wholeBug.append(rightAntenna, false);
    }
}
