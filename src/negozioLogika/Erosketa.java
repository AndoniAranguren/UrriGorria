package negozioLogika;
import negozioLogika.commands.CommandErosketaEgin;
import java.util.ArrayList;
import java.util.Iterator;
public class Erosketa {
	
	private ArrayList<Objektuak> erosketak = new ArrayList<Objektuak>();
	private final int prezioa;
	private final String mota;
	
	public Erosketa(int pPrezioa, String pMota, ArrayList<Objektuak> ob){
		prezioa=pPrezioa;
		mota=pMota;
		erosketak = ob;
	}
	public int getPrezioa(){
		return prezioa;
	}
	public void erosketaExekutatu(String pNork){
		new CommandErosketaEgin(pNork,this);
	}
	public ArrayList<Objektuak> getObjektuak() {
		return erosketak;
	}
	public String getIzena(){
		return mota;
	}
	public Iterator<Objektuak> getIterator(){
		return erosketak.iterator();
	}
	public boolean fasekoObjektuBatDu(int pFase) {
		boolean aurkituta=false;
		for(Objektuak obj:erosketak){
			if(!aurkituta)aurkituta=obj.getFasea()==pFase;
		}
		return aurkituta;
	}
	public boolean diruNahikoaDu(int pDiru) {
		return pDiru>=prezioa;
	}
}
