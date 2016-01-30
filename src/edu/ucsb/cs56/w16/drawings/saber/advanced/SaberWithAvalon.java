package edu.ucsb.cs56.w16.drawings.saber.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
/**
   A Saber(sword) with avalon(sword cut)
   Using avalon to represent sword cut due to the myth of King Arthur
   Check Here: http://typemoon.wikia.com/wiki/Avalon
   @author Shaoyi Zhang 
   @version for CS56, W16, UCSB
   
*/
public class SaberWithAvalon extends Saber implements Shape
{
    /**
     * Constructor for objects of class SaberWithAvalon
     */
    public SaberWithAvalon(double x, double y, double width, double height, double avalonX, double avalonY)
    {
    	// avalonX = leftcorner X
    	// avalonY = leftcorner Y
	super(x,y,width,height);
	
	//double degreeInRadian = angle*3.14159/180;

	GeneralPath gp = this.get();

	double bladeSideLength = 0.8 * height;
	double gripWidth = .25 * width;
	double gripLength = .15 * height;
	double avalonWidth = 0.8*width;
	double holeHeight = 0.1*height;
	
	Ellipse2D.Double holeNonRotate =
        new Ellipse2D.Double(avalonX, avalonY, avalonWidth, holeHeight);

	Line2D.Double leftSide = 
		new Line2D.Double(avalonX, avalonY+0.5*holeHeight, avalonX, avalonY+bladeSideLength);

	Line2D.Double rightSide = 
		new Line2D.Double(avalonX+avalonWidth,avalonY+0.5*holeHeight,avalonX+avalonWidth,avalonY+bladeSideLength);

	Line2D.Double leftCut =
		new Line2D.Double(avalonX,avalonY+bladeSideLength,avalonX+0.5*avalonWidth, avalonY+height);

	Line2D.Double rightCut =
		new Line2D.Double(avalonX+avalonWidth,avalonY+bladeSideLength,avalonX+0.5*avalonWidth, avalonY+height);
	
    GeneralPath wholeSaber = this.get();
    wholeSaber.append(holeNonRotate, false);
    wholeSaber.append(leftSide, false);
    wholeSaber.append(rightSide, false); 
    wholeSaber.append(leftCut, false); 
    wholeSaber.append(rightCut, false); 
    }    
}
