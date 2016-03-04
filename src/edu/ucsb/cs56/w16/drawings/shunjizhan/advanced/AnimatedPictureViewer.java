package edu.ucsb.cs56.w16.drawings.shunjizhan.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;


/**
 * A main class to view an animation
 *
 * @author Andrew Berls
 * @version for CS56, W14
 */


public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();
    //private Resources r = new Resources();

    private MonsterWithBottle mwb =  new MonsterWithBottle(200, 200, 60, 180);
    
    Thread anim;   

    private int sleeptime = 5;
    private double x = 200;
    private double y = 200;
    
    private double dx = 1;
    private double dy = 0.1;

    public static void main (String[] args) {
	AnimatedPictureViewer apv = new AnimatedPictureViewer();
	apv.go();
    }

    public void go() {

	 
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(800,800);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
	      // when press mouse, give it a ramdom speed and random start position
	      public void mousePressed(MouseEvent e) {
		  System.out.println("mouse pressed");
		  x = 100 + Math.random()*200;
		  y = 100 + Math.random()*200;
		  dx = Math.random()*10 - 5;
		  dy = Math.random()*10 - 5;
		  anim = new Animation();
		  anim.start();
	      }
	      
	      public void mouseEntered(MouseEvent e){
		  System.out.println("mouse entered");
		  anim = new Animation();
		  anim.start();
	      }

	      public void mouseExited(MouseEvent e){        
		  System.out.println("Mouse exited");
		  // Kill the animation thread
		  anim.interrupt();
		  while (anim.isAlive()){}
		  anim = null;         
		  panel.repaint();        
	      }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {
	   //   super.paintComponent(g);
	   //  g.drawImage(r.img, (int) x, (int)y, this);
	     Graphics2D g2 = (Graphics2D) g;
	   
         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the monster with bottle
          g2.setColor(Color.RED);
	  
	  MonsterWithBottle mwb =  new MonsterWithBottle(x, y, 60, 180);	  
	  g2.draw(mwb);
	  
	  
         	  
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

             if (x >= 650) { dx = -dx; }
	     if (x <= 0) { dx = -dx; }
	     if (y >= 650) { dy = -dy; }
	     if (y < 0) { dy = -dy; }
            
            x += dx;
	    y += dy;
            panel.repaint();
            Thread.sleep(sleeptime);
	    //sleeptime -= 10;
	    //if(sleeptime < 3) {sleeptime = 50;}
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
