package negozioLogika.strategyak;

import negozioLogika.Mapa;

public class ErabiliRadarra implements StrategyEkipoak{//pX eta pY RND() rekin etorri behar dira
	
	public void erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer) {
		int[] koord =pMapa.erabiliRadarra(pNork, pX,pY,4,pZer);
		
		if(koord[0]!=-1){
			ErasoSinple er=new ErasoSinple();
			er.eraso(pNork, pMapa, koord[0], koord[1], 'N', 0, pZer);
		}
	}
	
}
