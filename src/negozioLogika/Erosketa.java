package negozioLogika;
import negozioLogika.commands.CommandErosketaEgin;
import java.util.ArrayList;
public class Erosketa {
	
	private ArrayList<Objektuak> erosketak = new ArrayList<Objektuak>();
	private int prezioa;
	private String mota;
	
	public Erosketa(int pPrezioa, String pMota, ArrayList<Objektuak> ob){
		prezioa=pPrezioa;
		mota=pMota;
		erosketak = ob;
	}
	public int getPrezioa(){
		return prezioa;
	}
	public void erosketaExekutatu(String pNork){
		new CommandErosketaEgin(pNork,this).exekutatu();
	}
	public ArrayList<Objektuak> getObjektuak() {
		return erosketak;
	}
	public String getIzena(){
		return mota;
	}
}
