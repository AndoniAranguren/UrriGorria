package negozioLogika;

import java.util.Random;

public class CPU extends Jokalariak {
	private String etsaia;
	
	public CPU(String pIzena, String jok) {
		super(pIzena);
		etsaia=jok;
	}
	
	public void erasotu(){
		//String pNori, int pX, int pY,char pNorabide
		if(!Partida.jokalariaBizirikDago(etsaia)) etsaia=Partida.getPartida().jokalariBiziBatLortu();
		Random r=new Random();
		if(true/*r.nextInt(10)>8*/){
			int x=0,y=0;
			String[][] etsaiMapa= Partida.getPartida().mapaInterpretatu(etsaia);
			char[][] etsaiMapa2= new char[mapa.getErrenkada()][mapa.getZutabe()];
			boolean batAurkituta=false;
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
			for( x=0;x<mapa.getErrenkada();x++){
				for( y=0;y<mapa.getZutabe();y++)
					System.out.print(etsaiMapa2[x][y]);
				System.out.println();
			}
			int pos=r.nextInt((mapa.getErrenkada()-1)*(mapa.getZutabe()-1));

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
			System.out.println(x+" "+y);
			for(int px=0;px<mapa.getErrenkada();px++){
				for(int py=0;py<mapa.getZutabe();py++)
					System.out.print(x==px&&y==py? "O":etsaiMapa2[px][py]);
				System.out.println();
			}
			
			String nora="NSWE";
			String[] info= new String[4];
			info[0]=inb.armaBatEman().getIzena();
			info[1]=""+x;
			info[2]=""+y;
			info[3]=""+nora.charAt(r.nextInt(4));
			inb.objektuaErabili(etsaia, info);
		}
	}
	@Override
	public void jokatuCPU(int pFasea) {
		if(pFasea==0){
			for(Itsasontzia its: (inb.itsasontziakLortu())){
				if(its.getKopurua()>0) itsasontziakIpini();
			}
		}
		else if (pFasea==1){
			
		}else{
			erasotu();
		}
		Partida.getPartida().faseaAldatu(true);
	}

}
