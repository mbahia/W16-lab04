package edu.ucsb.cs56.w16.drawings.saber.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a saber(sword) that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shaoyi Zhang
   @version for CS56, W16, UCSB
   
*/
public class Saber extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper middle point of saber
       @param y y coord of upper middle point of saber
       @param width width of saber
       @param lenth length of saber (including hilt, cross-guard and blade)
    */
    public Saber(double x, double y, double width, double length)
    {
        
        double pommelDiameter = .1 * length;
        double gripLength = .15 * length;
        double crossGuardLength = .05 * length;
        double bladeLength = .7 * length;
        double bladeSideLength = 0.6 * length;

        
        double gripWidth = .25 * width;
        double crossGuardWidth = width;
        double bladeWidth = .5 * width;


        Ellipse2D.Double pommel =
          new Ellipse2D.Double(x-pommelDiameter/2, y, pommelDiameter, pommelDiameter);


        Rectangle2D.Double grip = 
            new Rectangle2D.Double(x - gripWidth/2.0, 
              y+pommelDiameter,
              gripWidth, gripLength);


        Rectangle2D.Double crossGuard = 
            new Rectangle2D.Double(x-crossGuardWidth/2.0, 
              y+pommelDiameter+gripLength,
              crossGuardWidth, crossGuardLength);
	
        
        Line2D.Double leftBladeLine = 
            new Line2D.Double (x-bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength,
                               x-bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength + bladeSideLength);
	

        Line2D.Double rightBladeLine = 
            new Line2D.Double (x+bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength,
                               x+bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength + bladeSideLength);
        
        Line2D.Double leftCut = 
            new Line2D.Double (x-bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength + bladeSideLength,
                               x, y + pommelDiameter + gripLength + crossGuardLength + bladeLength );


        Line2D.Double rightCut = 
            new Line2D.Double (x+bladeWidth/2.0, y + pommelDiameter + gripLength + crossGuardLength + bladeSideLength,
                               x, y + pommelDiameter + gripLength + crossGuardLength + bladeLength );


        Line2D.Double centerBladeLine = 
            new Line2D.Double (x , y + pommelDiameter + gripLength + crossGuardLength,
                               x, y + length);
	
        // put the whole saber together
	
        GeneralPath wholeSaber = this.get();
        
        wholeSaber.append(pommel, false);
        wholeSaber.append(grip, false);
        wholeSaber.append(crossGuard, false);
        wholeSaber.append(leftBladeLine, false);    
        wholeSaber.append(rightBladeLine, false);
        wholeSaber.append(centerBladeLine, false);
        wholeSaber.append(leftCut, false);
        wholeSaber.append(rightCut, false);
    }
}
