import java.awt.event.*;
import javax.swing.*;
import acm.program.ConsoleProgram;

public class button extends ConsoleProgram {
	
	public static final String CONFIRM = "Hi";
	public void init(){
		add(new JButton(CONFIRM), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if (cmd.equals(CONFIRM)) {
			println("It is OK.");
		}
	}
}