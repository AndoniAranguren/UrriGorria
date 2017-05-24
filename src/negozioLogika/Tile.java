package negozioLogika;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
	protected int koordX,koordY;
	protected HashMap<String,Integer> ikustenDuLista=new HashMap<String,Integer>();
	private int kokatuAhalDa = 1;  //0=Ezin da kokatu, Positiboa Bai, Negatiboa Ez
	protected String identifikadorea="Ura",jabea;
	
	public Tile(String pJabea, int pX, int pY){
		koordX=pX;
		koordY=pY;
		jabea=pJabea;
		ikustenDuLista.put(jabea, 1);
	}
	
	public void jo(String pErasotzaile, int pIndarra, boolean pZer){
		int zenbatetan=0;
		if(pZer){
			if(ikustenDuLista.containsKey(pErasotzaile)){
				zenbatetan=ikustenDuLista.get(pErasotzaile)+1;
			}else{
				zenbatetan=1;}
		}else {
			if(ikustenDuLista.containsKey(pErasotzaile)){
				zenbatetan=ikustenDuLista.get(pErasotzaile)-1;
			}else{
				zenbatetan=0;}
		}
		ikustenDuLista.put(pErasotzaile,zenbatetan);
		bizitzaKendu(pIndarra,pZer);
	}
	protected void bizitzaKendu(int pIndarra, boolean pZer) {
	}

	public String erakutsi(String pNork){
		String id="Ezezaguna";
		if(ikustenDuLista.containsKey(pNork))
			if(ikustenDuLista.get(pNork)>0)
				id=identifikadorea();
		 return id;
	}
	protected String identifikadorea(){
		return identifikadorea;
	}

	//Galderak -------------------------
	public boolean posizioanDago(int pX,int pY){
		return (koordX==pX && koordY==pY);
	}
	public boolean jabeaDa(String pJ){
		return jabea.equals(pJ);
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa>0;
	}
	public boolean equals(Tile pTile){
		return (pTile.posizioanDago(koordX, koordY) && pTile.jabeaDa(jabea));
	}
	public boolean itsasontziaDa() {
		return false;
	}
	public boolean getBizirik(){
		return false;
	}
	public boolean getSuntsituta() {
		return false;
	}
	public boolean getEzkutua() {
		return false;
	}
	public int getX() {
		return koordX;
	}
	public int getY() {
		return koordY;
	}
	//---------------------------------------
	public void kokatzekoGaitasunaEman(boolean pZer){
		if(pZer){
			if(!kokatuDaiteke())
				kokatuAhalDa++;}
		else kokatuAhalDa--;
	}
	public void erabiliEkipo(String pMota, boolean pZer) {
	}
}