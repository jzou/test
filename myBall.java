import acm.graphics.GOval;
import acm.program.GraphicsProgram;


public class myBall extends GraphicsProgram {
	
	private static final double R_BALL = 30;
	
	private static final double GRAVITY = 3;
	
	private static final int DELAY = 50;
	
	private static final double X_START = R_BALL / 2;
	
	private static final double Y_START = 80;
	
	private static final double X_VEL = 5;
	
	private static final double Y_VEL  = 0.9;

	private double xvel = X_VEL;
	
	private double yvel = 0.0;
	
	//private GOval ball;
	private GFace ball;
	public void run () {

		resize(600, 600); 
		pause(DELAY); // To make sure resize() works
		setup();

		while (ball.getX() < getWidth()) {
			moveBall();
			checkForCollision();
			pause(DELAY); // To make sure the move can be seen
		}		
	}
	
	/**
	 * setup GOval
	 */
/*	private void setup (){
		ball = new GOval (X_START, Y_START, R_BALL/2, R_BALL/2);
		ball.setFilled(true);

		add(ball);
	}
*/	
	
	/**
	 * setup GFace
	 */
	private void setup() {
		ball = new GFace(R_BALL/2, R_BALL/2);
		add(ball, X_START, Y_START);
	}
	
	private void moveBall (){	
		yvel += GRAVITY;
		ball.move(xvel, yvel);
	}
	
	private void checkForCollision (){
		double height = getHeight();

		if (ball.getY() > height - R_BALL) {
			yvel = -yvel + Y_VEL;
		}
	}	
}