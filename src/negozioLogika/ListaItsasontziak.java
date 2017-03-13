package negozioLogika;

import java.util.ArrayList;

public class ListaItsasontziak {
	private ArrayList<Itsasontzia> itsasontziak;
	public ListaItsasontziak(){
		itsasontziak = new ArrayList<Itsasontzia>();
	}
	public void itsasontziaGehitu(Itsasontzia pItsasontzia){
		itsasontziak.add(pItsasontzia);
	}
	public void itsasontziaKendu(Itsasontzia pItsasontzia){
		itsasontziak.remove(pItsasontzia);
	}
}
