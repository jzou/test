import acm.util.*;
import acm.graphics.GRect;
import acm.graphics.GImage;
import acm.program.*;

public class helloWorld extends GraphicsProgram {
	
	public static final int COUNTER_MAX = 6;
	
	public void run () {
		// Part 1 FOR Random generator
		int dieRoll = rgen.nextInt (1, COUNTER_MAX);
		println ("You rolled: " + dieRoll);
		
		// 	Part 2 FOR adding an object
		GRect rect = new GRect (10, 10, 100, 100);
		rect.setFilled(true);
		add(rect);
		
		for (int i=0; i<50; i++){
			rect.setFillColor(rgen.nextColor());
			if (i%2 == 0){
				rect.setVisible(true);
			} else {
				rect.setVisible(false);
			}
			pause(50);
		}		
	
		
//		GImage image = new GImage ("IMG_1381.JPG");
//		add(image, 0, 0);
		
		// Part 3 FOR calling my own class
		myCounter mc1 = new myCounter ();
		myCounter mc2 = new myCounter (1000);
		
		counterFiveTime (mc1);
		counterFiveTime (mc2);	
		counterFiveTime (mc1);
		
	}
	
	private void counterFiveTime (myCounter mc){
		for (int i=0; i<COUNTER_MAX; i++) {
			println (mc.nextCounter());
		}
	}
	
	//instance variable
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
}
