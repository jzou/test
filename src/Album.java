public class Album{
	
	 public Album(String album, String band, int num) {
		 albumName = album;
		 bandName = band;
		 stockNumber = num;
	 }
	 
	 public String getAlbumName(){
		 return albumName;
	 }

	 public String getBandName(){
		 return bandName;
	 }
	 
	 public int getStockNumber(){
		 return stockNumber;
	 }
	 
	 public String toString(){
		 String result = "";
		 result = "<" + albumName + "> by " +  bandName + " has " + stockNumber + " in Stock.";
		 return result;
	 }
	 
	 private String albumName;
	 private String bandName;
	 private int stockNumber;
}