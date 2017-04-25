package negozioLogika;

public class Armak extends Objektuak {
	
	protected StrategyArmak portaera;
	protected int indarra;
	
	public Armak(String pIzena, int pIndarra, StrategyArmak pPortaera){
		super(pIzena);
		indarra=pIndarra;
		portaera=pPortaera;
	}

	public Mapa eraso(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		// TODO Auto-generated method stub
		return portaera.eraso(pNork,pMapa, pX, pY,pNorabide, indarra, pZer);
	}
}
