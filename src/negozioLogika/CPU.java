package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jokalariak {
	private String etsaia;
	private ArrayList<Integer> erasotutakoPos=new ArrayList<Integer>();
	
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
		Random r=new Random();
		String karak="NSEW";
		int pos;
		int obj;
		String[] info=new String[4];
		boolean ondo=false,ekipoaErabilia=false;
		while(!ondo){
			pos=(int)Math.random()*100;
			info[1]=String.valueOf(pos/100);
			info[2]=String.valueOf(pos%100);
			obj=(int)Math.random()*inb.lenght();
			info[0]=String.valueOf(obj);
			info[3]=String.valueOf(karak.charAt(r.nextInt(karak.length())));
			if(inb.armaDa(obj)){
				while(erasotutakoPos.contains(pos)) pos=(int)Math.random()*100;
				//desde donde habria que llamar al ataque?
				Partida.jokalariariErasotu(izena, etsaia, inb.get(obj), pos/100, pos%100, karak.charAt(r.nextInt(karak.length())), true);
				//creo que desde Inbentarioa no se contempla la posibilidad de que el objeto sea un arma
				//con el comando objektuaErabili
				erasotutakoPos.add(pos);
				ondo=true;
			}
			else if(!ekipoaErabilia){
				inb.objektuaErabili(etsaia, info);
				ekipoaErabilia=true;
			}
		}
		
	}
	public void jokalariariErasotu(String pNork, Objektuak pObjektua, int pX, int pY,char pNorabide, boolean pZer) {
		etsaia=pNork;
		mapa=pObjektua.aktibatu(etsaia,mapa, pX, pY, pNorabide, pZer);
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
//		Partida.getPartida().faseaAldatu(true);
	}

}
