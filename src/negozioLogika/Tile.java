package negozioLogika;

import java.util.ArrayList;

public abstract class Tile {
	protected int koordX;
	protected int koordY;
	protected ArrayList<String> ikusiAhal=new ArrayList<String>(); //Jabea 0.posizioan egongo da
	private int kokatuAhalDa = 0;  //0=Ezin da kokatu, Positiboa Bai, Negatiboa Ez
	protected String identifikadorea="Tile";
	
	public Tile(String pJabea, int pX, int pY){
		koordX=pX;
		koordY=pY;
		ikusiAhal.add(pJabea); //Jabea 0.posizioan egongo da
	}
	
	public void jo(String pErasotzaile, int pIndarra, boolean pZer){
		System.out.println("noren txanda: "+pErasotzaile);
		if(pZer) ikusiAhal.add(pErasotzaile);
		else {
			int i=ikusiAhal.size()-1;
			while(i>0&&!ikusiAhal.get(i).equals(pErasotzaile)) i--;
			ikusiAhal.remove(i);
		}
		bizitzaAldatu(pIndarra,pZer);
	}
	protected int bizitzaAldatu(int pIndarra, boolean pZer) {
		return 0;
	}

	public String erakutsi(String pNork){
		if(ikusiAhal.contains(pNork)) return identifikadorea();
		else return "Ezezaguna";
	}
	protected String identifikadorea(){
		return identifikadorea;
	}

	//Galderak -------------------------
	public boolean posizioanDago(int pX,int pY){
		return (koordX==pX && koordY==pY);
	}
	public boolean jabeaDa(String pJ){
		return ikusiAhal.get(0).equals(pJ);
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa>0;
	}
	public boolean equals(Tile pTile){
		return (pTile.posizioanDago(koordX, koordY) && pTile.jabeaDa(ikusiAhal.get(0)));
	}
	public boolean itsasontziaDa() {
		return false;
	}
	public boolean bizirikDago(){
		return false;
	}
	public boolean ondoratuta() {
		return false;
	}
	public boolean ezkutuaDu() {
		return false;
	}
	public boolean berdinak(ItsasontziTile tile) {
		return (tile.jabeaDa(ikusiAhal.get(0)) && tile.posizioanDago(koordX,koordY));
	}
	//---------------------------------------
	public void kokatzekoGaitasunaEman(boolean pZer){
		if(pZer){
			if(!kokatuDaiteke())
				kokatuAhalDa++;}
		else kokatuAhalDa--;
	}
	public void ezkutuaJarri(boolean pZer) {
		System.out.println("Ezin duzu ezkutua hemen jarria \""+identifikadorea+"\" naiz");
	}
	public int getX() {
		return koordX;
	}
	public int getY() {
		return koordY;
	}
}