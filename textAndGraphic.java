import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import acm.graphics.*;
import acm.program.*;

public class textAndGraphic extends ConsoleProgram {
	
	public void init() {
		
		resize(400, 400);
		
		setLayout(new GridLayout(1,3));
		leftCanvas = new GCanvas();
		rightCanvas = new GCanvas();
		add(leftCanvas);
		add(rightCanvas);
		
		color = new JTextField(10);
		color.setEditable(true);
		add(new JLabel("Color: "), SOUTH);
		add(color, SOUTH);
		color.addActionListener(this);
		
		add(new JButton("Draw left"), SOUTH);
		add(new JButton("Draw right"), SOUTH);
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		String str = "Black"; // TODO Why JTextField cannot be shown?
		
		if (e.getSource() == color) {
			str = color.getText();
			println(str);
		}
		
		String cmd = e.getActionCommand();
		if (cmd.equals("Draw left")){
			leftCanvas.add(createRect(), 20, leftY);
			leftY += SPACE;
		} else if (cmd.equals("Draw right" )) {
			rightCanvas.add(createRect(), 20, rightY);
			rightY += SPACE;
		}
	}
	
	private GRect createRect(){
		GRect rect = new GRect(50,20);
		rect.setFilled(true);
		return rect;
	}
	
	
	private int rightY = 10;
	private int leftY = 10;
	private static final int SPACE = 30;
	public JTextField color;
	private GCanvas leftCanvas, rightCanvas;

}