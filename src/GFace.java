import acm.graphics.*;

public class GFace extends GCompound{
	
	public GFace(double width, double height) {
		head = new GOval(width,  height);
		add(head, -width/2, -height/2);
		
		rightEye = new GOval(EYE_WIDTH*width, EYE_HEIGHT*height);
		leftEye = new GOval(EYE_WIDTH*width, EYE_HEIGHT*height);
		add(rightEye, 0.25*width-width*EYE_WIDTH, -0.25*height-height*EYE_HEIGHT);
		add(leftEye, -0.25*width-width*EYE_WIDTH, -0.25*height-height*EYE_HEIGHT);
		
		initNose(NOSE_WIDTH*width, NOSE_HEIGHT*height);
		
		mouse = new GRect(MOUTH_WIDTH*width, MOUTH_HEIGHT*height);
		add(mouse, -MOUTH_WIDTH*width/2, 0.25*height-MOUTH_HEIGHT*height);
	}
	
	private void initNose(double width, double height) {
		nose = new GPolygon();
		nose.addVertex(0, -height/2);
		nose.addVertex(-width/2, height/2);
		nose.addVertex(width/2, height/2);
		add(nose, 0, 0);
	}
	
	private static final double EYE_WIDTH = 0.15;
	private static final double EYE_HEIGHT = 0.15;
	private static final double NOSE_WIDTH = 0.15;
	private static final double NOSE_HEIGHT = 0.10;
	private static final double MOUTH_WIDTH = 0.50;
	private static final double MOUTH_HEIGHT = 0.03;
	
	private GOval head;
	private GOval rightEye, leftEye;
	private GPolygon nose;
	private GRect mouse;
}