package negozioLogika;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import interfazeGrafikoa.UrriGorriaUI;
import negozioLogika.commands.*;

public class Partida {
	
	private static Partida nPartida=null;
	private static ArrayList<Jokalariak> jokalariLista;
	private ArrayList<String>turnoHonetanHilDira;
	private int[] turnoraArte= new int[3],egoera= new int[3];
	private UrriGorriaUI ui;
	private boolean jarraitu,cpuaAktibatuta;
	private Random r;

	
	private Partida(){
		r= new Random(System.currentTimeMillis());
		jokalariLista = new ArrayList<Jokalariak>();
		turnoHonetanHilDira= new ArrayList<String>();
		egoera[2]=0;//iraupena
		egoera[1]=0;//txanda
		egoera[0]=0;//fasea
		turnoraArte[2]=0;//iraupena
		turnoraArte[1]=0;//txanda
		turnoraArte[0]=0;//fasea
		jarraitu=true;
		cpuaAktibatuta=true;
		ui=UrriGorriaUI.getUrriGorriaUI();
		ui.urriGorriaUIErreseteatu();
	}	
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}

	//=================================================================================
	//Jokoaren dinamika (Iraupena,turnoa,fasea)		===================================
	public void partidaErreseteatu(){
		nPartida=new Partida();
	}
	public void faseaAldatu(boolean pZer){
		if(pZer){
			faseaAhurrera();
		}else {
			faseaAtzera();}
		if(jarraitu)norenTxandaDa().jokatu(egoera[0],pZer);
		
	}
	private void faseaAtzera() {
		if(egoera[2]==0)	egoera[1]--; //Hasieraketa turnoan bagaude jokalaria aldatu
		else 			egoera[0]--; //Bestela fasea
		
		if(egoera[0]<0){//fasea
			egoera[0]=2;
			egoera[1]--;//txanda hurrengo jokalariarena
		}
		if(egoera[1]<0){
				egoera[0]=2;
				egoera[1]=jokalariLista.size()-1;
				egoera[2]--;//turno oso bat pasatu da
		}
		jarraitu=true;
	}
	private void faseaAhurrera() {
		int zenbatBizirik=0;
		for(Jokalariak jok : jokalariLista){
			if(jok.jokalariaBizirikDago())zenbatBizirik++;
		}
		if(egoera[2]>=turnoraArte[2]){
			if(egoera[1]>=turnoraArte[1])
				turnoHonetanHilDira.clear();
		}
		jarraitu=(zenbatBizirik>1);
		if(jarraitu){
			if(egoera[2]==0)	egoera[1]++; //Hasieraketa turnoan bagaude jokalaria aldatu
			else 			egoera[0]++; //Bestela fasea
			
			if(egoera[0]>2){//fasea
				egoera[0]=0;
				egoera[1]++;//txanda hurrengo jokalariarena
			}
			if(egoera[1]>=jokalariLista.size()){
					egoera[0]=0;
					egoera[1]=0;
					egoera[2]++;//turno oso bat pasatu da
			}
		}
	}
	public String norenTxandaDaIzena() {
		return norenTxandaDa().izenaLortu();
	}
	public Jokalariak norenTxandaDa() {
		return jokalariLista.get(egoera[1]);
	}
	public int[] egoeraLortu() {
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
		return egoera;
	}
	//=================================================================================
	//Interfazerako informazioa lortu				===================================
	public static ArrayList<String> inbentarioaEman(String pJokalaria) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).inbentarioaEman();
	}
	public static ArrayList<String> dendaEman(String pJokalaria) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendaEman();
	}
	public static ArrayList<String> logaEman(String pJokalaria) {
		return Battlelog.BattlelogaLortu().logaEman();
	}
	public int jokalariakZenbatDiru(String pJokalaria) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariakZenbatDiru();
	}
	public String getIrabazlea() {
		String irabazlea=null;
		if(!jarraitu){
			for(Jokalariak jok: jokalariLista)
				if(jok.jokalariaBizirikDago()) irabazlea=jok.getIzena();
		}
		return irabazlea;
	}
	//=================================================================================
	public UrriGorriaUI getUi() {
		return ui;
	}
	private static int jokalariarenPosLortu(String pJ) {
		int ind =0;
		Boolean aurkituta=false;
		while(!aurkituta && ind<(jokalariLista.size()-1)){
			if(jokalariLista.get(ind).izenHauDu(pJ)) aurkituta=true;
			else ind++;
		}
		return ind;
	}
	public static boolean kokatuDaiteke( String pJokalaria, int pX, int pY, char pNorabidea, int pLuzeera) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).kokatuDaiteke( pX, pY, pNorabidea, pLuzeera);
	}
	public static boolean jokalariakObjektuakNahikoakDitu(String pJokalari, ArrayList<Objektuak> pObjektuak) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalari)).objektuakNahikoakDitu(pObjektuak);
	}
	public static boolean jokalariaBizirikDago(String pNor) {
		return jokalariLista.get(jokalariarenPosLortu(pNor)).jokalariaBizirikDago();
	}
	public static boolean jokalariakDiruaDu(String pJokalaria, int pPrezioa) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariakDiruaDu(pPrezioa);
	}
	public static ArrayList<Objektuak> dendakIzakinakDitu(String pJokalaria, Erosketa pErosketa) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendakIzakinakDitu(pErosketa);
	}
	public String[][] mapaInterpretatu(String pNori){
		return jokalariLista.get(jokalariarenPosLortu(pNori)).mapaInterpretatu(norenTxandaDaIzena());
	}
	public static Itsasontzia itsasontziaJarri(String pJokalaria, Itsasontzia pOntzi, int pX, int pY, char pNorabidea, boolean pZer) {
		return jokalariLista.get(jokalariarenPosLortu(pJokalaria)).itsasontziaJarri(pOntzi, pX, pY, pNorabidea, pZer);
	}
	public static void jokalariariErasotu(String pJokalari,String pNori, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pNori)).jokalariariErasotu(pJokalari,pObjektua,pX,pY,pNorabide,pZer);
	}
	public static void jokalariariDiruaEman(String pJokalaria, int pPrezioa, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariariDiruaEman(pPrezioa, pZer);
	}
	public static void dendariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).dendariObjektuakEman(pObjektuak, pZer);
	}
	public static void jokalariariObjektuakEman(String pJokalaria, ArrayList<Objektuak> pObjektuak, boolean pZer) {
		jokalariLista.get(jokalariarenPosLortu(pJokalaria)).jokalariariObjektuakEman(pObjektuak, pZer);
	}
	public void itsasontziakIpini(){
		jokalariLista.get(egoera[1]).itsasontziakIpini();
	}
	public void partidaZehaztu(int[] pInfo) {
		for(int i=0;i<pInfo[0];i++){
			String izena=(i+1)+".Jokalaria";
			jokalariLista.add(new Jokalariak(izena));
		}
		for(int i=0;i<pInfo[1];i++){
			String izena=(i+1)+".CPU";
			jokalariLista.add(new CPU(izena));
		}
		for(Jokalariak jok:jokalariLista){
			jok.setAurkaria(jokalariBiziBatLortu(jok.getIzena()));
		}
	}
	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		if(pJokalaria==norenTxandaDaIzena()){
			switch (pKomandoa){
				case "CommandErosketaEgin":
					Erosketa e=ErosketaFactory.getErosketaFactory().createErosketa(pInfo[0]);
					new CommandErosketaEgin(pJokalaria,e);
					break;
				case "CommandObjektuaErabili":
					Objektuak ob=ObjektuakFactory.getObjektuakFactory().createObjektua(pInfo[0]);
					new CommandObjektuaErabili(pJokalaria,ob,Integer.parseInt(pInfo[1]),
							Integer.parseInt(pInfo[2]),pInfo[3].charAt(0));
					break;
				case "CommandItsasontziaIpini":
					Itsasontzia its=(Itsasontzia)ObjektuakFactory.getObjektuakFactory().createObjektua(pInfo[0]);
					new CommandItsasontziaIpini(pJokalaria,its,Integer.parseInt(pInfo[1]),
							Integer.parseInt(pInfo[2]),pInfo[3].charAt(0));

					break;
				case "CommandTxandaPasa":
					new CommandTxandaPasa();
					break;
			}
		}
	}
	public void komandoaAtzera(int pZenbat) {
		Battlelog.BattlelogaLortu().komandoaAtzera(pZenbat);
	}
	public void jokalariakObjektuaErabili(String pNori, String[] pInfo) {
		norenTxandaDa().objektuaErabili(pNori,pInfo);
		
	}
	public String[] jokalarienIzenakEman() {
		String[] izenak = new String[jokalariLista.size()];
		int ind=0;
		for(Jokalariak jok : jokalariLista){
			if(jok.jokalariaBizirikDago()){
				izenak[ind]=jok.getIzena();
				ind++;
			}
		}
		return izenak;
	}
	public String jokalariBiziBatLortu(String pNorentzat) {
		int i=nextInt(jokalariLista.size());
		String izena=null;
		while(izena==null){
			for(Jokalariak jok :jokalariLista){
				if(jok.getBizirik()&&!pNorentzat.equals(jok.getIzena())){
					if(i<=0)izena=jok.getIzena();
					else i--;}
			}
		}
		return izena;
	}
	public int nextInt(int pBalioa) {
		return r.nextInt(pBalioa);
	}
	public Color getKolorea(String pJokalaria) {
		Color c =jokalariLista.get(jokalariarenPosLortu(pJokalaria)).getKolorea();
		return c;
	}
	public void setCpuAktibatu(boolean pZer) {
		cpuaAktibatuta=pZer;
	}
	public boolean getCpuAktibatu() {
		return cpuaAktibatuta;
	}
	public ArrayList<String> getTurnoanHilDirenak(){
		return turnoHonetanHilDira;
	}
	public void addTurnoanHilDirenak(String pIzena) {
		if(!turnoHonetanHilDira.contains(pIzena)){
			turnoHonetanHilDira.add(pIzena);
			turnoraArte[0]=egoera[0];
			turnoraArte[1]=egoera[1];
			turnoraArte[2]=egoera[2]+1;
		}
	}
	public String getAurkaria(String pIzena) {
		return jokalariLista.get(jokalariarenPosLortu(pIzena)).getAurkaria();
	}
	public void setAurkaria(String pIzena) {
		norenTxandaDa().setAurkaria(pIzena);
	}
}
