package negozioLogika;

import java.util.ArrayList;

public abstract class Itsasontzia {
	protected ArrayList<ItsasontziTile> lista=new ArrayList<ItsasontziTile>();
	private int ezkutua=0;
	public Itsasontzia(){	}
	

	//equipar escudo
	public void ezkutuaIpini(){
		this.ezkutua=200;
	}
	//repararse (devuelve la lista de damagedtiles)
	public ArrayList<ItsasontziTile> suntsitutakoTile(){
		ArrayList<ItsasontziTile> lst=new ArrayList<ItsasontziTile>());
		for(int i=0; i<lista.size();i++){
			if (this.lista.get(i).suntsituta()) lst.add(this.lista.get(i));
		}
		return lst;
	}
	
	public boolean damageEzkutuari(int damage){
		if (this.ezkutua==0) return false;
		else{
			this.ezkutua-=damage;
			if (this.ezkutua<0) ezkutua=0;
			return true;
		}
	}
}
