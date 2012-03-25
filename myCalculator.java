import acm.program.ConsoleProgram;

public class myCalculator extends ConsoleProgram {
	
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int MUTIPLE = 3;
	public static final int DIVISION = 4;
	
	public void run() {
	
		double figure1 = readDouble("Give me a number: ");
		double figure2 = readDouble("Give me a number: ");
		
		int calc = 0;
		double result = 0.0;
		while(true) {
			calc = readInt("Choose a number( 1: ADD, 2: DELETE, 3: MUTIPLE, 4: DIVISION): ");	
			if (calc > 0 && calc < 5) break;
			println("This is a wrong number. Please give me a new one.");
		}
		
		if (calc == 1) {
			result = figure1 + figure2;
			println( figure1 + "+" + figure2 + "=" + result);
		} else if (calc == 2) {
			result = figure1 - figure2;
			println( figure1 + "-" + figure2 + "=" + result);
		} else if (calc == 3) {
			result = figure1 * figure2;
			println( figure1 + "*" + figure2 + "=" + result);
		} else if (calc == 4) {
			result = figure1 / figure2;
			println( figure1 + "/" + figure2 + "=" + result);
		}
	}
}