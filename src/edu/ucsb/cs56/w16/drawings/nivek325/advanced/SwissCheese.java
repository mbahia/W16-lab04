package edu.ucsb.cs56.w16.drawings.nivek325.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a slice of swiss cheese that implements
   the Shape interface and extends the Cheese class, and 
   so can be drawn, as well as rotated, scaled, etc.
      
   @author Kevin Lee
   @version for CS56, W16, UCSB
   
*/
public class SwissCheese extends Cheese implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of cheese slice
       @param y y coord of upper left corner of cheese slice
       @param width width of cheese slice
    */
    public SwissCheese(double x, double y, double width)
    {  
    super(x,y,width);

    double holeSize1 = 0.10 * width;
    double holeSize2 = 0.15 * width;
    double holeSize3 = 0.20 * width;
    double holeSize4 = 0.23 * width;
    double holeSize5 = 0.25 * width;

    double position1X = 0.75 * width;
    double position1Y = 0.75 * width;
    
    double position2X = 0.20 * width;
    double position2Y = 0.20 * width;
    
    double position3X = 0.45 * width;
    double position3Y = 0.45 * width;

    double position4X = 0.15 * width;
    double position4Y = 0.65 * width;

    double position5X = 0.65 * width;
    double position5Y = 0.15 * width;

    Ellipse2D.Double hole1 = 
      new Ellipse2D.Double(x+position1X, y+position1Y, holeSize1, holeSize1);
    Ellipse2D.Double hole2 = 
      new Ellipse2D.Double(x+position2X, y+position2Y, holeSize2, holeSize2);
    Ellipse2D.Double hole3 = 
      new Ellipse2D.Double(x+position3X, y+position3Y, holeSize3, holeSize3);
    Ellipse2D.Double hole4 = 
      new Ellipse2D.Double(x+position4X, y+position4Y, holeSize4, holeSize4);
    Ellipse2D.Double hole5 = 
      new Ellipse2D.Double(x+position5X, y+position5Y, holeSize5, holeSize5);

      GeneralPath wholeSwissSlice = this.get();
      wholeSwissSlice.append(hole1, false);
      wholeSwissSlice.append(hole2, false);
      wholeSwissSlice.append(hole3, false);
      wholeSwissSlice.append(hole4, false);
      wholeSwissSlice.append(hole5, false);
    }

}
