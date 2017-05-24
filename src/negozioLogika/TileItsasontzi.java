package negozioLogika;

import java.util.ArrayList;

public class TileItsasontzi extends Tile {
	
	private final int bizitzaMax=100;
	private int bizitza;
	private ArrayList<Integer> bizitzaLehen;
	private Itsasontzia itsasontzia;
	
	public TileItsasontzi(String pJabea, Itsasontzia pItsasontzia, int pX, int pY) {
		super(pJabea,pX, pY);
		itsasontzia=pItsasontzia;
		bizitzaLehen=new ArrayList<Integer>();
		bizitza=bizitzaMax;
		bizitzaLehen.add(bizitza);
		super.kokatzekoGaitasunaEman(false);
		super.identifikadorea="Itsasontzi";
	}
	
	protected void bizitzaKendu(int pIndarra, boolean pZer){
		int emaitza=itsasontzia.jo(this, pIndarra, pZer);
		if(pZer){
			bizitzaLehen.add(0,bizitza);
			bizitza-=emaitza;
		}else{
			if(bizitzaLehen.size()<=0)bizitza=bizitzaMax;
			else{
				bizitza=bizitzaLehen.get(0);
				bizitzaLehen.remove(0);
			}
		}
		if (bizitzaOsoaDu())bizitza=bizitzaMax;
		itsasontzia.konprobazioak(pZer);
	}

	protected String identifikadorea(){
		if(getSuntsituta()){
			return "Suntzituta";
		}else if(!getBizirik()){
			return "Ukituta";
		}else if(getEzkutua()){
			return "Ezkutua";
		}else
			return identifikadorea;
	}
	public boolean itsasontziaDa() {
		return true;
	}

	public boolean bizitzaOsoaDu() {
		return bizitza>=bizitzaMax;
	}
	public boolean getBizirik(){
		return bizitza>0;
	}
	public boolean getSuntsituta() {
		return itsasontzia.getSuntzituta();
	}
	public boolean getEzkutua() {
		return itsasontzia.getEzkutua();
	}
	public void erabiliEkipo(String pMota, boolean pZer) {
		if(pMota.equals("Ezkutua")){
			itsasontzia.setEzkutua(pZer);
		}else if(pMota.equals("Konponketa")){
			itsasontzia.setKonponketa(pZer);
		}
	}

	public void setKonponketa(boolean pZer) {
		if(pZer){
			bizitzaLehen.add(0,bizitza);
			bizitza=bizitzaMax;
		}else{
			System.out.println("orain: " +bizitza);
			bizitza=bizitzaLehen.get(0);
			System.out.println("lehen: " +bizitza);
			bizitzaLehen.remove(0);
		}
	}
}