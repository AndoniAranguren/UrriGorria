package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jokalariak {
	private int zailtasuna;
	private String etsaia;
	private ArrayList<Integer> erasotutakoPos=new ArrayList<Integer>();
	
	public CPU(String pIzena, int pZailtasuna) {
		super(pIzena);
		zailtasuna=pZailtasuna;
	}
	
	@Override
	public void itsasontziakIpini() {
		this.jokalariariObjektuakEman(null, bizirik);
		ArrayList<Objektuak> objektuak= new ArrayList<Objektuak>();
		ObjektuakFactory ob=ObjektuakFactory.getObjektuakFactory();
		objektuak.add(ob.createObjektua("Fragata", 4));
		objektuak.add(ob.createObjektua("Itsaspekoa", 3));
		objektuak.add(ob.createObjektua("Suntsitzailea", 2));
		objektuak.add(ob.createObjektua("HegazkinOntzia", 1));
		int x;
		int y;
		char n;
		Random r = new Random();
		String nora="NSWE";
		while(objektuak.size()>0){
			x = (int) Math.random()*10;
			y = (int) Math.random()*10;
			n=nora.charAt(r.nextInt(nora.length()));
			if(kokatuDaiteke(x, y, n, objektuak.get(0).getLuzeera())){
				if(objektuak.get(0).itsasontziaDa()){
					itsasontziaJarri((Itsasontzia)objektuak.get(0), x, y, n, true);
					objektuak.remove(0);
				}
			}
		}
		System.out.println("CPU-ak bere itsasontziak kokatu ditu.");
		objektuak.add(ob.createObjektua("Bomba", 50));
		objektuak.add(ob.createObjektua("Misil", 20));
		objektuak.add(ob.createObjektua("Misil Zuzendua", 5));
		objektuak.add(ob.createObjektua("Misil Zuzendua Pro", 2));
		objektuak.add(ob.createObjektua("Radarra",5));
		System.out.println("CPU-ak bere inbentarioa betetu du.");
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
		Partida.getPartida().faseaAldatu(true);
	}

}
