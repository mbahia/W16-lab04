package edu.ucsb.cs56.w16.drawings.xiaohe.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A girl with heels
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class GirlWithHeels extends LittleGirl implements Shape
{
/**
       Constructor
       
       @param x x coord of lower left corner of the framing rectangle of the girl
       @param y y coord of lower left corner of the framign rectangle of the girl
       @param width width of the girl
       @param height of the girl (without heels)
 */
    public GirlWithHeels(double x, double y, double width, double height)
    {
	super(x,y,width,height);
	

	double heelHeight = 0.10 * height;
	double heelWidth = 0.20 * width;
	
	Rectangle2D.Double left =
	    new Rectangle2D.Double(x + width/3.0 - heelWidth/2.0, y + height,
				   heelWidth, heelHeight);
	Rectangle2D.Double right =
	    new Rectangle2D.Double(x + width*2/3.0 - heelWidth/2.0, y + height,
				   heelWidth, heelHeight);

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(left, false);
        wholeHouse.append(right, false);

    }    
}
