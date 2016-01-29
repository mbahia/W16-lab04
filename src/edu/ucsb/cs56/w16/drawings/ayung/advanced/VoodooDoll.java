package edu.ucsb.cs56.w16.drawings.ayung.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;


/**
   A VooDoo Doll
      
   @author Angela Yung
   @version for CS56, W16, UCSB
   
*/
public class VoodooDoll extends Doll implements Shape
{
    /**
     * Constructor for Voodoo doll object  of class Doll
     */
    public VoodooDoll(double x, double y, double height)
    {
	// construct the basic doll shell
	super(x,y,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Doll d = new Doll(x, y, height);
	
	//features: 
	//bigger button right eye
	//smaller left eye
	//stitched mouth
	double l_eye_dia =  0.03 * height; 
	double r_eye_dia = 1.5 * l_eye_dia;
	double mouth_length = .15 * height;
	double mouth_stitch = l_eye_dia; 

	//Make the eyes
	double l_eye_x = d.head_x + 0.20*d.head_dia;
	double r_eye_x = d.head_x + 0.70*d.head_dia;
	double eye_y   = d.head_y + .45 * d.head_dia;
	Ellipse2D.Double leftEye =
	    new Ellipse2D.Double(l_eye_x, eye_y, l_eye_dia, l_eye_dia);
	Ellipse2D.Double rightEye = 
	    new Ellipse2D.Double(r_eye_x, eye_y, r_eye_dia, r_eye_dia);


	//Make the mouth with three stiches:
	double mouth_height  = d.head_y + .75*d.head_dia;
	double stitch_top    = mouth_height - .02*height;
	double stitch_bottom = mouth_height + .02*height;
	Line2D.Double main_mouth =
	    new Line2D.Double(d.head_x + .20*d.head_dia, mouth_height,
			      d.head_x + .80*d.head_dia, mouth_height);
	Line2D.Double stitch_1 =
	    new Line2D.Double(x - .27*d.head_dia, stitch_top,
			      x - .27*d.head_dia, stitch_bottom);
	Line2D.Double stitch_2 =
	    new Line2D.Double(x - .17*d.head_dia, stitch_top,
			      x - .17*d.head_dia, stitch_bottom);
	Line2D.Double stitch_3 =
	    new Line2D.Double(x - .07*d.head_dia, stitch_top,
			      x - .07*d.head_dia, stitch_bottom);
	
	
	// add the eyes and mouth to the doll
        GeneralPath wholeDoll = this.get();
	wholeDoll.append(leftEye, false);
	wholeDoll.append(rightEye, false);
        wholeDoll.append(main_mouth, false);
        wholeDoll.append(stitch_1, false);
        wholeDoll.append(stitch_2, false);
	wholeDoll.append(stitch_3, false);
    }
}
