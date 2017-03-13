
package negozioLogika;

import java.util.ArrayList;

public class Tile {
	private ArrayList<String> norkIkusi=new ArrayList<String>();
	private int X;
	private int Y;
	
	
	public Tile(String jabea, int pY,int pX){
		this.norkIkusi.add(jabea);
		this.X=pX;
		this.Y=pY;
	}
	//desbloquear vision de jugador(añadir al arraylist de player el String de quien lo pueda ver (de quien dispare y del propietario)
	public void bistaratu(String etsaia){
		this.norkIkusi.add(etsaia);
	}
	public void eraso(String etsaia, int damage){
		this.bistaratu(etsaia);
	}
}
