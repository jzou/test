import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class ticTacToeTomek {

  public static void main(String[] args) {
	
		int round = 0;
		String[][] a = null;
		BufferedReader br = null;
		 
		try {

			br = new BufferedReader(new FileReader("/Users/apple/Downloads/A-large.in"));
 
			round = Integer.parseInt(br.readLine());
			a = new String[round][4];
			
			for (int i=0; i<round; i++) {
				for (int j = 0; j<4; j++) {
					a[i][j] = br.readLine();	
				}
				br.readLine();
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
		
		char[][][] symbol = readInput(round, a);
		
		for (int i=0; i<symbol.length;i++) {

			Boolean flagX = false;
			Boolean flagO = false;
			flagX = checkWin(symbol[i], 'X');
			flagO = checkWin(symbol[i], 'O');	
			
			if (flagX) {
				System.out.println("Case #" + (i+1) +  ": X won");
			} else if (flagO) {
				System.out.println("Case #" + (i+1) +  ": O won");
			} else {
			
				int dot = -1;
				for (int j = 0; j<4; j++) {
					dot = Arrays.binarySearch(symbol[i][j], '.'); 
					if (dot == 1) {
						break;	
					}
				}
	
				if (dot == 1) {
					System.out.println("Case #" + (i+1) +  ": Game has not completed");
				} else {
					System.out.println("Case #" + (i+1) +  ": Draw");	
				}
			}
		
		}	
	}

	private static char[][][] readInput(int round, String[][] line) {
		int num = round; 
		char[][][] ch = new char[num][4][4];
		for (int i = 0; i<num; i++) {
			for (int j = 0; j<4; j++) {
				for (int k = 0; k<4; k++)
					ch[i][j][k] = line[i][j].charAt(k);	
			}	 
		}		
		return ch;
	}
	
	private static Boolean checkWin(char[][] symbol, char ch) {
					
			// row
			for (int j = 0; j < 4; j++) {
				int count = 0;
				int countT = 0;
				for (int k = 0; k< 4; k++) {
					if (symbol[j][k] == ch) {
						count ++;	
					} 
					if (symbol[j][k] == 'T') {
						countT ++;
					}
										
					if (count == 4 || (count == 3 && countT == 1)) {	
						return true;
					}
				}
			}
			
			// column
			for (int j = 0; j < 4; j++) {
				int count = 0;
				int countT = 0;
				for (int k = 0; k< 4; k++) {
					if (symbol[k][j] == ch) {
						count ++;	
					}
					if (symbol[k][j] == 'T') {
						countT ++;
					}
					if (count == 4 || (count == 3 && countT == 1)) {
						return true;
					}
				}
			}
			
			//diagonal - 1
			int count = 0;
			int countT = 0;
			for (int j = 0; j<4; j++){
				if (symbol[j][j] == ch) {
					count ++;	
				}
				if (symbol[j][j] == 'T') {
					countT ++;
				}
				if (count == 4 || (count == 3 && countT == 1)) {	
					return true;
				}
			}
			
			//diagonal - 2
			count = 0;
			countT = 0;
			for (int j = 0; j<4; j++){
	
				if (symbol[j][3-j] == ch) {
					count ++;	
				}
				if (symbol[j][3-j] == 'T') {
					countT ++;
				}
				if (count == 4 || (count == 3 && countT == 1)) {
					return true;
				}
			}		
		return false;
	}
}
