/**
 * This class shows the different variables, they are local variable, instance variable and class variable
 * @author jiezou
 *
 */
public class myCounter {

	//constructor with parameter @startValue
	public myCounter (int startValue) {
		counter = startValue;
	}
	
	/*
	 *constructor without parameter
	 *initial the class
	 * 
	 */
	public myCounter () {
		counter = 1;
	}
	
	public int nextCounter () {	
		//local variable: temporary  
		int temporary = counter; 
		counter++;
		return (temporary);
		
	}
	
	// 1) instance variable : counter
	private int counter;
	
	// 2) class variable : counter
	//private static int counter;
}
