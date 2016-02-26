package edu.ucsb.cs56.w16.drawings.nivek325.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a slice of cheese that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Kevin Lee
   @version for CS56, W16, UCSB
   
*/
public class Cheese extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of cheese slice
       @param y y coord of upper left corner of cheese slice
       @param width width of cheese slice
    */
    public Cheese(double x, double y, double width)
    {  
      Rectangle2D.Double slice = 
        new Rectangle2D.Double(x, y, width, width);

      GeneralPath wholeSlice = this.get();
      wholeSlice.append(slice, false);
    }

}
