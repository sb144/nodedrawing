package sonder.nodedrawing.v2;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

public class Colors {
	
	private static HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
	private static Random random = new Random();
	
	public static void defaultSet() {
		colors.clear();
		colors.put(0, Color.decode("#FF0000"));
		colors.put(1, Color.decode("#A200FF"));
		colors.put(2, Color.decode("#00FFE5"));
		colors.put(3, Color.decode("#00FF33"));
		colors.put(4, Color.decode("#FF9D00"));
		colors.put(5, Color.decode("#CC00FF"));
	}
	
	public static void randomSet(int tiers) {
		colors.clear();
		for(int i = 0; i < tiers; i++) {
			colors.put(i, newColor());
		}
	}
	
	public static Color newColor() {
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		return new Color(r, g, b);
	}
	
	public static Color get(int tier) {
		if(colors.containsKey(tier))
			return colors.get(tier);
		
		return Color.decode("000000");
	}

}
