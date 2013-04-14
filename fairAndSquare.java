import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fairAndSquare {
  public static void main(String[] args) {

		BufferedReader br = null;
		System.out.println("start");
		 
		try {

			br = new BufferedReader(new FileReader("/Users/apple/Downloads/C-large-2.in"));
 
			int round = Integer.parseInt(br.readLine());
			
			for (int i=0; i< round; i++) {
				String line = br.readLine();
				int space = line.indexOf(" ");
				int length = line.length();
				long start = Long.parseLong(line.substring(0,space));
				long end = Long.parseLong(line.substring(space+1,length));
				 
				int count = 0;
				
				for (long j = start; j < end+1; j++) {
					 Boolean flag = checkFairAndSquare(j);
					 if (flag) {
						 count ++;
					 }
				}
				System.out.println("Case #" + (i+1) +  ": " + count);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static Boolean checkFairAndSquare(long j) {

		Boolean flag = false;
		
		// Check Fair
		flag = checkFair(j);
		if(!flag) {
			return flag;
		}
		
		// Check square
		double root = Math.sqrt(j);
		String str = String.valueOf(root);
		int dot = str.indexOf(".");
		if (!str.substring(dot+1).equals("0")) {
			flag = false;
			return flag;
		}
		
		// Check fair of root
		flag = checkFair((long)root);
		
		return flag;
	}

	private static Boolean checkFair(long number) {
		Boolean flagFair = true;
		
		String str = String.valueOf(number);
		long half = str.length()/2;
		for (int i=0; i< half; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1)) {
				flagFair = false;
			}
		}
		return flagFair;
	}
}
