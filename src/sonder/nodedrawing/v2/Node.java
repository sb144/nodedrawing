package sonder.nodedrawing.v2;

import java.util.ArrayList;

public class Node {
	
	public int x, y;
	public long id, parentID;
	public Vector vector;
	public int tier;
	
	public Node() {}
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.id = -1L;
		this.tier = 1;
		this.vector = new Vector(0, 0);
		this.parentID = -2L;
	}
	
	public Node(int x, int y, long id, long parentID, Vector vector, int tier) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tier = tier;
		this.vector = vector;
		this.parentID = parentID;
	}
	
	public Node(Point position, long id, long parentID, Vector vector, int tier) {
		this.x = position.getX();
		this.y = position.getY();
		this.id = id;
		this.tier = tier;
		this.vector = vector;
		this.parentID = parentID;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point getPoint() {
		return new Point(x, y);
	}
	
	public void setPoint(Point point) {
		this.x = point.getX();
		this.y = point.getY();
	}

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
