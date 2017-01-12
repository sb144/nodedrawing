package sonder.nodedrawing.v2;

public class Range {
	
	public int minimum, maximum;
	
	public Range(int minimum, int maximum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	public boolean in(int val) {
		return (val >= minimum && val <= maximum); 
	}
	
	public int size() {
		return maximum - minimum;
	}

}
