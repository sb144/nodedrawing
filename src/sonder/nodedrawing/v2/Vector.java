package sonder.nodedrawing.v2;

import java.util.Random;

public class Vector {
	
	public static final Random random = new Random();
	
	public int distance, angle;
	
	public Vector(int distance, int angle) {
		this.distance = distance;
		this.angle = angle;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	/*public Point translate(Point origin) {
		double relX = Math.cos(Math.toRadians(360 - angle)) * distance;
		double relY = Math.sin(Math.toRadians(360 - angle)) * distance;
		int x = origin.getX() + (int)relX;
		int y = origin.getY() + (int)relY;
		Log.write("Translation: org(" + origin.getX() + ", " +origin.getY() + ") angle=" + angle + ", distance=" + distance + " to (" + x + ", " + y + ")");
		return new Point(x, y);
	}*/
	
	public Point translate(Point origin) {
		double relX = Math.cos(Math.toRadians(360 - angle)) * distance;
		double relY = Math.sin(Math.toRadians(360 - angle)) * distance;
		
		int x = 0, y = 0;
		
		if(angle >= 0 && angle < 90) {
			x = origin.getX() + (int)relX;
			y = origin.getY() + (int)relY;
		}
		
		if(angle >= 90 && angle < 180) {
			x = origin.getX() - (int)relX;
			y = origin.getY() - (int)relY;
		}
		
		if(angle >= 180 && angle < 270) {
			x = origin.getX() + (int)relX;
			y = origin.getY() + (int)relY;
		}
		
		if(angle >= 270 && angle < 360) {
			x = origin.getX() - (int)relX;
			y = origin.getY() - (int)relY;
		}
		
		return new Point(x, y);
	}
	
	//Static methods
	
	public static Vector randomMovement(Range distanceRange, int parentAngle) {
		int distance = random(distanceRange);
		int angle = randomAngle(
				parentAngle,
				angularSubtraction(parentAngle, 60),
				angularAddition(parentAngle, 60));
		
		if(parentAngle > 180) {
			angle = angularSubtraction(360, angle);
		}
		
		return new Vector(distance, angle);
	}
	
	public static Vector stemFrom(Canvas canvas, Node parent) {
		Range distanceRange = new Range(50, 100);
		
		return Vector.randomMovement(distanceRange, canvas.get(parent.getParentID()).getVector().getAngle());
	}
	
	public static int distanceInQuadrant(int quadrant, int angle) {
		return 0;
	}
	
	public static int randomAngle(int parent, int a, int b) {
		
		Range accept = new Range(a, b);
		int rnd = random(0, accept.size());
		return a + rnd;
		
	}
	
	public static int angularAddition(int a, int b) {
		int c = a + b;
		if(c > 360) {
			int diff = Math.abs(360 - c);
			return diff;
		} else if(c < 0) {
			int diff = Math.abs(360 + c);
			return diff;
		} else {
			return c;
		}
	}
	
	public static int angularSubtraction(int a, int b) {
		int c = a - b;
		if(c > 360) {
			int diff = Math.abs(360 - c);
			return diff;
		} else if(c < 0) {
			int diff = Math.abs(360 + c);
			return diff;
		} else {
			return c;
		}
	}
	
	public static int random(int min, int max) {
		int bound = (max - min) + 1;
		if(bound < 0)
			bound = 1;
		
		return random.nextInt(bound) + min;
	}
	
	public static int random(Range range) {
		return random.nextInt((range.getMaximum() - range.getMinimum()) + 1) + range.getMinimum();
	}
	
	@Override
	public String toString() {
		return "Angle: " + this.getAngle() + ", Distance: " + this.getDistance();
	}

}
