import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.program.Program;
import acm.util.ErrorException;

// PENDING ...
public class myAlbum extends Program {
	
	public void init(){
		resize(400, 400);
		
		albumName = new JTextField(10);
		add(new JLabel("Album Name: "), SOUTH);
		albumName.setEditable(true);
		add(albumName, SOUTH);
		
		canves = new MusicShopDisplay();
		add(canves);
		
		initInventory();
		
		addActionListeners();
		albumName.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e){
			if (e.getSource() == albumName) {
				println(albumName.getText());
				canves.displayInventory(inventory.get(albumName.getText()));
		}
	}
	
	private void initInventory() {
		try {
			BufferedReader br  = new BufferedReader(new FileReader("musicShop.txt"));;
			while(true) {
				String line = br.readLine();
				if (line == null) break;
				Album album = praseline(line);
				inventory.put(album.getAlbumName(), album);
			}
			br.close();
		}  catch (IOException ex) {
				throw new ErrorException(ex);
		}	
	}
	
	private Album praseline(String line) {
		int albumNameStart = line.indexOf("[") +1;
		int albumNameEnd = line.indexOf("]");
		String key = line.substring(albumNameStart,albumNameEnd );
		
		int bandNameStart = line.indexOf("[", albumNameEnd+1) +1;
		int bandNameEnd = line.indexOf("]", albumNameEnd+1);
		String bandName = line.substring(bandNameStart,bandNameEnd );
		
		int numStockedStart = line.indexOf(" ", bandNameEnd+1) +1;
		int numStocked = Integer.parseInt(line.substring(numStockedStart));
		
		return (new Album(key, bandName, numStocked));
	}

	private JTextField albumName;
	private HashMap<String,Album> inventory = new HashMap<String,Album>();
	private MusicShopDisplay canves;
}