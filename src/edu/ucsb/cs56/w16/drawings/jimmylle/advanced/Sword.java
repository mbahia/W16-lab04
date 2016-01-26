package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a sword that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jimmy Le 
   @version for CS56, W16, UCSB
   
*/
public class Sword extends Blade implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of the sword
       @param y y coord of lower left corner of the sword
       @param width width of the sword (not including the hilt)
       @param height of the sword  (including the point but not the hilt)
    */
    public Sword(double x, double y, double width, double height)
    {
	      // Construct just the blade
        super(x,y,width,height);
  
        // Get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();

        // Make the hilt which consist of the crossguard, grip, and pommel
        // Hilt is proportional to width and height of the blade

        // Make the crossguard
        Rectangle2D.Double crossguard =
          new Rectangle2D.Double(x - 1.5*width, y,
                                 4*width, height *(.05));

        // Make the grip
        Rectangle2D.Double grip = 
          new Rectangle2D.Double(x + width*(.1), y + height*(.05),
                                 width*(.8), height * (1/3.0));

        //Make the pomel
        Ellipse2D.Double pommel =
          new Ellipse2D.Double(x - width*(.25), y + height*(23/60.0),
                               width*(1.5), width*(.65));


        // Add the hilt to the blade
        GeneralPath wholeSword = this.get();
        wholeSword.append(crossguard,false);
        wholeSword.append(grip,false);
        wholeSword.append(pommel,false);

    }
}
