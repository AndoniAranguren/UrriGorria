package negozioLogika;

public class Bomba extends Armak{


	public Bomba(String pIzena) {
		super(pIzena);
		indarra=100;
		portaera=new ErasoSinple(indarra);
	}

}
