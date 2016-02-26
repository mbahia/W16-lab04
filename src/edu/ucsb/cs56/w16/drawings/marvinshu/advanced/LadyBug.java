package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;
import java.awt.Shape;
import java.awt.geom.GeneralPath; 

import edu.ucsb.cs56.w16.drawings.marvinshu.simple.Circle;

public class LadyBug extends Beetle implements Shape
{
    public LadyBug(double x, double y, double size, double spotRadius)
    {
	super(x,y,size);
	GeneralPath gp = this.get();

	Circle spot1 = new Circle(x-size * 0.5, y-size * 0.7, spotRadius * 0.25);
	Circle spot2 = new Circle(x+size * 0.8, y+size*0.75, spotRadius * 0.25);

	GeneralPath wholeLadyBug = this.get();
	wholeLadyBug.append(spot1,false);
	wholeLadyBug.append(spot2,false);		   
    }
}
