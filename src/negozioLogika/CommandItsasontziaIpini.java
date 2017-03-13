package negozioLogika;

public class CommandItsasontziaIpini implements Commands {
	Jokalaria jokalari;
	Mapa mapa;
	Itsasontzia ontzia;
	int koordX, koordY;
	char norabidea;
	
	public void exekutatu(Jokalaria pJ, Itsasontzia pOntzi, int pX, int pY, char pNorabidea){
		jokalari=pJ;
		mapa=jokalari.getMapa();
		ontzia=pOntzi;
		koordX=pX;
		koordY=pY;
		norabidea=pNorabidea;
		if(konprobatu()){
			Kontsola.komandoaLortu("CommandObjetuaKendu").exekutatu(jokalari,ontzia);	
		}
	}
	private boolean konprobatu(){
		int xKont,yKont,luzeeraKont;
		xKont=koordX;
		yKont=koordY;
		luzeeraKont=ontzia.luzeeraEman();
		boolean egokia,konprobazioakFalta=true;
		
		while (konprobazioakFalta){
			egokia=mapa.posizioEgokia(koordX,koordY);
			luzeeraKont--;
			
			if(egokia){
				konprobazioakFalta= (0!=luzeeraKont);
				this.mugituNorabidera(xKont,yKont,pNorabidea);
			}else konprobazioakFalta=egokia;
		}
		return egokia;
	}
	
	public void jarri(){
		int xKont,yKont,luzeeraKont;
		xKont=koordX;
		yKont=koordY;
		luzeeraKont=ontzia.luzeeraEman();
		boolean egokia,konprobazioakFalta=true;
		
		while (konprobazioakFalta){
			egokia=mapa.posizioEgokia(koordX,koordY);
			luzeeraKont--;
			
			if(egokia){
				konprobazioakFalta= (0!=luzeeraKont);
				this.mugituNorabidera(xKont,yKont,pNorabidea);
			}else konprobazioakFalta=egokia;
		}
	}
	
	private void mugituNorabidera(int pX, int pY, char pNorabidea){
		switch (pNorabidea){
		case 'N': pY++; break;
		case 'E': pX++; break;
		case 'S': pY--; break;
		case 'W': pX--; break;
		default: break;
		}
	}

}
