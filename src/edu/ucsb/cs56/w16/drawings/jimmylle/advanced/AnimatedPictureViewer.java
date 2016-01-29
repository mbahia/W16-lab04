package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnimatedPictureViewer extends JFrame {
    Animation animation;
    Sword sword;
    int x = 100;
    int y = 250;

    public static void main (String[] args) {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
        apv.go();
    }

    public void go() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(640,480);
        this.setVisible(true);

        animation = new Animation();
        Sword sword = new Sword(x,y,25,100);

        this.getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered");
                Get a new animation thread and start it
                animation = new Animation();
                animation.start();
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited");
                Interrupt the aniamation
                animation.interrupt();
                while(animation.isAlive()){}
                animation = null;
            }
        });
    }

    class Animation extends Thread {
        public void run() {
          
        }
    }

}