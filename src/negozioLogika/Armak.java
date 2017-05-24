package negozioLogika;

import negozioLogika.strategyak.StrategyArmak;

public class Armak extends Objektuak {
	
	protected StrategyArmak portaera;
	protected int indarra;
	
	public Armak(String pIzena, int pKop, int pIndarra, StrategyArmak pPortaera){
		super(pIzena,pKop,2);
		indarra=pIndarra;
		portaera=pPortaera;
	}

	public void aktibatu(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		portaera.eraso(pNork,pMapa, pX, pY,pNorabide, indarra, pZer);
	}
	public boolean isArma(){
		return true;
	}
}
