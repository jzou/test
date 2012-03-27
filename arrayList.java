import acm.program.ConsoleProgram;
import java.util.*;

/**
 * new type ArrayList
 * There is no need to identify the initial size of array
 * Array will be increased once called method add
 * @author jiezou
 *
 */
public class arrayList extends ConsoleProgram {
	
	public void run() {
		ArrayList<String> sList = new ArrayList<String>();
		
		while (true){
			String line = readLine("Enter a line: ");
			if (line.isEmpty()) break;
			sList.add(line);
		}
		
		Iterator<String> it = sList.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
				
		 for (int i=0; i<sList.size(); i++){
			System.out.println(sList.get(i));
		}
		
		System.out.println("END");
	}
}