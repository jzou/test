import java.awt.event.ActionEvent;
import javax.swing.*;

import acm.gui.*;
import acm.graphics.GMath;
import acm.gui.IntField;
import acm.program.Program;


public class temperature extends Program {
	
	public void init(){
		resize(300, 300);
		
		setLayout(new TableLayout (2,3));
		
		fTextField = new IntField();
		fTextField.setActionCommand(F_TO_C);
		fTextField.addActionListener(this);
		
		cTextField = new IntField();
		cTextField.setActionCommand(C_TO_F);
		cTextField.addActionListener(this);
		
		add(new JLabel("Degree Fahrenheit:"));
		add(fTextField);
		add(new JButton(F_TO_C));
		
		add(new JLabel("Degree Celsius:"));
		add(cTextField);
		add(new JButton(C_TO_F));
	
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand(); 
		if (cmd.equals(F_TO_C)){
			int f = fTextField.getValue();
			int c = GMath.round((5.0/9.0)*(f-32));
			cTextField.setValue(c);
		} else if (cmd.equals(C_TO_F)) {
			int c = cTextField.getValue();
			int f = GMath.round((9.0/5.0)*c+32);
			fTextField.setValue(f);
		}
	}
	
	private static final String F_TO_C = "F->C";
	private static final String C_TO_F = "C->F";
	
	private IntField cTextField;
	private IntField fTextField;
}