package edu.ucsb.cs56.w16.drawings.ayung.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A main class to view an animation. Click to place a pin on the screen. If
 * the pin hits the doll, it will turn it red. If you pin exactly on the doll
 * on the first try, the pin will animate with the doll.
 *
 * @author Angela Yung
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();
    Thread anim;   
    
    private int x = 100; //x coor
    private int y = 100; //y coor
    private int h = 200; //height

    private int x2 = x+200;
    private int y2 = y+200;
    
    Shape vd1 = new VoodooDoll(x,y,h);  //instantiate test doll
    Shape vd2 = new VoodooDoll(x2,y2,h);


    private int px = -1;
    private int py = -1;
    private int ph = 5;
    Shape pin;
    
    private int dx = -5;
    private boolean hit = false;
    private double swing_angle = .015;
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }
    
    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);
	
	frame.getContentPane().addMouseListener(new MouseAdapter() {
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

		public void mouseClicked(MouseEvent e) {
		    px = e.getX();
		    py = e.getY();
		    if(vd2.contains(px,py)) 
			hit = true;
		    else {
			hit = false;
		    }
		    pin = new Pin(px,py,ph);
		}
	    });
	
    }
    
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    g2.setColor(Color.BLACK);

	    if(px >= 0) {
		g2.draw(pin);
		if(vd1.contains(px,py)) {
		    g2.draw(vd2);
		    g2.setColor(Color.RED);
		    g2.draw(vd1);
		}
		else if(vd2.contains(px,py)) {
		    g2.draw(vd1);
		    g2.setColor(Color.RED);
		    g2.draw(vd2);
		}
		else {
		    g2.draw(vd1);
		    g2.draw(vd2);
		}
	    }
	    else {
		g2.draw(vd1);
		g2.draw(vd2);
	    }
	    
	    
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {

		    if(px >=0 && vd1.contains(px,py)) {
			pin = ShapeTransforms.rotatedCopyOf(pin,swing_angle);
		    }
		    vd1 = ShapeTransforms.rotatedCopyOf(vd1,swing_angle);

		    if(x2 >= 400) {dx = -5;}
		    if(x2 <= 100) {dx = 5;}
		    if(px >= 0 && hit) {
			pin = ShapeTransforms.translatedCopyOf(pin,dx,0);
			px+=dx;
		    }
		    x2+=dx;
		    vd2 = ShapeTransforms.translatedCopyOf(vd2,dx,0);
		    
		    panel.repaint();
		    Thread.sleep(50);
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
