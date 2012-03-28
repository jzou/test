import java.io.*;
import acm.program.ConsoleProgram;

/**
 * A simple file class to read and write file
 * @author Jie.Zou
 *
 */
public class file extends ConsoleProgram {
	public void run(){
		//Read a file from workspace\<project>\bin
		while(br == null) {
			try {
				br = new BufferedReader(new FileReader(readLine("Enter file name: ")));
			} catch (IOException ex) {
				println("There is no file exsits.");
			}	
		}
		readFile();
		
		//Write a file to workspace\<project>\bin
		while(bw == null) {
			try {
				bw = new BufferedWriter(new FileWriter(readLine("Enter file name: ")));
			} catch (IOException ex) {
				println("Something wrong with file name. Re-enter a new one.");
			}	
		}
		writeFile();
	}
	
	private void readFile(){
		try{
			while (true) {
				
				//read a line from text file
				String line = br.readLine();
				if (line == null) break;
				println(line);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void writeFile(){
		try{
			while (true) {
				
				//read a line from screen
				String line = readLine("Enter a new line: "); 
				if (line.equals("")) break;
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//instance variance
	private BufferedReader br  = null;
	private BufferedWriter bw  = null;
}