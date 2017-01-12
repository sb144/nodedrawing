package sonder.nodedrawing.v2;

import javax.swing.JFrame;

public class UnitTest {
	
	public static void main(String[] args) {
		Generator.init();
		Colors.defaultSet();
		
		//quadrantTest();
		
		//genTest();
		
		Canvas canvas = Generator.web(1000, 1000, 2, 2);
		
		RenderPanel render = new RenderPanel(canvas, true, true);
		JFrame frame = new JFrame();
		frame.setContentPane(render);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void quadrantTest() {
		Canvas canvas = new Canvas(1000, 1000);
		canvas.setCrowding(100.0);
		canvas.setOrigin(500, 500);
		canvas.setTiers(1);
		
		Node origin = new Node(500, 500, 0L, 0L, new Vector(0, 0), 0);
		
		Vector q1v = new Vector(50, 30);
		Point q1p = q1v.translate(origin.getPoint());
		Node q1n = new Node(q1p.getX(), q1p.getY(), 1L, 0L, new Vector(0, 0), 1);
		
		Vector q2v = new Vector(50, 120);
		Point q2p = q2v.translate(origin.getPoint());
		Node q2n = new Node(q2p.getX(), q2p.getY(), 2L, 0L, new Vector(0, 0), 1);
		
		Vector q3v = new Vector(50, 220);
		Point q3p = q3v.translate(origin.getPoint());
		Node q3n = new Node(q3p.getX(), q3p.getY(), 3L, 0L, new Vector(0, 0), 1);
		
		Vector q4v = new Vector(50, 300);
		Point q4p = q4v.translate(origin.getPoint());
		Node q4n = new Node(q4p.getX(), q4p.getY(), 4L, 0L, new Vector(0, 0), 1);
		
		Vector q1childv = new Vector(50, 40);
		Point q1childp = q1childv.translate(q1p);
		Node q1child = new Node(q1childp.getX(), q1childp.getY(), 5L, 0L, new Vector(0, 0), 2);
		
		canvas.add(origin);
		canvas.add(q1n);
		canvas.add(q2n);
		canvas.add(q3n);
		canvas.add(q4n);
		canvas.add(q1child);
		
		Log.write(q1p + "");
		Log.write(q2p + "");
		Log.write(q3p + "");
		Log.write(q4p + "");
		Log.write(q1childp + "");
		
		RenderPanel render = new RenderPanel(canvas, false, true);
		JFrame frame = new JFrame();
		frame.setContentPane(render);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void genTest() {
		int wrong = 0;
		int parentAngle = 90;
		Range rng = new Range(90-60, 90+60);
		for(int i = 0; i < 10000; i++) {
			int rndAngle = Vector.randomAngle(parentAngle, rng.getMinimum(), rng.getMaximum());
			if(!rng.in(rndAngle)) {
				wrong++;
				Log.write("wrong for " + rndAngle);
			}
		}
		
		Log.write("wrong=" + wrong);
	}

}
