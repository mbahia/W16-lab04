package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a blade that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jimmy Le 
   @version for CS56, W16, UCSB
   
*/
public class Blade extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of blade
       @param y y coord of lower left corner of blade
       @param width width of the blade
       @param height of blade (including the point)
    */
    public Blade(double x, double y, double width, double height)
    {

        // Make the Main body of the Blade
        Line2D.Double bottomOfBlade = 
          new Line2D.Double(x, y, x + width, y);
        
        Line2D.Double leftOfBlade = 
          new Line2D.Double(x, y, x, y - height * (.8));
        
        Line2D.Double rightOfBlade = 
          new Line2D.Double(x + width, y,
                            x + width,y - height * (.8));

        // Make the point of the blade
        Line2D.Double leftOfPoint =
         new Line2D.Double(x, y - height * (.8),
                           x + width/2,y - height);

        Line2D.Double rightOfPoint =
          new Line2D.Double(x + width, y - height * (.8),
                            x + width/2, y - height);

        // Make middle of the blade
        Line2D.Double middle =
         new Line2D.Double(x + width/2, y, x + width/2,
                           y - height *(.8));

        // Put all the pieces together
        GeneralPath wholeBlade = this.get();
        wholeBlade.append(bottomOfBlade,false);
        wholeBlade.append(leftOfBlade,false);
        wholeBlade.append(rightOfBlade,false);

        wholeBlade.append(leftOfPoint,false);
        wholeBlade.append(rightOfPoint,false);

        wholeBlade.append(middle,false);

    }
}
