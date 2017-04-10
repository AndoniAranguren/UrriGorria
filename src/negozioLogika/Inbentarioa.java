package negozioLogika;

import java.util.ArrayList;

public class Inbentarioa {//jokalari bakoitzak eta dendak inbentario bat izango dute
	
	private ArrayList<Objektuak> objektuak;

	public void objektuaKendu(String pObjektua){
		boolean aurkitua=false;
		int i=0;
		while (!aurkitua&&i<objektuak.size()){
			if (objektuak.get(i).izenBerdina(pObjektua)) aurkitua=true;
			i++;
		}
		if (aurkitua) this.objektuak.remove(i-1);
	}
	
	public void objektuaGehitu(String pMota){
		this.objektuak.add(ObjektuakFactory.getObjektuakFactory().createObjektua(pMota));
	}
}
