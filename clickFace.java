import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * #20
 * @author jiezou
 *
 */
public class clickFace extends GraphicsProgram {
	
	public static final String CLEAR = "Clear";
	public static final String FRONT = "Front";
	public static final String SMALL = "Small";
	public static final String MEDIUM= "Medium";
	public static final String LARGE = "Large";
	public static final double SMALL_DIAM =20;
	public static final double MEDIUM_DIAM= 40;
	public static final double LARGE_DIAM = 60;
	
	public void init(){
		resize(600, 600);
		
		add(new JButton(CLEAR), SOUTH);
		
		// TODO Why checkbox, radiobutton and combobox cannot set to new value?
		check = new JCheckBox(FRONT);
		check.setSelected(true);
		add(check, SOUTH);
		
		initRadioButton();
		initComboBox();
		
		addMouseListeners();
		addActionListeners();
	}
	
	private void initRadioButton(){
		sm = new JRadioButton(SMALL);
		med = new JRadioButton(MEDIUM);
		lrg = new JRadioButton(LARGE);
		ButtonGroup size = new ButtonGroup();
		size.add(sm);
		size.add(med);
		size.add(lrg);
		sm.setSelected(true);
		add(sm, SOUTH);
		add(med, SOUTH);
		add(lrg, SOUTH);
	}
	
	private void initComboBox(){
		pick = new JComboBox();
		pick.addItem("Black");
		pick.addItem("Blue");
		pick.addItem("Green");
		pick.addItem("Red");
		pick.setEditable(false);
		pick.setSelectedItem("Black");
		add(new JLabel("    Color:"), SOUTH);
		add(pick, SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if (cmd.equals(CLEAR)) {
			removeAll();
		}
	}
	
	public void mouseClicked(MouseEvent e){
		GObject obj;
		double diam = getDiamSize();
		if (check.isSelected()) {
			obj = new GFace(diam, diam);
		} else {
			obj = new GOval(diam, diam);
		}
		obj.setColor(getColor());
		add(obj, e.getX(), e.getY());
	}
	
	private double getDiamSize() {
		double size = 0;
		if (sm.isSelected()) {
			sm.setSelected(true);
			size = SMALL_DIAM;
		} else if (med.isSelected()){
			med.setSelected(true);
			size = MEDIUM_DIAM;
		} else {
			lrg.setSelected(true);
			size = LARGE_DIAM;
		}
		return size;
	}
	
	private Color getColor() {
		String name = (String) pick.getSelectedItem();
		if (name.equals("Blue")) {
			pick.setSelectedItem("Blue");
			return Color.BLUE;
		} else if (name.equals("Green")){
			pick.setSelectedItem("Green");
			return Color.GREEN;
		} else if (name.equals("Red")){
			pick.setSelectedItem("Red");
			return Color.RED;
		} else {
			pick.setSelectedItem("Black");
			return Color.BLACK;
		}
	}
	
	// instance variables
	private JCheckBox check;
	private JRadioButton sm;
	private JRadioButton med;
	private JRadioButton lrg;
	private JComboBox pick;
}