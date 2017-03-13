package negozioLogika;

public class Itsaspekoa extends Itsasontzia {

	public Itsaspekoa() {
		super(3, 500);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void informazioaInprimatu() {
		// TODO Auto-generated method stub
		System.out.println("       Luzera: "+super.getLuzera());
		System.out.println("       Prezioa: "+super.getPrezioa());

	}


}
