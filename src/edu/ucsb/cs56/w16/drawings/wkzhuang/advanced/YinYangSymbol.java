package edu.ucsb.cs56.w16.drawings.wkzhuang.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Arc2D;

//import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
//import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Yin-Yang symbol

   @author Weikun Zhuang
   @version for CS56, W16, UCSB

*/

public class YinYangSymbol extends CircleWithTwoSmallerOnes implements Shape
{

    /**
     * Constructor for objects of class YinYangSymbol
     */

    public YinYangSymbol (double x, double y, double r)
    {
	// construct the basic circles to add arcs

	super(x,y,r);
	
	GeneralPath gp = this.get();

	// set up variables

	double arc1X = x - r * 1/2 - r * 1/2;
	double arc1Y = y - r * 1/2;
	double arc1W = r;
	double arc1H = r;

	double arc2X = x + r * 1/2 - r * 1/2;
	double arc2Y = y - r * 1/2;
	double arc2W = r;
	double arc2H = r;

	// add a semi-circle arc on the top of the smaller circle on the left side

	Arc2D.Double arc1 = new Arc2D.Double(arc1X, arc1Y, arc1W, arc1H, 0, 180, Arc2D.OPEN);
	Arc2D.Double arc2 = new Arc2D.Double(arc2X, arc2Y, arc2W, arc2H, 0, -180, Arc2D.OPEN);

	// put everything together

	GeneralPath wholeYinYang = this.get();
	wholeYinYang.append(arc1,false);
	wholeYinYang.append(arc2,false);
    }
}
