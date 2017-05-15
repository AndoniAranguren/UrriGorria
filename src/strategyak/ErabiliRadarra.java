package strategyak;

import negozioLogika.Mapa;

public class ErabiliRadarra implements StrategyEkipoak{//pX eta pY RND() rekin etorri behar dira
	public Mapa erabili(String pNork, Mapa pMapa,int pX, int pY, boolean pZer) {
		int[] koord =pMapa.radarraErabili(pNork, pX,pY,3,pZer);
		ErasoSinple er=new ErasoSinple();
		return er.eraso(pNork, pMapa, koord[0], koord[1], 'N', 0, pZer);
	}
}
