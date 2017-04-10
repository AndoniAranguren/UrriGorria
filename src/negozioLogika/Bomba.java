package negozioLogika;

public class Bomba extends Armak{

	protected StrategyArmak portaera;
	private int indarra;
	public Bomba(String pIzena) {
		super(pIzena);
		indarra=100;
		portaera=new ErasoSinple(indarra);
	}

}
