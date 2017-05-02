package negozioLogika;

import java.util.ArrayList;

public class Denda {
	private ArrayList<Objektuak> lista;
	private static Denda nDenda=null;
	private Denda(){}
	public static synchronized Denda getDenda(){
		if(nDenda==null){ nDenda= new Denda();}
		return nDenda;
	}
	public void dendaEguneratu(){
		
	}
}
