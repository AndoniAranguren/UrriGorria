package negozioLogika;

public abstract class Tile {
	private int zut;
	private int err;
	private  boolean jota = false;
	public Tile(int a, int b){
		zut=a;
		err=b;
	}
	public void jo(){
		jota = true;
	}
	public boolean jotaDago(){
		return jota;
	}
	public boolean kokalekuHauDa(int x, int y){
		if(zut==x && err==y) return true;
		else return false;
	}
	public int getX(){
		return zut;
	}
	public int getY(){
		return err;
	}
	public abstract boolean uraDa();
}
