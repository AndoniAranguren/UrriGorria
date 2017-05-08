package negozioLogika;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Tile {
	private int zut;
	private int err;
	private ArrayList<String> ikusiAhal; //Jabea 0.posizioan egongo da
	protected boolean kokatuAhalDa = true;
	protected String identifikadorea="Tile";
	
	public Tile(String pJabea, int pX, int pY){
		zut=pX;
		err=pY;
		ikusiAhal.add(0,pJabea); //Jabea 0.posizioan egongo da
	}
	
	public void jo(String pErasotzaile, int pIndarra, boolean pZer){
		if(pZer){
			if(!this.ikusiAhalDu(pErasotzaile)) ikusiAhal.add(pErasotzaile);
		}
		else{
			ikusiAhal.remove(pErasotzaile);
		}
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
		return (zut==pX && err==pY);
	}
	public boolean jabeaDa(String pJ){
		return ikusiAhal.get(0)==pJ;
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa;
	}
	public boolean equals(Tile pTile){
		return (pTile.posizioanDago(zut, err) && pTile.jabeaDa(ikusiAhal.get(0)));
	}
	//---------------------------------------
	public void kokatzekoGaitasunaEman(boolean pZer){
		kokatuAhalDa=pZer;
	}

}