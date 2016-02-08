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
    private double width = 25;
    private double height = 125;
    private double leftXPos = 50;
    private double rightXPos = 550;
    private double yPos = 250;
    private double leftAngle = .025 * Math.PI;
    private double rightAngle = -.025 * Math.PI;
    private int leftCount = 0;
    private int rightCount = 0;
    
    
    public AnimatedPictureComponent() {
        leftSword = new Sword(leftXPos, yPos, width, height);
        rightSword = new Sword(rightXPos, yPos, width, height);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        drawLeftSword(g2);
        drawRightSword(g2);
    }

    private void drawLeftSword(Graphics2D g2) {
        g2.draw(leftSword);
        if (leftXPos != 215) {
            leftXPos += 5;
            leftSword = new Sword(leftXPos, yPos, width, height);
        }
        else {
            if (leftCount <= 11) {
                leftAngle += .1;
            }
            else if (leftCount <= 24) {
                leftAngle -= .1;
            }
            else if (leftCount <= 35) {
                leftAngle += .1;
            }
            leftCount++;
            leftSword = ShapeTransforms.rotatedCopyOf(new Sword(leftXPos, yPos, width, height), leftAngle);
            if (leftCount > 35) {
                leftXPos = 50;
                leftCount = 0;
                leftAngle = .025 * Math.PI;
            }
        }
    }


    private void drawRightSword(Graphics2D g2) {
        g2.draw(rightSword);
        if (rightXPos != 385) {
            rightXPos += -5;
            rightSword = new Sword(rightXPos, yPos, width, height);
        }
        else {
            if (rightCount <= 11) {
                rightAngle -= .1;
            }
            else if (rightCount <= 24) {
                rightAngle += .1;
            }
            else if (rightCount <= 35) {
                rightAngle -= .1;
            }
            rightCount++;
            rightSword = ShapeTransforms.rotatedCopyOf(new Sword(rightXPos, yPos, width, height), rightAngle);
            if (rightCount > 35) {
                rightXPos = 550;
                rightCount = 0;
                rightAngle = -.025 * Math.PI;
            }
        }
    }









}
