package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

import negozioLogika.commands.CommandTxandaPasa;

public class CPU extends Jokalariak {
	
	private final int diruAsko,zaiakeraMaximoak;	
	private final int[] objMinimoak;

	boolean batAurkituta=false;
	
	public CPU(String pIzena) {
		super(pIzena);
		diruAsko=0;	//makinak, fase batea erabili ahal dituen objetuak<hau erosiko du
		int[] minimoak=new int[3];
		minimoak[0]=0;	//makinak, fase batea erabili ahal dituen objetuak<hau erosiko du
		minimoak[1]=1;	//ekipo hauek baino gutxiago baditu
		minimoak[2]=15;	//arma hauek baino gutxiago baditu
		objMinimoak=minimoak;
		zaiakeraMaximoak=5;
		
	}
	
@Override	
	protected void jokatuCPU(int pFasea) {
		boolean denaOndo=false;
		if(pFasea==0){
			if(inb.itsasontziGuztiakIpinita()){
				denaOndo=erosi();
			}else{
				for(Itsasontzia its: (inb.itsasontziakLortu()))
					if(its.getKopurua()>0) itsasontziakIpini();
				denaOndo=true;
				Partida.getPartida().faseaAldatu(true);
			}
		}else if (pFasea==1){
			denaOndo=ekipoa();
		}else if(pFasea==2){
			denaOndo=erasotu(faseanErabiliAhalDenObjektua(pFasea)); //radarra ere eraso bat baita
		}
		if(!denaOndo) Partida.getPartida().komandoTxandaPasa(izena);
	}
	private boolean erosi() {	//ez badu lortzen return false
		int pFase=2,kop=0;		//fase=2 -an hasten da, armei prioritatea emateko
		Erosketa erosketa=null;
		while(pFase>0&&erosketa==null){
			for(Objektuak obj:inb.getObjektuak()){
				if(obj.getFasea()==pFase&&obj.kopuruNahikoa(1))
					kop+=obj.getKopurua();
			}
			if(kop<=objMinimoak[pFase]||dirua>=diruAsko){
				erosketa=denda.erosketaBatLortu(pFase, dirua);
				if(erosketa!=null)erosketa.erosketaExekutatu(izena);
			}
			pFase--;
		}
		return (erosketa!=null);
		
	}
	private boolean ekipoa(){	//ez badu lortzen return false
		boolean denaOndo=false;
		int zaiakerak=0;
		while(!denaOndo&&zaiakerak<zaiakeraMaximoak){
			String obj=faseanErabiliAhalDenObjektua(1);
			if(obj==null){
				denaOndo=true;
			}else if(obj.equals("Radarra")&&!batAurkituta){
				denaOndo=erasotu(obj);
			}else if(obj.equals("Ezkutua")){
				denaOndo=itsasontzietanObjektuaErabili(obj);
			}else if(obj.equals("Konponketa")){
				denaOndo=itsasontzietanObjektuaErabili(obj);
			}
			if(!denaOndo)zaiakerak++;
		}
		
		return (zaiakerak<zaiakeraMaximoak);
	}
	public boolean erasotu(String pObj){	//ez badu lortzen return false
		//String pNori, int pX, int pY,char pNorabide
		int x=0,y=0;
		String[][] etsaiMapa= Partida.getPartida().mapaInterpretatu(aurkaria);
		char[][] etsaiMapa2= new char[mapa.getErrenkada()][mapa.getZutabe()];
		batAurkituta=false;
		String kasilla;
		x=1;
		for( x=0;x<mapa.getErrenkada();x++){
			for( y=0;y<mapa.getZutabe();y++)
				etsaiMapa2[x][y]='_';
		}
		x=1;
		while(x<mapa.getErrenkada()-1){
			y=1;
			while(y<mapa.getZutabe()-1){
				kasilla=etsaiMapa[x][y];
				if(kasilla.equals("Ura")){
					etsaiMapa2[x][y]='~';
				}else if(kasilla.equals("Suntzituta")){
					etsaiMapa2[x][y]='~';
					etsaiMapa2[x-1][y]='~';
					etsaiMapa2[x+1][y]='~';
					etsaiMapa2[x][y-1]='~';
					etsaiMapa2[x][y+1]='~';
				}else if(kasilla.equals("Itsasontzi")||kasilla.equals("Ezkutua")){
					etsaiMapa2[x][y]='X';
					batAurkituta=true;
				}else if(kasilla.equals("Ukituta")){
					etsaiMapa2[x][y]='~';
					if(etsaiMapa[x-1][y].equals("Ezezaguna"))etsaiMapa2[x-1][y]='X';
					if(etsaiMapa[x+1][y].equals("Ezezaguna"))etsaiMapa2[x+1][y]='X';
					if(etsaiMapa[x][y+1].equals("Ezezaguna"))etsaiMapa2[x][y+1]='X';
					if(etsaiMapa[x][y-1].equals("Ezezaguna"))etsaiMapa2[x][y-1]='X';
					batAurkituta=true;
				}
				y++;
			}
			x++;
		}
		int pos=Partida.getPartida().nextInt((mapa.getErrenkada()-1)*(mapa.getZutabe()-1));
		while(pos>0){
			x=1;
			while(x<mapa.getErrenkada()-1&&pos>0){
				y=1;
				while(y<mapa.getZutabe()&&pos>0){
					if(batAurkituta&&etsaiMapa2[x][y]=='X')
						pos--;
					else if(!batAurkituta&&etsaiMapa2[x][y]=='_')
						pos--;
					if(pos>0)y++;
				}
				if(pos>0)x++;
			}
		}
		if(pObj!=null){
			String nora="NSWE";
			String[] info= new String[4];
			info[0]=pObj;
			info[1]=""+x;
			info[2]=""+y;
			info[3]=""+nora.charAt(Partida.getPartida().nextInt(4));
			inb.objektuaErabili(aurkaria, info);
			return true;
		}else	return false;
	}
	
	private boolean itsasontzietanObjektuaErabili(String pObj) {	//ez badu lortzen return false
		Itsasontzia ontzi=null;
		java.util.Iterator<Itsasontzia>its=mapa.getItsasontziak().iterator();
		boolean denaOndo =false;
		while(!denaOndo&&its.hasNext()){
			ontzi=its.next();
			if(pObj.equals("Ezkutua")){
				if(!ontzi.getSuntzituta()&&!ontzi.ezkutuOsoaDu()){
					denaOndo=true;}
			}
			else if(pObj.equals("Konponketa")){
				if(!ontzi.getBizitzaOsoarekin()){
					denaOndo=true;}
			}
		}
		if(denaOndo){String[] info= new String[4];
			info[0]=pObj;
			info[1]=""+ontzi.getKoordenatuak()[0];
			info[2]=""+ontzi.getKoordenatuak()[1];
			info[3]="N";
			inb.objektuaErabili(izena, info);;
		}
		return denaOndo;
	}
	private String faseanErabiliAhalDenObjektua(int pFase) {//pFase= zein fasetan erabiltzen den
		ArrayList<String>izenaLista=new ArrayList<String>();
		
		for(Objektuak obj:inb.getObjektuak()){
			if(obj.getFasea()==pFase&&obj.kopuruNahikoa(1))
				for(int i=0;i<obj.getKopurua();i++)izenaLista.add(obj.getIzena());
		}
		String emaitza=null;
		if(izenaLista.size()>0)
			emaitza=izenaLista.get(Partida.getPartida().nextInt(izenaLista.size()));
		return emaitza;
	}
	public boolean cpuNaiz() {
		return true;
	}
}
