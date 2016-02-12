package edu.ucsb.cs56.w16.drawings.nivek325.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Kevin Lee
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {
    private Shape cheese;
    private DrawPanel panel = new DrawPanel();
    private int x = 50;
    private int y = 50;
    private int dx = 5;
    private int dy = 0;
    private double rotate = 0;
    
    Thread anim;
    
    public static void main(String[] args) {
	    new AnimatedPictureViewer().go();
	}
    
    public void go() {
	    JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			    System.out.println("Mouse entered");
			    anim = new Animation();
			    anim.start();
			}
			
			public void mouseExited(MouseEvent e) {
			    System.out.println("Mouse exited");
			    anim.interrupt();
			    while (anim.isAlive()){}
			    anim = null;
			    panel.repaint();
			}
		    });
	}
    class DrawPanel extends JPanel {
	    public void paintComponent(Graphics g) {
		    Graphics2D g2 = (Graphics2D) g;
		       
			g2. setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(),this.getHeight());
			
			g2.setColor(Color.WHITE);
			cheese = ShapeTransforms.rotatedCopyOf(new SwissCheese(x,y,100), rotate);
			g2.draw(cheese);
		}
	}
    
    class Animation extends Thread {
	public void run() {
	    try {
		while(true){
		    if (x == 350 && y == 50) { dx = 0; dy = 5;}
		    if (x == 350 && y == 350) { dx = -5; dy = 0;}
		    if (x == 50 && y == 350) { dx = 0; dy = -5;}
		    if (x == 50 && y == 50) { dx = 5; dy = 0;}
		    x += dx;
		    y += dy;
		    rotate += 0.10;
		    panel.repaint();
		    Thread.sleep(20);
		}
	    }
	    catch(Exception ex) {
		if (ex instanceof InterruptedException) { } 
		else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
}
