package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnimatedPictureViewer extends JFrame {
    Animation animation;
    AnimatedPictureComponent apc;

    public static void main (String[] args) {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
        apv.go();
    }

    public void go() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(640,480);
        this.setVisible(true);

        apc = new AnimatedPictureComponent();
        this.getContentPane().add(apc);

        this.getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered");
                // Get a new animation thread and start it
                animation = new Animation();
                animation.start();
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited");
                // Interrupt the aniamation
                animation.interrupt();
                while(animation.isAlive()){}
                animation = null;
            }
        }); // End addMouseListener
    }

    class Animation extends Thread {
        public void run() {
            try {
                while (true) {
                    apc.repaint();
                    Thread.sleep(25);
                }
            }
            catch (Exception ex) {
                if (ex instanceof InterruptedException) {
                    // Do Nothing, this exception is supposed
                    // to be thrown when mouse exits
                }
                else {
                ex.printStackTrace();
                System.exit(1);
                }
            }
        }
    } // End Inner Class

}