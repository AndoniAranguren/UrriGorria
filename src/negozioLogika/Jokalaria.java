package negozioLogika;

import frontend.OntziakAukeratu1;

public class Jokalaria extends Jokalariak {
	public Jokalaria(String pIzena) {
		super(pIzena);
	}
	public void itsasontziakIpini(){
		UrriGorria.getUrriGorria().getUi().panelaAldatu(new OntziakAukeratu1(izena));
	}
}
