package edu.ucsb.cs56.w16.drawings.ayung.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a doll that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author Angela Yung
   @version for CS56, W16, UCSB
   
*/
public class Doll extends GeneralPathWrapper implements Shape
{
    double head_dia;

    
    double arm_height;
    double arm_width;
    double hand_dia;

    double body_width;
    double body_height;

    double leg_width;
    double leg_height;
    double feet_dia;

    double head_x;
    double head_y;

    double arm_x;
    double arm_y;
    
    double lhand_x;
    double rhand_x;
    double hand_y;

    double body_x;
    double body_y;

    double lleg_x;
    double rleg_x;
    double leg_y;
   
    double lfeet_x;
    double rfeet_x;
    double feet_y;
    
    
    /**
       Constructor
       
       @param x x coord of center  of doll
       @param y y coord of top of doll
       @param height height of doll
    */
    public Doll(double x, double y, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        head_dia    = .30 * height;

        arm_height  = .10 * height;
	arm_width   = .60 * height;
	hand_dia    = .10 * height;

	body_height = .35 * height;
	body_width  = .30 * height;

	leg_height  = .20 * height;
	leg_width   = .10 * height;
	feet_dia    = .10 * height;
        
        
        // Make the head:
	head_x = x - 0.5*head_dia;
	head_y = y;
	Ellipse2D.Double head = 
	    new Ellipse2D.Double(head_x, head_y, head_dia, head_dia);


	//Make the arm:
	arm_x = x - .5*arm_width;
	arm_y = y + head_dia;
	Rectangle2D.Double arms = 
	    new Rectangle2D.Double(arm_x, arm_y, 
				   arm_width, arm_height);

	//Make the hands;
	lhand_x = x - .5*arm_width - .5*hand_dia;
	rhand_x = x + .5*arm_width - .5*hand_dia; 
	hand_y = arm_y;
	Ellipse2D.Double leftHand = 
	    new Ellipse2D.Double(lhand_x, hand_y, hand_dia, hand_dia);
	Ellipse2D.Double rightHand = 
	    new Ellipse2D.Double(rhand_x, hand_y, hand_dia, hand_dia);
	

	//Make the body:
	body_x = x - 0.5*body_width;
	body_y = arm_y + arm_height;
	Rectangle2D.Double body = 
	    new Rectangle2D.Double(body_x, body_y, body_width, body_height);


	//Make the legs:
	lleg_x = body_x;
	rleg_x = body_x + 2*leg_width;
	leg_y = body_y + body_height;
	Rectangle2D.Double leftLeg = 
	    new Rectangle2D.Double(lleg_x, leg_y, leg_width, leg_height);
	Rectangle2D.Double rightLeg = 
	    new Rectangle2D.Double(rleg_x, leg_y, leg_width, leg_height);


	//Make the feet:
	lfeet_x = lleg_x;
	rfeet_x = rleg_x;
	feet_y = leg_y + leg_height - 0.5*feet_dia;
	Ellipse2D.Double leftFoot = 
	    new Ellipse2D.Double(lfeet_x, feet_y, feet_dia, feet_dia);
	Ellipse2D.Double rightFoot = 
	    new Ellipse2D.Double(rfeet_x, feet_y, feet_dia, feet_dia);
	
        	
        GeneralPath wholeDoll = this.get();
        wholeDoll.append(head, false);
        wholeDoll.append(arms, false);
        wholeDoll.append(leftHand, false);
	wholeDoll.append(rightHand, false);
	wholeDoll.append(body, false);
	wholeDoll.append(leftLeg, false);
	wholeDoll.append(rightLeg, false);
	wholeDoll.append(leftFoot, false);
	wholeDoll.append(rightFoot, false);


    }
}
