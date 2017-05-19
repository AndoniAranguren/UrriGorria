package interfazeGrafikoa.externals;

import javax.swing.ImageIcon;

import interfazeGrafikoa.*;


public class Irudiak {
	private static Irudiak nireBurua;
	
	private Irudiak(){
	}
	public static Irudiak getIrudiak() {
		return nireBurua == null ? (nireBurua= new Irudiak()) : nireBurua;
	}
	public ImageIcon imaginaLortu(String pAux){
		return new ImageIcon(TableroaUI.class.getResource("/interfazeGrafikoa/externals/"+pAux));
	}
	public ImageIcon norabideaLortu() {
		String aux;
		switch (UrriGorriaUI.norabideaLortu()){
			case 0: aux="eki.png";
				break;
			case 1: aux="hego.png";
				break;
			case 2: aux="mend.png";
				break;
			case 3: aux="ipar.png";
				break;
			default: aux="eki.png";
				break;
		}
		return Irudiak.getIrudiak().imaginaLortu(aux);		 
	}
}
