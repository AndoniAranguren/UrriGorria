package negozioLogika;

import java.util.ArrayList;

import frontend.UrriGorriaUI;
import negozioLogika.commands.*;

public class Partida {
	
	private static Partida nPartida=null;
	private static ArrayList<Jokalariak> jokalariLista;
	private static int maxJok=0;
	private int[] egoera= new int[3];
	private UrriGorriaUI ui;

	
	private Partida(){
		jokalariLista = new ArrayList<Jokalariak>();
		egoera[2]=0;//iraupena
		egoera[1]=0;//txanda
		egoera[0]=0;//fasea
	}	
	public static synchronized Partida getPartida(){
		if(nPartida==null){ nPartida = new Partida();}
		return nPartida;
	}

	//=================================================================================
	//Jokoaren dinamika (Iraupena,turnoa,fasea)		===================================
	public void partidaJokatu(){
		this.ui = new UrriGorriaUI();
	}
	public void faseaAldatu(boolean pZer){
		if(pZer) faseaAhurrera();
		else faseaAtzera();
		if(norenTxandaDaIzena().split(".",1).equals("CPU"))
			norenTxandaDa().jokatuCPU(egoera[0]);
	}
	private void faseaAtzera() {
		if(egoera[2]==0)	egoera[1]--; //Hasieraketa turnoan bagaude jokalaria aldatu
		else 			egoera[0]--; //Bestela fasea
		
		if(egoera[0]>2 &&egoera[0]<0){//fasea
			egoera[0]=2;
			egoera[1]--;//txanda hurrengo jokalariarena
		}
		if(egoera[1]<0){
				egoera[0]=2;
				egoera[1]=maxJok;
				egoera[2]--;//turno oso bat pasatu da
		}
		
			
	}
	private void faseaAhurrera() {
		if(egoera[2]==0)	egoera[1]++; //Hasieraketa turnoan bagaude jokalaria aldatu
		else 			egoera[0]++; //Bestela fasea
		
		if(egoera[0]>2 || egoera[0]<0){//fasea
			egoera[0]=0;
			egoera[1]++;//txanda hurrengo jokalariarena
		}
		if(egoera[1]>=maxJok){
				egoera[0]=0;
				egoera[1]=0;
				egoera[2]++;//turno oso bat pasatu da
		}
	}
	public String norenTxandaDaIzena() {
		return jokalariLista.get(egoera[1]).izenaLortu();
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
	//=================================================================================
	public UrriGorriaUI getUi() {
		return ui;
	}
	private static int jokalariarenPosLortu(String pJ) {
		int ind =0;
		Boolean aurkituta=false;
		while(!aurkituta && ind<(maxJok-1)){
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
	public void partidaZehaztu(String pInfo) {
		maxJok++;
		jokalariLista.add(new Jokalaria("1.Jokalaria"));
		maxJok++;
		if(pInfo.equals("BI_JOKALARI")){
			jokalariLista.add(new Jokalaria("2.Jokalaria"));
		}else if(pInfo.equals("MAKINAREN_AURKA_ERREZA")){
			jokalariLista.add(new CPU("1.CPU", 1));
		}else if(pInfo.equals("MAKINAREN_AURKA_ZAILA")){
			jokalariLista.add(new CPU("1.CPU", 2));
			jokalariLista.add(new CPU("2.CPU", 2));
		}
	}
	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		if(pJokalaria==norenTxandaDaIzena()){
			System.out.println("Zure txanda da");
			switch (pKomandoa){
				case "CommandErosketaEgin":
					Erosketa e=ErosketaFactory.getErosketaFactory().createErosketa(pInfo[0]);
					new CommandErosketaEgin(pJokalaria,e);
					break;
				case "CommandObjektuaErabili":
					Objektuak ob=ObjektuakFactory.getObjektuakFactory().createObjektua(pInfo[0]);
					new CommandObjektuaErabili(pJokalaria,ob,Integer.parseInt(pInfo[1]),
							Integer.parseInt(pInfo[2]),pInfo[3].charAt(0));
					System.out.print(pInfo[3].charAt(0));
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
		}else System.out.println(norenTxandaDaIzena()+"-ren txanda da");
	}
	public void komandoaAtzera() {
		Battlelog.BattlelogaLortu().komandoaAtzera();
	}
	public void komandoaAtzera(String[] pInfo) {
		Battlelog.BattlelogaLortu().komandoaAtzera(pInfo);
	}
	public void jokalariakObjektuaErabili(String pNori, String[] pInfo) {
		norenTxandaDa().objektuaErabili(pNori,pInfo);
		
	}
	public String[] jokalarienIzenakEman() {
		String[] izenak = new String[jokalariLista.size()];
		int ind=0;
		for(Jokalariak jok : jokalariLista){
			System.out.println(jok.getIzena());
			if(jok.jokalariaBizirikDago()){
				izenak[ind]=jok.getIzena();
				ind++;
			}
		}
		return izenak;
	}
	
}
