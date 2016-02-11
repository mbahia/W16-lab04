package edu.ucsb.cs56.w16.drawings.marvinshu.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Marvin Shu
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    int basketballY = 90;
    DrawPanel panel;
    
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      panel = new DrawPanel();
      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
	  
      dribble(5);
      
    }
    /**
       Specifies the number of dribbling animations
       @param numTimes the number of times to dribble
    **/
    public void dribble(int numTimes)
    {
	if(numTimes == 0)
	    return;
	else
	    {
		//ball on way down
		for(int i = 0; i < 50; i++)
		    {
			basketballY++;
			panel.repaint();
			try{
			    Thread.sleep(10);
			}catch (Exception ex){}
		    }
		//ball on way back up
		for(int i = 0; i < 50; i++)
		    {
			basketballY--;
			panel.repaint();
			try{
			    Thread.sleep(10);
			}catch (Exception ex){}
		    }
		dribble(numTimes-1);
	    }
    }
    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Basketball guy and basketball
          g2.setColor(Color.RED);
          BasketballGuy guy = new BasketballGuy(100,100);
	  Basketball ball = new Basketball(100,basketballY);
          g2.draw(guy);
	  g2.draw(ball);
       }
    }
}
