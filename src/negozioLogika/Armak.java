package negozioLogika;

import strategyak.StrategyArmak;

public class Armak extends Objektuak {
	
	protected StrategyArmak portaera;
	protected int indarra;
	
	public Armak(String pIzena, int pKop, int pIndarra, StrategyArmak pPortaera){
		super(pIzena,pKop);
		indarra=pIndarra;
		portaera=pPortaera;
	}

	public Mapa aktibatu(String pNori, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		return portaera.eraso(pNori,pMapa, pX, pY,pNorabide, indarra, pZer);
	}
	
}
