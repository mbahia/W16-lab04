package edu.ucsb.cs56.w16.drawings.wkzhuang.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A class to view an animation of Yin-Yang Symbol
 *
 * @author Weikun Zhuang
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;
    private double rotate = Math.PI;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(800,700);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
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

	  Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the symbol
          g2.setColor(Color.BLACK);
          YinYangSymbol yy1 = new YinYangSymbol(x, y, 100);
	  Shape yy2 = ShapeTransforms.translatedCopyOf(yy1,100,100);
	  Shape yy3 = ShapeTransforms.rotatedCopyOf(yy2,rotate);
          g2.draw(yy3);

	  // Set random color
	  int red = (int)(Math.random()*256);
	  int green = (int)(Math.random()*256);
	  int blue = (int)(Math.random()*256);
	  Color randomColor = new Color(red,green,blue);
	  g2.setColor(randomColor);
	  YinYangSymbol yy4 = new YinYangSymbol(400,450,100);
	  Shape yy5 = ShapeTransforms.rotatedCopyOf(yy4,-rotate);
	  g2.draw(yy5);
	  
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

            if (x >= 500) { dx = -5; }
            if (x <= 100) { dx = 5; }

	    x += dx;
            rotate = rotate + (Math.PI)/32.0;
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
