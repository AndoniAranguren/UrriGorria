package negozioLogika.commands;

import negozioLogika.Partida;

public class CommandTxandaPasa extends Commands {

	public CommandTxandaPasa(){
		//Datuak gorde----------
		super();
		//----------------------
		System.out.println("Txanda pasn");
		super.exekutatu();
	}
	
	@Override
	protected boolean konprobatu() {
		return true;
	}

	@Override
	protected void egikaritu(boolean pZer) {

		System.out.println("Txanda pasatzen saiaasdadassatzen");
		Partida.getPartida().faseaAldatu(pZer);
		super.komandoaGorde(pZer);
	}
	public String info(){
		String info=super.info();
		String aux= "Beste";
		if(fasea==0) aux="Denda";
		else if (fasea==1) aux="Ekipo";
		else if (fasea==2)	aux="Eraso";
		return info.concat(aux+" fasea pasatu du");
	}
}
