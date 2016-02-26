package edu.ucsb.cs56.w16.drawings.shunjizhan.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a monster logo that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shunji Zhan 
   @version for CS56, W16, UCSB
   
*/
public class Monster extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of logo
       @param y y coord of lower left corner of logo
       @param width width of the logo
       @param height of logo
    */
    public Monster(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double distance =  width * 0.3;
        
        
        Line2D.Double firstline_part1 = new Line2D.Double (x,y,
							   x+distance,y);
	Line2D.Double firstline_part2 = new Line2D.Double (x+distance,y,
							   x+distance,y+height);
	
	Line2D.Double secondline_part1 = new Line2D.Double (x+distance+width*0.03, y,
							    x+distance+distance+width*0.03,y);
	Line2D.Double secondline_part2 = new Line2D.Double (x+distance+distance+width*0.03,y,
							    x+distance+distance+width*0.03,y+height);
	
	Line2D.Double thirdline_part1 = new Line2D.Double (x+distance+width*0.03+distance+width*0.03,y,
							   x+distance+distance+width*0.03+distance+width*0.03,y);
	Line2D.Double thirdline_part2 = new Line2D.Double (x+distance+distance+width*0.03+distance+width*0.03,y,
							   x+distance+distance+width*0.03+distance+width*0.03,y+height);
                               
	
       
	
        // put the whole house together
	
        GeneralPath wholeMonster = this.get();
        wholeMonster.append(firstline_part1, false);
        wholeMonster.append(firstline_part2, false);
        wholeMonster.append(secondline_part1, false);
        wholeMonster.append(secondline_part2, false);
        wholeMonster.append(thirdline_part1, false);
        wholeMonster.append(thirdline_part2, false); 
    }
}
