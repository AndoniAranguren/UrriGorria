package negozioLogika;

public abstract class Tile {
	private int zut;
	private int err;
	private String[] ikusiAhal;
	private int kontJok=0;
	protected boolean kokatuAhalDa = true;
	protected String identifikadorea="Tile";
	
	public Tile(String pJabea, int pX, int pY){
		zut=pX;
		err=pY;
		ikusiAhal[kontJok]=pJabea;
	}
	
	public void jo(String pErasotzaile, int pIndarra){
		if(!this.ikusiAhalDu(pErasotzaile)) ikusiAhal[kontJok++]=pErasotzaile;
		this.bizitzaAldatu(pIndarra);
	}
	public String erakutsi(String pNork){
		if(ikusiAhalDu(pNork)){
			return identifikadorea;
		}
		return "Ezezaguna";
	}
	//Galderak -------------------------
	public boolean ikusiAhalDu(String pNork){
		int ind=0;
		boolean aurkituta=false;
		while(!aurkituta && ind<=kontJok){
			aurkituta=ikusiAhal[ind]==pNork;
			if(!aurkituta) ind++;
		}
		return aurkituta;
	}
	public boolean posizioanDago(int pX,int pY){
		return (zut==pX && err==pY);
	}
	public boolean jabeaDa(String pJ){
		return ikusiAhal[0]==pJ;
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa;
	}
	public boolean equals(Tile pTile){
		return (pTile.posizioanDago(zut, err) && pTile.jabeaDa(ikusiAhal[0]));
	}
	//---------------------------------------
	public void kokatzekoGaitasunaEman(boolean pZer){
		kokatuAhalDa=pZer;
	}
	private void bizitzaAldatu(int pIndarra){}
}