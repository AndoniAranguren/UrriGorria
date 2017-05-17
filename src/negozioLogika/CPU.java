package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jokalariak {
	private int zailtasuna;
	private String etsaia;
	private ArrayList<Integer> erasotutakoPos=new ArrayList<Integer>();
	private boolean itsasontziakIpinita;
	
	public CPU(String pIzena, int pZailtasuna) {
		super(pIzena);
		zailtasuna=pZailtasuna;
		itsasontziakIpinita=false;
	}
	
	@Override
	public void itsasontziakIpini() {
//		this.jokalariariObjektuakEman(null, bizirik);
//		ArrayList<Objektuak> objektuak= new ArrayList<Objektuak>();
//		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
//		objektuak.add(ob.createObjektua("Fragata", 4));
//		objektuak.add(ob.createObjektua("Itsaspekoa", 3));
//		objektuak.add(ob.createObjektua("Suntsitzailea", 2));
//		objektuak.add(ob.createObjektua("HegazkinOntzia", 1));
		ArrayList<Itsasontzia> itsasontziak=inb.itsasontziakLortu();
		int rX=0,rY=0,x=0,y=0;
		Itsasontzia its=itsasontziak.get(0);
		char n='N';
		Random r = new Random();
		String nora="NSWENSWE";
		boolean bilatzen=false;
		while(itsasontziak.size()>0){
			if(!bilatzen){
				bilatzen=true;
				its=itsasontziak.get(0);
				rX = r.nextInt(mapa.getZutabe()-2);
				rY = r.nextInt(mapa.getErrenkada()-2);
				x=rX;
			}
			else while(x<mapa.getErrenkada()-1&&bilatzen){
				y=rY;
				System.out.println();
				while(y<mapa.getZutabe()-1&&bilatzen){
					int ind=0, rNum=r.nextInt(4);
					while(ind<4&&bilatzen){
						n=nora.charAt(rNum+ind);
						if(mapa.kokatuDaiteke(x, y,	n,its.getLuzeera())){
							itsasontziak.get(0).erabili(izena, x, y, n);
							if(itsasontziak.get(0).getKopurua()<=0)
								itsasontziak.remove(0);
							bilatzen=false;
						}
						ind++;
					}
					y++;
				}
				x++;
			}
		}
		itsasontziakIpinita=true;
		System.out.println("CPU-ak bere itsasontziak kokatu ditu.");
//		objektuak.add(ob.createObjektua("Bomba", 50));
//		objektuak.add(ob.createObjektua("Misil", 20));
//		objektuak.add(ob.createObjektua("Misil Zuzendua", 5));
//		objektuak.add(ob.createObjektua("Misil Zuzendua Pro", 2));
//		objektuak.add(ob.createObjektua("Radarra",5));
//		System.out.println("CPU-ak bere inbentarioa betetu du.");
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
			if(!itsasontziakIpinita)itsasontziakIpini();
		}
		else if (pFasea==1){
			
		}else{
			erasotu();
		}
//		Partida.getPartida().faseaAldatu(true);
	}

}
