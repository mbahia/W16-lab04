package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnimatedPictureViewer extends JFrame {
    Animation animation;
    Sword sword1;
    Sword sword2;
    DrawPanel panel;   
    int x = 100;
    int y = 250;
    int dx = 5;
    int dy = 5;

    public static void main (String[] args) {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
        apv.go();
    }

    public void go() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(640,480);
        this.setVisible(true);

        panel = new DrawPanel();
        this.getContentPane().add(panel);

        animation = new Animation();
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
        });
    }

    class DrawPanel extends JPanel {
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);

        sword1 = new Sword(x,y,25,100);
        sword2 = new Sword(100,y,25,100);
        g2.draw(sword1);
        g2.draw(sword2);
      }
    }

    class Animation extends Thread {
        public void run() {
          try {
            while (true) {
              if (x >= 400) {dx = -5;}
              if (x <= 50) {dx = 5;}
              if (y >= 300) {dy = -5;}
              if (y <= 100) {dy = 5;}

              x += dx;
              y += dy;
              panel.repaint();
              Thread.sleep(10);
            }
          }
          catch (Exception ex) {
            if (ex instanceof InterruptedException) {

            }
            else {
              ex.printStackTrace();
              System.exit(1);
            }
          }
        }
    }

}