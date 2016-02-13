package edu.ucsb.cs56.w16.drawings.xiaohe.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/** A viewer class to see an animated picture by Xiaohe He
   
   @author Xiaohe He
   @version CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    //private LittleGirl girl = new LittleGirl(100, 100, 50, 135);

    JButton grow;
    JButton shrink;
    JButton normal;
    JButton speed_up;
    JButton speed_down;
    JButton change_color;
    JButton drunk;
    
    Thread anim;   
    
    private int x = 350;
    private int y = 100;
    private int girlWidth = 22;
    private int girlHeight = 55;
    
    private int dx = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel buttonPanel = new JPanel();
      
      grow = new JButton("grow");
      grow.addActionListener(new GrowListener());
      shrink = new JButton("shrink");
      shrink.addActionListener(new ShrinkListener());
      normal = new JButton("normal");
      normal.addActionListener(new NormalListener());
      speed_up = new JButton("speed up");
      speed_up.addActionListener(new SpeedUpListener());
      speed_down = new JButton("speed down");
      speed_down.addActionListener(new SpeedDownListener());
      change_color = new JButton("change color");
      change_color.addActionListener(new ColorListener());
      drunk = new JButton("drunk");
      drunk.addActionListener(new DrunkListener());
      
      buttonPanel.add(grow);
      buttonPanel.add(shrink);
      buttonPanel.add(normal);
      buttonPanel.add(speed_up);
      buttonPanel.add(speed_down);
      buttonPanel.add(change_color);
      buttonPanel.add(drunk);
      frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);

      frame.getContentPane().add(panel);
      frame.setSize(720,540);
      frame.setTitle("Xiaohe He's Animated Drawing");
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
      });

    } // go()

    
    class GrowListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    panel.setGrow();
	}
    }
    
    class ShrinkListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    panel.setShrink();
	}
    }

    class NormalListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    panel.setNormal();
	}
    }

    class SpeedUpListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    if (dx > 0)
		dx += 2;
	    else
		dx -= 2;
	}
    }

    class SpeedDownListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    if ((-3 < dx) && (dx < 3))
		return;
	    if (dx > 0)
		dx -= 2;
	    else
		dx += 2;
	}
    }

    class ColorListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    panel.changeColor();
	}
    }

    class DrunkListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    panel.setDrunk();
	}
    }
   

    class DrawPanel extends JPanel {
	private boolean growing = false;
	private boolean shrinking = false;
	private boolean drunk_mode = false;
	private Color color = Color.RED;
	private double dangle = 0.05;
	private double angle = 0.0;
	
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

	  if (growing) {
	      if (girlHeight < panel.getHeight() - y) {
		girlHeight += 3;
		girlWidth += 1;
	      }
	  }

	  if (shrinking) {
	      if (girlHeight > 55) {
		girlHeight -= 3;
		girlWidth -= 1;
	      }
	  }
          
	  g2.setColor(color);	  
          Shape girl = new LittleGirl(x, y, girlWidth, girlHeight);
	  
	  if (drunk_mode) {
	      girl = ShapeTransforms.rotatedCopyOf(girl, angle);
	      angle += dangle;
	      if ((angle > 1.0) || (angle < -1.0))
		  dangle *= -1;
	      changeColor();
	  }
	      
          g2.draw(girl);
	  g2.setColor(Color.BLACK);
	  g2.drawString("Clicking on 'speed up' or 'speed down' increases/decreases the speed by a certain amout", 20, 20);
	  g2.drawString("Clicking on 'grow' or 'shrink' makes continuous change to this girl", 20, 40);
	  g2.drawString("Clicking on 'normal' can exit growing_mode, shrinking_mode or drunk_mode", 20, 60);
	  g2.drawString("Clicking on 'change color' changes this girl's color if not in drunk_mode", 20, 80);
       }
	
	public void setGrow() {
	    growing = true;
	    shrinking = false;
	}

	public void setShrink() {
	    shrinking = true;
	    growing = false;
	}

	public void setNormal() {
	    shrinking = growing = drunk_mode = false;
	}

	public void changeColor() {
	    int r = (int)(Math.random() * 256);
	    int g = (int)(Math.random() * 256);
	    int b = (int)(Math.random() * 256);
	    color = new Color(r,g,b);
	}

	public void setDrunk() {
	    drunk_mode = true;
	}
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      if ((x >= panel.getWidth()*0.7) || (x <= panel.getWidth()*0.1))
		  dx *= -1;
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
