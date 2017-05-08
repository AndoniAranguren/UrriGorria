package strategyak;

import negozioLogika.Mapa;

public class ErasoSinple implements StrategyArmak{
	public ErasoSinple(){
	}
	public Mapa eraso(String pNork,Mapa pMapa, int pX, int pY, char pNorabide, int pIndarra, boolean pZer){
		pMapa.erasoSinpleaJaso(pNork, pX, pY, pIndarra, pZer);
		return pMapa;
	}
}