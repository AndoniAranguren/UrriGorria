package negozioLogika;

public abstract class Tile {
	private int zut;
	private int err;
	private String[] ikusiAhal;
	private int kontJok=0;
	private boolean kokatuAhalDa = true;
	public Tile(int a, int b, String pJabea){
		zut=a;
		err=b;
		ikusiAhal[kontJok]=pJabea;
	}
	public void jo(String pErasotzaile, int pIndarra){
		if(!this.ikusiAhalDu(pErasotzaile)) ikusiAhal[kontJok++]=pErasotzaile;
		this.bizitzaAldatu(pIndarra);
	}
	public boolean ikusiAhalDu(String pNork){
		int ind=0;
		boolean aurkituta=false;
		while(!aurkituta && ind<=kontJok){
			aurkituta=ikusiAhal[ind]==pNork;
			if(!aurkituta) ind++;
		}
		return aurkituta;
	}
	public int getX(){
		return zut;
	}
	public int getY(){
		return err;
	}
	public boolean kokatuDaiteke() {
		return kokatuAhalDa;
	}
	private void bizitzaAldatu(int pIndarra){}
}
