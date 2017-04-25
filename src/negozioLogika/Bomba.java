package negozioLogika;

public class Bomba extends Armak{

	public Bomba(String pIzena) {
		super(pIzena);
		super.indarra=100;
		super.portaera=new ErasoSinple();
	}

}
