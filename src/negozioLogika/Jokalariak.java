package negozioLogika;

import java.awt.Color;
import java.util.ArrayList;

public class Jokalariak {
	
	protected String izena,aurkaria;
	protected boolean bizirik;
	protected Mapa mapa;
	protected Inbentarioa inb;
	protected Denda denda;
	protected int dirua;
	protected Color kolorea;
	
	public Jokalariak(String pIzena){
		izena=pIzena;

		kolorea=new Color(
				(Partida.getPartida().nextInt(255)),
				(Partida.getPartida().nextInt(255)),
				(Partida.getPartida().nextInt(255)),
				255);
		
		jokalariaErreseteatu();
	}
	public void jokalariaErreseteatu(){
		denda= new Denda();
		inb = new Inbentarioa();
		dirua=200;
		bizirik=true;
		mapa= new Mapa(izena);
		
		ArrayList<Objektuak> objektuak=new ArrayList<Objektuak>();
		objektuak=denda.dendakIzakinakDitu(ErosketaFactory.getErosketaFactory()
				.createErosketa("DHasteko Objektu Guztiak"));
		denda.objektuakEman(objektuak, false);
		inb.objektuakEman(objektuak, true);
	}
	public void itsasontziakIpini() {
		ArrayList<Itsasontzia> itsasontziak=inb.itsasontziakLortu();
		int x=0,y=0,zaiakerak=0,ontziKop=0,pos=0;
		int min=Character.valueOf(izena.charAt(Partida.getPartida().nextInt(izena.length())));
		final int zaiakeraMax=mapa.getErrenkada();
		char n='N';
		String nora="NSWENSWE";
		boolean bilatzen=false;
		while(itsasontziak.size()>0){
			x=1;
			if(!bilatzen){
				bilatzen=true;
				pos=0;
				x = Partida.getPartida().nextInt(mapa.getErrenkada())+1;
				y = Partida.getPartida().nextInt(mapa.getZutabe());
				zaiakerak=0;
			}
			else while(x<mapa.getErrenkada()-1&&bilatzen&&zaiakerak<zaiakeraMax){
				y=1;		
				while(y<mapa.getZutabe()-1&&bilatzen&&zaiakerak<zaiakeraMax){
					int ind=0, 
					rNum=Partida.getPartida().nextInt(nora.length()/2);
					
					while(ind<nora.length()/2&&bilatzen){
						n=nora.charAt(rNum+ind);
						
						if(mapa.kokatuDaiteke(x, y,	n,itsasontziak.get(0).getLuzeera())){
							if(pos>min){
								itsasontziak.get(0).erabili(izena, x, y, n);
								ontziKop++;
								bilatzen=false;
								
								if(itsasontziak.get(0).getKopurua()<=0)
									itsasontziak.remove(0);
								}
							}else
								pos++;
							
						if(bilatzen)ind++;
					}
					if(bilatzen)y++;
				}
				if(bilatzen){
					x++;	
					zaiakerak++;
				}
			}if(zaiakerak>=zaiakeraMax){
				Partida.getPartida().komandoaAtzera(ontziKop-1);
				itsasontziak=inb.itsasontziakLortu();
				bilatzen=false;
				zaiakerak=0;
			}
		}
		System.out.println(izena+" bere itsasontziak kokatu ditu.");
	}
	
	public boolean kokatuDaiteke( int pX, int pY,  char pNorabidea, int pLuzeera){
		return mapa.kokatuDaiteke(pX, pY,  pNorabidea, pLuzeera);
	}
	public Itsasontzia itsasontziaJarri(Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return mapa.itsasontziaJarri(izena, pOntzi, pX, pY, pNorabidea, pZer);
	}
	public boolean izenHauDu(String pJ) {
		return pJ.equals(izena);
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
		if(!bizirik) Partida.getPartida().addTurnoanHilDirenak(izena);
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

	public void jokatu(int pFasea,boolean pZer) {
		if(!getBizirik()) Partida.getPartida().faseaAldatu(pZer);
		else {
			etsaiaBizirikKonprobatu();
			if(Partida.getPartida().getCpuAktibatu())
				jokatuCPU(pFasea);
		}
	}

	protected void etsaiaBizirikKonprobatu(){
		if(!Partida.jokalariaBizirikDago(aurkaria)) 
			aurkaria=Partida.getPartida().jokalariBiziBatLortu(izena);
	}
	protected void jokatuCPU(int pFasea) {
	}

	public Color getKolorea() {
		return kolorea;
	}

	public boolean cpuNaiz() {
		return false;
	}
	public String getAurkaria() {
		return aurkaria;
	}
	public void setAurkaria(String pIzen) {
		aurkaria=pIzen;
	}
}
