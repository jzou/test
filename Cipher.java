import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

import java.lang.Character;

/**
 *  This is a Caesar shift cipher! 
 *  Simply replace each letter in the message with the letter that is XX places further down the alphabet.
 * @author jiezou
 *
 */
public class Cipher extends ConsoleProgram {
	
	public static final int COUNTER_MAX = 10000;
	
	public void run() {

		//int key = readInt ("Enter encryption number: ");
		//System.out.println("Enter encryption number: " + key);
		
		int key = rgen.nextInt (1, COUNTER_MAX);
		
		String plainText = readLine("Enter a plain message: ");
		String cipherText = encryptCeasar (plainText, key);
		System.out.println("#" + key + "# Cipher Text Is: " + cipherText);
		
		//String newPlain = encryptCeasar (cipherText, -key);
		//System.out.println("newPlain: " + newPlain);
	}
	
	private String encryptCeasar (String str, int index){
		String result = "";
		if (index < 0) {
			index = 26 - ( -index % 26);
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += cipherStr(ch, index);
		}
		return result;
	}
	
	private char cipherStr (char letter, int number){
		if (Character.isUpperCase(letter)) {
			return (char)('A' + (letter - 'A' + number)%26 );
		} else if (Character.isLowerCase(letter)){
			return (char)('a' + (letter - 'a' + number)%26 );
		} else {
			return letter;
		}		
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}