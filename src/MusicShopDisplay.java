import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GRect;

 
public class MusicShopDisplay extends GCanvas implements ComponentListener{

	public MusicShopDisplay() {
		addComponentListener(this);
		lastAlbum = null;
	 }
	
	public void displayInventory(Album album){
		removeAll();
		lastAlbum = album;
		if (album != null) {
			int numStocked = album.getStockNumber();
			add(new GLabel("Album [" + album.getAlbumName() +"] by [" + album.getBandName() + "]"), 10, (getHeight()- BAR_HEIGHT)/2 - SPACE);
			
			double nextX = SPACE;
			for (int i =0; i<numStocked; i++){
				double barLength = (getWidth() / (double)MAX_INVENTORY) - SPACE;
				GRect rect = new GRect(nextX,  (getHeight()- BAR_HEIGHT)/2, barLength, BAR_HEIGHT);
				rect.setFilled(true);
				add(rect);
				nextX += barLength + SPACE;
			}
			
			GLabel label =new GLabel(numStocked + " in stock."); 
			add(label, 10, (getHeight() + BAR_HEIGHT)/2 + SPACE + label.getAscent());
		}
	}
	
	private void update(){
		displayInventory(lastAlbum);
	}

	
	private static final double BAR_HEIGHT = 20;
	private static final double SPACE = 10;
	private static final int MAX_INVENTORY = 20;
	
	private Album lastAlbum;

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		update();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
