package edu.ucsb.cs56.w16.drawings.jimmylle.advanced;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Shape;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

public class AnimatedPictureComponent extends JComponent {
    private Shape leftSword;
    private Shape rightSword;
    private int count = 0;
    private double yPos = 250;
    private double width = 25;
    private double height = 125;
    private double leftXPos = 50;
    private double rightXPos = 550;
    private double leftAngle = .025 * Math.PI;
    private double rightAngle = -.025 * Math.PI;
    
    
    public AnimatedPictureComponent() {
        leftSword = new Sword(leftXPos, yPos, width, height);
        rightSword = new Sword(rightXPos, yPos, width, height);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        drawSwords(g2);
    }

    private void drawSwords(Graphics2D g2) {
        g2.draw(leftSword);
        g2.draw(rightSword);
        if (leftXPos != 215) {
            leftXPos += 5;
            leftSword = new Sword(leftXPos, yPos, width, height);
            rightXPos += -5;
            rightSword = new Sword(rightXPos, yPos, width, height);
        }
        else {
            if (count <= 11) {
                leftAngle += .1;
                rightAngle -= .1;
            }
            else if (count <= 24) {
                leftAngle -= .1;
                rightAngle += .1;
            }
            else if (count <= 35) {
                leftAngle += .1;
                rightAngle -= .1;
            }
            count++;
            leftSword = ShapeTransforms.rotatedCopyOf(
                        new Sword(leftXPos, yPos, width, height), leftAngle);
            rightSword = ShapeTransforms.rotatedCopyOf(
                        new Sword(rightXPos, yPos, width, height), rightAngle);
            if (count > 35) {
                leftXPos = 50;
                count = 0;
                leftAngle = .025 * Math.PI;
                rightXPos = 550;
                rightAngle = -.025 * Math.PI;
            }
        }
    }

}
