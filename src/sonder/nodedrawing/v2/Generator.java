package sonder.nodedrawing.v2;

import java.util.LinkedList;
import java.util.Random;

public class Generator {
	
	public static Random random;
	
	public static void init() {
		random = new Random();
	}
	
	public static Canvas web(int width, int height, int tiers, int branches) {
		//Make the canvas
		Canvas canvas = new Canvas(width, height);
		canvas.setCrowding(50.0);
		canvas.setOrigin(Options.ORIGIN_X, Options.ORIGIN_Y);
		canvas.setTiers(Options.TIERS);
		
		//Make an origin
		canvas.add(new Node(canvas.getOrigin().getX(), canvas.getOrigin().getY(), 0L, 0L, new Vector(5, 70), 0));
		
		long id = 1L;
		
		//Add the tiers
		for(int tier = 0; tier < canvas.getTiers(); tier++) {
			LinkedList<Node> currentTier = canvas.tier(tier);
			Log.write("Current tier: " + tier + ", contains " + currentTier.size() + " nodes!");
			
			for(int node = 0; node < currentTier.size(); node++) {
				Node parent = currentTier.get(node);
				LinkedList<Node> children = new LinkedList<Node>();
				
				for(int newChild = 0; newChild < branches; newChild++) {
					Vector movement = Vector.stemFrom(canvas, parent);
					Log.write(id + ": " + movement);
					Point childLocation = movement.translate(parent.getPoint());
					Node child = new Node(childLocation.getX(), childLocation.getY(), id, parent.getID(), movement, tier+1);
					children.add(child);
					id++;
				}
				
				canvas.addAll(children);
			}
			
		}
		
		Log.write("Finalizing with " + canvas.getNodes().size() + " nodes!");
		return canvas;
	}
	
	public static Canvas defaultWeb(int width, int height, int tiers, int branches) {
		//Make the canvas
		Canvas canvas = new Canvas(width, height);
		canvas.setCrowding(50.0);
		canvas.setOrigin(width/2, height/2);
		canvas.setTiers(tiers);
		
		//Make an origin
		canvas.add(new Node(canvas.getOrigin().getX(), canvas.getOrigin().getY(), 0L, 0L, new Vector(5, 70), 0));
		
		long id = 1L;
		
		//Add the tiers
		for(int tier = 0; tier < canvas.getTiers(); tier++) {
			LinkedList<Node> currentTier = canvas.tier(tier);
			Log.write("Current tier: " + tier + ", contains " + currentTier.size() + " nodes!");
			
			for(int node = 0; node < currentTier.size(); node++) {
				Node parent = currentTier.get(node);
				LinkedList<Node> children = new LinkedList<Node>();
				
				for(int newChild = 0; newChild < branches; newChild++) {
					Vector movement = Vector.stemFrom(canvas, parent);
					Log.write(id + ": " + movement);
					Point childLocation = movement.translate(parent.getPoint());
					Node child = new Node(childLocation.getX(), childLocation.getY(), id, parent.getID(), movement, tier+1);
					children.add(child);
					id++;
				}
				
				canvas.addAll(children);
			}
			
		}
		
		Log.write("Finalizing with " + canvas.getNodes().size() + " nodes!");
		return canvas;
	}

}
