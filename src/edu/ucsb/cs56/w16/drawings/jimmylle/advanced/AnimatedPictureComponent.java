package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Shape;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

public class AnimatedPictureComponent extends JComponent {
    private Shape leftSword;
    private double width = 25;
    private double height = 125;
    private double xPos = 50;
    private double yPos = 250;
    private double angle = .4 * Math.PI;
    private double leftAngle = .025 * Math.PI;
    private int count = 0;
    
    
    public AnimatedPictureComponent() {
        leftSword = new Sword(xPos, yPos, width, height);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.draw(leftSword);
	
        if (xPos != 200) {
            xPos += 5;
            leftSword = new Sword(xPos, yPos, width, height);
        }
        else {
            if (count <= 11) {
                leftAngle += .1;
            }
            else if (count <= 24) {
                leftAngle -= .1;
            }
            else if (count <= 35) {
                leftAngle += .1;
            }
            count++;
            leftSword = ShapeTransforms.rotatedCopyOf(new Sword(xPos, yPos, width, height), leftAngle);
            if (count > 35) {
                xPos = 50;
                count = 0;
                leftAngle = .025 * Math.PI;
            }
        }
    }
}
