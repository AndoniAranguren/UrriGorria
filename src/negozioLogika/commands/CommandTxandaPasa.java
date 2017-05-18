package negozioLogika.commands;

import negozioLogika.Partida;

public class CommandTxandaPasa extends Commands {

	public CommandTxandaPasa(){
		//Datuak gorde----------
		super();
		//----------------------
		super.exekutatu();
	}
	
	@Override
	protected boolean konprobatu() {
		return true;
	}

	@Override
	protected void egikaritu(boolean pZer) {
		super.komandoaGorde(pZer);
		Partida.getPartida().faseaAldatu(pZer);
	}
	public String info(){
		String info=super.info();
		String aux= "Beste";
		if(fasea==0) aux="'CommandDendaFasea'";
		else if (fasea==1) aux="'CommandEkipoFasea'";
		else if (fasea==2)	aux="'CommandErasoFasea'";
		return info.concat(aux);
	}
}
