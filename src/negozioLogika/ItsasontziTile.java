package negozioLogika;

import java.util.ArrayList;

public class ItsasontziTile extends Tile {
	
	private final int bizitzaMax=100;
	private int bizitza;
	private ArrayList<Integer> bizitzaLehen;
	private boolean suntsituta,ezkutua;
	
	public ItsasontziTile(String pJabea, int pX, int pY) {
		super(pJabea,pX, pY);
		bizitzaLehen=new ArrayList<Integer>();
		bizitza=bizitzaMax;
		bizitzaLehen.add(bizitza);
		suntsituta=false;
		ezkutua=false;
		super.kokatzekoGaitasunaEman(false);
		super.identifikadorea="Itsasontzi";
	}
	
	protected int bizitzaKendu(int pIndarra, boolean pZer){
		if(pZer){
			bizitzaLehen.add(0,bizitza);
			bizitza-=pIndarra;
		}else{
			if(bizitzaLehen.size()<=0)bizitza=bizitzaMax;
			else{
				bizitza=bizitzaLehen.get(0);
				bizitzaLehen.remove(0);
			}
		}
		if (bizitzaOsoaDu())bizitza=bizitzaMax;
		suntsituta=!getBizirik();
		return bizitza;
	}

	protected String identifikadorea(){
		if(suntsituta){
			return "Suntzituta";
		}else if(!getBizirik()){
			return "Ukituta";
		}else if(ezkutua){
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
	public void setSuntsituta(boolean pZer) {
		suntsituta=pZer;	
	}
	public boolean getSuntsituta() {
		return suntsituta;
	}

	public void setEzkutua(boolean pZer) {
		ezkutua=pZer;		
	}
	public boolean getEzkutua() {
		return ezkutua;
	}

	public void setKonponketa(boolean pZer) {
		if(pZer){
			bizitzaLehen.add(0,bizitza);
			bizitza=bizitzaMax;
		}else{
			if(bizitzaLehen.size()<=0)bizitza=bizitzaMax;
			else{
				bizitza=bizitzaLehen.get(0);
				bizitzaLehen.remove(0);
			}
		}
	}
}