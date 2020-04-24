//  
//  Mark Anthony Start :  180140208  -- C02220 -- cw1 -- 
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RandomRectangleGUI {

	JFrame frame;
	RandomRectDrawPanel drawPanel = new RandomRectDrawPanel();
	JButton colorButton;
	JButton sizeButton;
	RandomColorListener randomColorListener;
	SizeListener sizeListener;

	public static void main (String[] args){
		RandomRectangleGUI gui = new RandomRectangleGUI();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		colorButton = new JButton("Click me for a random colour");
		sizeButton = new JButton("Click me for a random size");


	// added source listeneres and action listners --------------------------------------------------//
	
		randomColorListener = new RandomColorListener();
		sizeListener = new SizeListener();

		colorButton.addActionListener( randomColorListener );
		sizeButton.addActionListener( sizeListener );

	//---------------------------------------------------------------//
		

		frame.getContentPane().add(BorderLayout.PAGE_START, colorButton);
		frame.getContentPane().add(BorderLayout.PAGE_END, sizeButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}


// added  innerclasses ------------------------------------------------------------------------------------------------------------//


		private class RandomColorListener implements ActionListener {

			public void actionPerformed( ActionEvent event ) {

				drawPanel.randomColor();
				drawPanel.repaint();

			}

		}


		private class SizeListener implements ActionListener {

			public void actionPerformed( ActionEvent event ) {

				drawPanel.randomSize();
				drawPanel.repaint();

			}

		}


//-------------------------------------------------------------------------------------------------------------------------------//


	class RandomRectDrawPanel extends JPanel{
		Color color;
		int height = 50;
		int width = 80;
		int x = 50;
		int y = 50;

		public void paintComponent (Graphics g){
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(x,y,width,height);
		}

		
		public void randomColor(){
			int r = (int)(Math.random()*255);
			int gr = (int)(Math.random()*255);
			int b = (int)(Math.random()*255);
			color = new Color(r,gr,b);
		}
		
		public void randomSize(){
			int displace = 5;
			height = (int)(Math.random()*getHeight());
			width = (int)(Math.random()*getWidth());

			int temp;
			if ((y + height) > getHeight()){  // this to keep all of the height of the rectangle inside the draw panel
				temp = getHeight() - (y + height);
				height = height + temp - displace;  // temp is a negative number
			}
			if (height < 5) height = 5;//minimum height

			if ((x + width) > getWidth()){  // this to keep all of the width of the rectangle inside the draw panel
				temp = getWidth() - (x + width);
				width = width + temp - displace;  // temp is a negative number
			}
			if (width < 5) width = 5; //minimum width
		}				
	}
}
