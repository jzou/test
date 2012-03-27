import acm.program.*;
import java.util.*;

/**
 * A little example to show hash map
 * @author jiezou
 *
 */
public class map extends ConsoleProgram {
	
	public void run() {
		Map<String, Integer> phonebook = new HashMap<String, Integer>();
		
		phonebook.put("Mom", 56671);
		phonebook.put("Dad", 56672);
		phonebook.put("Baby", 56673);
		
		for (String name: phonebook.keySet()) {
			System.out.println(name + "'s phone number is: " + phonebook.get(name));
		}
	}
}