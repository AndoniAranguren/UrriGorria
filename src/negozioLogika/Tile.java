package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Tile {
	private int koordX;
	private int koordY;
	private ArrayList<String> ikusiAhal=new ArrayList<String>(); //Jabea 0.posizioan egongo da
	protected boolean kokatuAhalDa = true;
	protected String identifikadorea="Tile";
	
	public Tile(String pJabea, int pX, int pY){
		koordX=pX;
		koordY=pY;
		ikusiAhal.add(pJabea); //Jabea 0.posizioan egongo da
	}
	
	public void jo(String pErasotzaile, int pIndarra, boolean pZer){
		if(pZer) ikusiAhal.add(pErasotzaile);
		else ikusiAhal.remove(pErasotzaile);
		if(this instanceof ItsasontziTile) ((ItsasontziTile)(this)).bizitzaAldatu(pIndarra,pZer);
	}
	public String erakutsi(String pNork){
		if(ikusiAhalDu(pNork)){
			return identifikadorea;
		}
		return "Ezezaguna";
	}
	//Galderak -------------------------
	public boolean ikusiAhalDu(String pNork){
		Iterator<String> it=ikusiAhal.iterator();
		boolean aurkituta=false;
		while(!aurkituta && it.hasNext()){
			aurkituta=it.next()==pNork;
		}
		return aurkituta;
	}
	
	public boolean posizioanDago(int pX,int pY){
		return (koordX==pX && koordY==pY);
	}
	public boolean jabeaDa(String pJ){
		return ikusiAhal.get(0)==pJ;
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa;
	}
	public boolean equals(Tile pTile){
		return (pTile.posizioanDago(koordX, koordY) && pTile.jabeaDa(ikusiAhal.get(0)));
	}
	//---------------------------------------
	public void kokatzekoGaitasunaEman(boolean pZer){
		kokatuAhalDa=pZer;
	}
	public boolean itsasontziaDa() {
		return false;
	}
	public boolean bizirikDago(){
		return false;
	}

}