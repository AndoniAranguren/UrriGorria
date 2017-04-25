package negozioLogika;

public class Armak extends Objektuak {
	
	protected StrategyArmak portaera;
	protected int indarra;
	
	public Armak(String pIzena){
		super(pIzena);
	}

	public Mapa erasoEgin(String pNork, Mapa pMapa, int pX, int pY, char pNorabide, boolean pZer) {
		// TODO Auto-generated method stub
		return portaera.erasoEgin(pNork,pMapa, pX, pY,pNorabide, indarra, pZer);
	}
}
