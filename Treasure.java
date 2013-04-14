import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Open chest 
 * @author Jie
 *
 */
public class Treasure {
  /**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// read file
			br = new BufferedReader(new FileReader("/Users/apple/Downloads/D-small-practice.in"));
			//br = new BufferedReader(new FileReader("/Users/apple/Downloads/test.in"));
			readInfo(br);
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

	/**
	 * read information from *.in file
	 * @param br
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private static void readInfo(BufferedReader br) throws NumberFormatException, IOException {
		// read round
		int round = Integer.parseInt(br.readLine());
		
		for (int i=0; i< round; i++) {
			String line = br.readLine();
			// read start number and chest number
			String[] arrayNo = line.split(" ");
			int k = Integer.parseInt(arrayNo[0]);
			int n = Integer.parseInt(arrayNo[1]);
			
			// read start key
			int[] startKey = new int[k];
			String strKey = br.readLine();
			String[] arrayKey = strKey.split(" ");
			for (int key = 0; key< k; key++) {
				startKey[key] = Integer.parseInt(arrayKey[key]);
			}
			
			// read chest info
			int[][] chest = new int[n+1][];
			for (int chestN = 1; chestN < n+1; chestN++) {
				String chestKey = br.readLine();
				String[] arrayChest = chestKey.split(" ");
				int lengthChest = arrayChest.length;
				
				// iterate each chest
				ArrayList<String> list = new ArrayList<String>();
				for (int j=0; j<lengthChest; j++) {
					list.add(arrayChest[j]);
				}
				
				// gather all chest
				chest[chestN] = new int[list.size()];
				for (int keyType=0; keyType<list.size(); keyType++){
					chest[chestN][keyType] = Integer.parseInt(list.get(keyType));
				}
				 
			}
			
			// check solution
			String solution = checkOutSolu(startKey, chest);
			
			
			// output
			System.out.println("Case #" + (i+1) +  ": " + solution);
		
		}

	}

	/**
	 * Check out whether all chests can be open
	 * @param startKey
	 * @param chestlist
	 * @return
	 */
	private static String checkOutSolu(int[] startKey, int[][] chestlist) {
		String solution = "";
		
		// initial closed chest list
		int length =  chestlist.length;
		ArrayList<String> closedList = new ArrayList<String>();
		for (int i=1; i<length; i++) {
			closedList.add(String.valueOf(i));
		}
		
		// initial available keys
		ArrayList<String> keyList = new ArrayList<String>();
		for (int i=0; i< startKey.length; i++) {
			keyList.add(String.valueOf(startKey[i]));	
		}
		
		// find the chest with most keys
		int indexMaxChest = 0;
		for(int i=1; i<length; i++) {
			indexMaxChest = maxChest(keyList, chestlist, closedList);
			
			// if indexMaxChest is 0, it means it didn't get best value
			if ( indexMaxChest != 0) {
				// get a best chest to open
				String openChest = String.valueOf(indexMaxChest);
				// Remove the open chest from closed chests
				closedList.remove(openChest);
				// Remove used keys
				keyList.remove(String.valueOf(chestlist[indexMaxChest][0]));
				// record the sequence of open chest
				solution += openChest + " ";
				// Add new keys
				for (int j=0; j<chestlist[indexMaxChest].length;j++) {
					keyList.add(String.valueOf(chestlist[indexMaxChest][j]));
				}
			}
		} 
			
		// Cannot open all chest
		if (!closedList.isEmpty()) {
			solution = "IMPOSSIBLE";
		}
		
		return solution;
	}

	/**
	 * get a index of the best chest to open
	 * @param key
	 * @param chestlist
	 * @param closedList
	 * @return
	 */
	private static int maxChest(ArrayList<String> key, int[][] chestlist, ArrayList<String> closedList) {
		int indexMax = 0;
		int lengthMax = 0;
		
		// loop all chests
		for (int index=1; index< chestlist.length; index++) {
			
			// only check chests which are still closed
			if (inList(closedList, index)) {
				
				// length of current chest
				int length = chestlist[index].length;
				
				// check key available
				Boolean flag = inList(key, chestlist[index][0]);
				
				// get the best length and key is available
				if (length > lengthMax && flag) {
					// store max length with index
					indexMax = index;
					lengthMax = length;
				}				
			}
		}
		return indexMax;
	}

	/**
	 * check integer in list
	 * @param key
	 * @param keyType
	 * @return
	 */
	private static Boolean inList(ArrayList<String> key, int keyType) {
		// loop the list
		for (int i=0; i<key.size(); i++) {
			// key in list
			if (keyType == Integer.parseInt(key.get(i))) {
				return true;
			}
		}
		
		// key not in list
		return false;
	}
}
