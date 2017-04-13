package negozioLogika.commands;

import negozioLogika.Partida;
import negozioLogika.ObjektuakFactory;
import negozioLogika.Armak;

public class CommandErasoEgin extends Commands {
	
	private String nori;
	private String[] armaIzena;
	private Armak arma;
	private int koordX, koordY;
	private char norabidea;
	
	public CommandErasoEgin(String pJ, String pArma, int pX, int pY, char pNorabide){
		//Datuak gorde----------
		super();
		nori=pJ;
		armaIzena[0]=pArma;
		arma= (Armak) ObjektuakFactory.getObjektuakFactory().createObjektua(pArma);
		koordX=pX;
		koordY=pY;
		//----------------------
	}
	public void exekutatu(){
		if(konprobatu()){
			Partida.jokalariariObjektuakEman(jokalaria, armaIzena, false);
			Partida.jokalariariErasoEgin(jokalaria,nori,arma,koordX,koordY,norabidea,true);
		}
	}
	
	public void deuseztatu(){
		Partida.jokalariariObjektuakEman(jokalaria, armaIzena, true);
		Partida.jokalariariErasoEgin(jokalaria,nori,arma,koordX,koordY,norabidea,false);
	}
	private boolean konprobatu(){
		return Partida.jokalariakObjektuakDitu(jokalaria, armaIzena);
	}
}
