package edu.ucsb.cs56.w16.drawings.saber.advanced;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Shaoyi Zhang
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

        private DrawPanel panel = new DrawPanel();
        
        private Saber mysaber = new Saber(100,300,50,400);
        
        Thread animation;   
        
        private int x = 200;
        private int y = 100;
        
        private int dx = 5;

        public static void main (String[] args) {
            new AnimatedPictureViewer().go();
        }

        public void go() {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(panel);
            frame.setSize(1024,768);
            frame.setVisible(true);
            
            frame.getContentPane().addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                System.out.println("mouse entered");
                    animation = new Animation();
                    animation.start();
                }

                public void mouseExited(MouseEvent e){        
                    System.out.println("Mouse exited");
                    // Kill the animation thread
                    animation.interrupt();
                    while (animation.isAlive()){}
                    animation = null;         
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

                    // Draw saber
                    g2.setColor(Color.RED);
                    Saber mySaber = new Saber(x, y, 70,300);
                    Shape mySaber2 = ShapeTransforms.rotatedCopyOf(mySaber,x*3.14159/180);
                    g2.draw(mySaber2);
             }
        }
        
        class Animation extends Thread {
            public void run() {
                try {

                        while (true) {
                        // Bounce and rotate

                        if (x >= 900) { dx = -5; }
                        if (x <= 150) { dx = 5; }
                        
                        x += dx;              
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
