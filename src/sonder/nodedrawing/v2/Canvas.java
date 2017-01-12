package sonder.nodedrawing.v2;

import java.util.LinkedList;

public class Canvas {
	
	//The limit of nodes for a 100x100 area with average (50.0) crowding
	final int PROPER_BASE_LIMIT = 5;
	
	public int width, height, tiers;
	public double crowding;
	public Point origin;
	public LinkedList<Node> nodes;
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		this.nodes = new LinkedList<Node>();
	}
	
	public double getAverageSpacing() {
		double avgEdgeDistance = (width + height) / 2;
		return avgEdgeDistance * (crowding / 100.0);
	}
	
	public double getMinimumSpacing() {
		double avgSpacing = getAverageSpacing();
		return avgSpacing - (avgSpacing * (crowding / 100.0));
	}
	
	public int getProperNodeLimit() {
		double area = width * height;
		double blocks = area / Math.pow(100, 2);
		double factor = Math.abs(50 - crowding);
		if(crowding < 50)
			factor *= -1;
		
		factor /= 100.0;
		return (int) Math.floor(blocks * factor);
	}
	
	public LinkedList<Node> tier(int tier) {
		LinkedList<Node> tn = new LinkedList<Node>();
		for(Node n : nodes) {
			if(n.getTier() == tier) {
				tn.add(n);
			}
		}
		
		return tn;
	}
	
	public LinkedList<Node> tier(LinkedList<Node> prexisting, int tier) {
		LinkedList<Node> tn = new LinkedList<Node>();
		for(Node n : prexisting) {
			if(n.getTier() == tier) {
				tn.add(n);
			}
		}
		
		return tn;
	}
	
	public void add(Node node) {
		nodes.add(node);
	}
	
	public void addAll(LinkedList<Node> newNodes) {
		nodes.addAll(newNodes);
	}
	
	public Node get(long id) {
		for(Node node : nodes) {
			if(node.getID() == id)
				return node;
		}
		
		return null;
	}
	
	public Point getOrigin() {
		return origin;
	}
	
	public void setOrigin(Point point) {
		this.origin = point;
	}
	
	public Point approximateCenter() {
		return new Point(width/2, height/2);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public LinkedList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}

	public double getCrowding() {
		return crowding;
	}

	public void setCrowding(double crowding) {
		this.crowding = crowding;
	}
	
	public int getTiers() {
		return tiers;
	}
	
	public void setTiers(int tiers) {
		this.tiers = tiers;
	}

	public void setOrigin(int x, int y) {
		this.origin = new Point(x, y);
	}

}
