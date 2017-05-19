package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public abstract class Jokalariak {
	
	protected String izena;
	private boolean bizirik;
	protected Mapa mapa;
	protected Inbentarioa inb;
	private Denda denda;
	private int dirua;
	
	public Jokalariak(String pIzena){
		izena=pIzena;
		jokalariaErreseteatu();
	}
	
	public void itsasontziakIpini() {
		ArrayList<Itsasontzia> itsasontziak=inb.itsasontziakLortu();
		int x=0,y=0,zaiakerak=0,ontziKop=0;
		final int zaiakeraMax=mapa.getErrenkada();
		char n='N';
		Random r = new Random();
		String nora="NSWENSWE";
		boolean bilatzen=false;
		while(itsasontziak.size()>0){
			x=0;
			if(!bilatzen){
				bilatzen=true;
				r = new Random();
				x = r.nextInt(mapa.getErrenkada());
				y = r.nextInt(mapa.getZutabe());
				zaiakerak=0;
			}
			else while(x<mapa.getErrenkada()-1&&bilatzen&&zaiakerak<zaiakeraMax){
				while(y<mapa.getZutabe()-1&&bilatzen&&zaiakerak<zaiakeraMax){
					int ind=0, 
					rNum=r.nextInt(4);
					
					while(ind<4&&bilatzen){
						n=nora.charAt(rNum+ind);
						
						if(mapa.kokatuDaiteke(x, y,	n,itsasontziak.get(0).getLuzeera())){
							itsasontziak.get(0).erabili(izena, x, y, n);
							ontziKop++;
							bilatzen=false;
							
							if(itsasontziak.get(0).getKopurua()<=0)
								itsasontziak.remove(0);
							}
						ind++;
					}
					y++;
				}
				x++;
				y=0;				
				zaiakerak++;
			}if(zaiakerak>=zaiakeraMax){
				Partida.getPartida().komandoaAtzera(ontziKop-1);
				itsasontziak=inb.itsasontziakLortu();
				bilatzen=false;
				zaiakerak=0;
			}
		}
		System.out.println(izena+" bere itsasontziak kokatu ditu.");
	}
	
	public void jokalariaErreseteatu(){
		denda= new Denda();
		inb = new Inbentarioa();
		dirua=0;
		bizirik=true;
		mapa= new Mapa(izena);
		
		ArrayList<Objektuak> objektuak=new ArrayList<Objektuak>();
		objektuak=denda.dendakIzakinakDitu(ErosketaFactory.getErosketaFactory()
				.createErosketa("DHasteko Objektu Guztiak"));
		denda.objektuakEman(objektuak, false);
		inb.objektuakEman(objektuak, true);
	}
	
	public boolean kokatuDaiteke( int pX, int pY,  char pNorabidea, int pLuzeera){
		return mapa.kokatuDaiteke(pX, pY,  pNorabidea, pLuzeera);
	}
	public Itsasontzia itsasontziaJarri(Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return mapa.itsasontziaJarri(izena, pOntzi, pX, pY, pNorabidea, pZer);
	}
	public boolean izenHauDu(String pJ) {
		return pJ==izena;
	}
	public ArrayList<Objektuak> dendakIzakinakDitu(Erosketa pErosketa) {
		return denda.dendakIzakinakDitu(pErosketa);		//Izakinik ez baldin badu, null bat bueltatuko du
	}
	public void jokalariariDiruaEman(int pPrezioa, boolean pZer) { 
		if(pZer==true)	dirua+=pPrezioa;
		else			dirua-=pPrezioa;
	}
	public void dendariObjektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		denda.objektuakEman(pObjektuak,pZer);
	}
	public void jokalariariObjektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		inb.objektuakEman(pObjektuak,pZer);
	}
	public String izenaLortu() {
		return izena;
	}
	public boolean objektuakNahikoakDitu(ArrayList<Objektuak> pObjektuak) {
		return inb.objektuakNahikoakDitu(pObjektuak);
	}
	public void jokalariariErasotu(String pNork, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		mapa=pObjektua.aktibatu(pNork,mapa, pX, pY, pNorabide, pZer);
		bizirik=mapa.itsasontziBizirik();
	}
	public boolean jokalariaBizirikDago() {
		return bizirik;
	}
	public String[][] mapaInterpretatu(String pNork){
		return mapa.mapaInterpretatu(pNork);
	}
	public boolean jokalariakDiruaDu(int pPrezioa) {
		return (dirua>=pPrezioa);
	}
	public String getIzena() {
		return izena;
	}
	public ArrayList<String> inbentarioaEman() {
		return inb.inbentarioaEman();
	}
	public ArrayList<String> dendaEman() {
		return denda.dendaEman();
	}
	public int jokalariakZenbatDiru() {
		return dirua;
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		inb.objektuaErabili(pNori,pInfo);
	}
	public boolean getBizirik(){
		return bizirik;
	}
	public abstract void jokatuCPU(int pFasea);
}
