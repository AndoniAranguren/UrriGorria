package negozioLogika.commands;

import negozioLogika.Partida;
import negozioLogika.ObjektuakFactory;
import negozioLogika.Armak;

public class CommandErasoEgin extends Commands {
	
	private String nori;
	private Armak[] arma= new Armak[0];
	private int koordX, koordY;
	private char norabidea;
	
	public CommandErasoEgin(String pJ, String pArma, int pX, int pY, char pNorabide){
		//Datuak gorde----------
		super();
		nori=pJ;
		arma[0]= (Armak) ObjektuakFactory.getObjektuakFactory().createObjektua(pArma);
		koordX=pX;
		koordY=pY;
		//----------------------
	}
	public void exekutatu(){
		if(konprobatu()){

			Partida.jokalariariObjektuakEman(jokalaria, arma, false);
			Partida.jokalariariErasoEgin(jokalaria,nori,arma[0],koordX,koordY,norabidea,true);
		}
	}
	
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, arma, true);
		Partida.jokalariariErasoEgin(jokalaria,nori,arma[0],koordX,koordY,norabidea,false);
	}
	private boolean konprobatu(){
		return Partida.jokalariakObjektuakDitu(jokalaria, arma);
	}
}
