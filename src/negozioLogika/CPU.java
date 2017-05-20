package negozioLogika;

public class CPU extends Jokalariak {
	
	public CPU(String pIzena) {
		super(pIzena);
	}
	
	public void erasotu(){
		//String pNori, int pX, int pY,char pNorabide
		if(true/*r.nextInt(10)>8*/){
			int x=0,y=0;
			String[][] etsaiMapa= Partida.getPartida().mapaInterpretatu(aurkaria);
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
			
			String nora="NSWE";
			String[] info= new String[4];
			info[0]=inb.armaBatEman().getIzena();
			info[1]=""+x;
			info[2]=""+y;
			info[3]=""+nora.charAt(Partida.getPartida().nextInt(4));
			inb.objektuaErabili(aurkaria, info);
		}
	}
	
@Override	
	protected void jokatuCPU(int pFasea) {
		if(Partida.getPartida().getCpuAktibatu()){
			if(pFasea==0){
				if(inb.itsasontziGuztiakIpinita()){
					Partida.getPartida().komandoaEgikaritu(izena, "CommandTxandaPasa", new String[3]);
				}else{
					for(Itsasontzia its: (inb.itsasontziakLortu()))
						if(its.getKopurua()>0) itsasontziakIpini();
					Partida.getPartida().faseaAldatu(true);
				}
				
			}
			else if (pFasea==1){
				Partida.getPartida().komandoaEgikaritu(izena, "CommandTxandaPasa", new String[3]);
			}else{
				erasotu();
			}
		}
	}
	public boolean cpuNaiz() {
		return true;
	}
}
