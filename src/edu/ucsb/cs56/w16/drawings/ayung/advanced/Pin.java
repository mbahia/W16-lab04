package edu.ucsb.cs56.w16.drawings.ayung.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.lang.Math;

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a pin that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Angela Yung
   @version for CS56, W16, UCSB
   
*/
public class Pin extends GeneralPathWrapper implements Shape
{
    double head_x;
    double head_y;
    
    double needle_x;
    double needle_y;
    double needle_xf;
    double needle_yf;

    double head_dia = 10;
    double point_length;
      
    /**
       Constructor
       
       @param x x coord of center  of doll
       @param y y coord of top of doll 
    */
    public Pin(double x, double y, double point_length)
    {        
        // Make the head:
	head_x = x;
	head_y = y;
	Ellipse2D.Double pinhead = 
	    new Ellipse2D.Double(head_x, head_y, head_dia, head_dia);

	//Make the needle:
	needle_x = head_x + head_dia;
	needle_y = head_y + 0.5*head_dia;

	needle_xf = needle_x + point_length*(0.5)*Math.sqrt(3);
	needle_yf = needle_y - point_length/2;

	Line2D.Double needle =
	    new Line2D.Double(needle_x, needle_y, needle_xf, needle_yf);
	
        	
        GeneralPath wholePin = this.get();
        wholePin.append(pinhead, false);
        wholePin.append(needle, false);

    }
}
