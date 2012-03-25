import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import java.awt.event.MouseEvent;

public class trackMouse extends GraphicsProgram {
	
	public void run () {
		labal = new GLabel("");
		labal.setFont("Tahoma-24");
		add(labal, 50, 50);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e){
		labal.setLabel("Mouse:" + e.getX() + "," + e.getY());
	}
	
	private GLabel labal;
}