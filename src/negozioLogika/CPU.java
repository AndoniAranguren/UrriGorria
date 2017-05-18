package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jokalariak {
	private String etsaia;
	
	public CPU(String pIzena, String jok) {
		super(pIzena);
		etsaia=jok;
	}
	
	@Override
	public void itsasontziakIpini() {
		ArrayList<Itsasontzia> itsasontziak=inb.itsasontziakLortu();
		int rY=0,x=0,y=0,zaiakerak=0,ontziKop=0;
		final int zaiakeraMax=mapa.getErrenkada();
		char n='N';
		Random r = new Random();
		String nora="NSWENSWE";
		boolean bilatzen=false;
		while(itsasontziak.size()>0){
			x=0;
			if(!bilatzen){
				bilatzen=true;
				x = r.nextInt(mapa.getZutabe()-2);
				rY = r.nextInt(mapa.getErrenkada()-2);
				zaiakerak=0;
			}
			else while(x<mapa.getErrenkada()-1&&bilatzen&&zaiakerak<zaiakeraMax){
				zaiakerak++;
				y=rY;
				
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
			}if(zaiakerak>=zaiakeraMax){
				for(int i=0;i<ontziKop;i++){
					Partida.getPartida().komandoaAtzera();}
				System.out.println("Berriro hasi");
				itsasontziak=inb.itsasontziakLortu();
				bilatzen=false;
			}
		}
		System.out.println("CPU-ak bere itsasontziak kokatu ditu.");
	}
	
	public void erasotu(){
		//String pNori, int pX, int pY,char pNorabide
		Random r=new Random();
		if(true/*r.nextInt(10)>8*/){
			String[][] etsaiMapa= Partida.getPartida().mapaInterpretatu(etsaia);
			boolean[][] etsaiMapa2= new boolean[mapa.getErrenkada()][mapa.getZutabe()];
			String kasilla;
			for(int x=0;x<mapa.getErrenkada();x++){
				for(int y=0;y<mapa.getZutabe();y++){
					kasilla=etsaiMapa[x][y];
					if(kasilla.equals("Itsasontzia")||kasilla.equals("Ezkutu")||kasilla.equals("Suntzituta")){
						etsaiMapa2[x-1][y]=true;
						etsaiMapa2[x+1][y]=true;
						etsaiMapa2[x][y-1]=true;
						etsaiMapa2[x][y-1]=true;
					}
				}
			}
			int pos=r.nextInt(mapa.getErrenkada()*mapa.getZutabe());
//			while(erasotu){
//				for(int x=0;x<mapa.getErrenkada();x++){
//					for(int y=0;y<mapa.getZutabe();y++){
//						pos--;
//						if(pos<=0){
//							int inbPos=r.nextInt(inb.lenght());
//							while(!inb.armaDa(inbPos)){
//								inbPos++;
//							}
//							String nora="NSWE";
//							inb.get(inbPos).erabili(etsaia, x, y, nora.charAt(r.nextInt(4)));
//						}
//					}
//				}
//			}
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
//			erasotu();
		}
//		Partida.getPartida().faseaAldatu(true);
	}

}
