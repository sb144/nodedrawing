package sonder.nodedrawing.v2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RenderPanel extends JPanel {
	
	JPanel panel;
	Canvas canvas;
	boolean paintRelations, paintIDs;
	
	public RenderPanel(Canvas canvas, boolean paintRelations, boolean paintIDs) {
		setSize(canvas.getWidth(), canvas.getHeight());
		setVisible(true);
		this.canvas = canvas;
		this.paintRelations = paintRelations;
		this.paintIDs = paintIDs;
		repaint();
	}
	
	 @Override
	 protected void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     g.setColor(Color.BLACK);
	     for(Node node : canvas.getNodes()) {
	    	 g.setColor(Colors.get(node.getTier()));
	    	 g.fillOval(node.getX(), node.getY(), 5, 5);
	    	 
	    	 if(paintRelations) {
	    		 g.setColor(Color.decode("#000000"));
	    		 g.drawLine(node.getX(), node.getY(), canvas.get(node.getParentID()).getX(), canvas.get(node.getParentID()).getY());
	    	 }
	    	 
	    	 if(paintIDs) {
	    		 g.setColor(Color.decode("#000000"));
	    		 g.drawString("" + node.getID(), node.getX(), node.getY()-10);
	    	 }
	     }
	 }
}
