package negozioLogika;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jokalariak {
	int zailtasuna;
	
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
		System.out.println("CPU-k bere itsasontziak kokatu ditu!");
//		for(int i=0; i<10; i++){
//			int luzeera=(int)Math.random()*3+1;
//			Itsasontzia pOntzi=new Itsasontzia)(izena, zailtasuna, zailtasuna, zailtasuna);
//			pOntzi = mapa.itsasontziaJarri(izena, pOntzi, pX, pY, pNorabidea,pZer);
//			nireItsasontziak.add(pOntzi);
//		}
	}

}
