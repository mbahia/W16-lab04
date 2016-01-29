package edu.ucsb.cs56.w16.drawings.wkzhuang.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w16.drawings.wkzhuang.advanced.Circle;

/**
   A Circle with two smaller, identical circles inside
      
   @author Weikun Zhuang 
   @version for CS56, W16, UCSB
   
*/


public class CircleWithTwoSmallerOnes extends GeneralPathWrapper implements Shape
{

    /**
     * Constructor for object of CircleWithTwoSmallerOnes
     */

    public CircleWithTwoSmallerOnes(double x, double y, double r)
    {
        // set up variables to draw smaller circles using x, y and r.                                                                                                     
        double firstSmallCircleX = x - r * 1/2;
        double firstSmallCircleY = y;
        double firstSmallCircleR = r * 1/6;

        double secondSmallCircleX = x + r * 1/2;
        double secondSmallCircleY = y;
        double secondSmallCircleR = r * 1/6;

        Circle biggestCircle = new Circle(x,y,r);
        Circle smallerCircle1 = new Circle(firstSmallCircleX, firstSmallCircleY,
                                           firstSmallCircleR);
        Circle smallerCircle2 = new Circle(secondSmallCircleX, secondSmallCircleY,
                                           secondSmallCircleR);

        // put all these three circles together                                                                                                                           

        GeneralPath wholePicture = this.get();
        wholePicture.append(biggestCircle,false);
        wholePicture.append(smallerCircle1, false);
        wholePicture.append(smallerCircle2,false);
    }

}

