import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Lawnmower{

  public static void main(String[] args) {
	
		BufferedReader br = null;
		 
		try {
			br = new BufferedReader(new FileReader("/Users/apple/Downloads/B-small-practice.in"));
 
			int round = Integer.parseInt(br.readLine());
			
			for (int i=0; i<round; i++) {
				
				// read Row number and column number
				String strMN = br.readLine(); 
				String[] strMNArray = strMN.split(" ");
				int n = Integer.parseInt(strMNArray[0]);
				int m = Integer.parseInt(strMNArray[1]);
				int[][] a = new int[n][m];
				
				for(int j=0; j<n; j++) {
					// read every item
					String data = br.readLine();
					String[] str = data.split(" ");
					for(int k=0; k<m; k++){
						a[j][k] = Integer.parseInt(str[k]);
					}
				}
				
				// judge lawnmower
				Boolean flag = checkLawnmower(a);	
				
				if (flag) {
					System.out.println("Case #" + (i+1) +  ": YES");
				} else {
					System.out.println("Case #" + (i+1) +  ": NO");
				} 
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

	private static Boolean checkLawnmower(int[][] a) {
		Boolean flag = true;
		
		// get row number and column number
		int row = a.length;
		int column = a[0].length;
		
		// if signal line or column, return true
		if ((row == 1) || (column == 1)) {
			return flag;
		}
		
		// if more than one line or column, check whether "1" has the same column or same row
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				// judge each item is "1" or not
				if(a[i][j] == 1) {
					// if item = 1; then check all items in the same row is "1" or not 
					for (int columnIndex = 0; columnIndex < column; columnIndex++) {
						// if the same row has item, which is not "1"
						if(a[i][columnIndex] != 1) {
							// check all items in the same column is "1" or not
							for (int rowIndex = 0; rowIndex < row; rowIndex++) {
								// if the same column has item, which is not "1", then return false
								if(a[rowIndex][j] != 1) {
									return false;
								}
							}	
						}
					}			
				}
			}
		}	
		return flag;
	}
}
