package edu.ucsb.cs56.w16.drawings.shunjizhan.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A pyramid created by hurricane
      
   @author Shunji Zhan 
   @version for CS56, W16, UCSB
   
*/
public class Pyramid extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class Pyramid
     */
    public Pyramid(double x, double y, double width, double height)
    {
	
        final double dx = 7.5;
	final double dy = 15.0;
	final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 300.0; 
        
        
        GeneralPath start = new GeneralPath();
	
 
	
        start.moveTo(300,100);
	for(int i=0; i<20; i++) {
	    start.lineTo(300+dx*i,100+dy*i);
	    start.lineTo(300-dx*i,100+dy*i);
	}
        
       
        GeneralPath p = new GeneralPath ();
        p.append(start, false);


        Shape s = ShapeTransforms.translatedCopyOf(p, dx + x, dy + y);
 
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	this.set(new GeneralPath(s));
        
    }

}
