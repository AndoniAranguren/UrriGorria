package negozioLogika;

import java.util.ArrayList;

public class Denda {
<<<<<<< HEAD
	private ArrayList<Objektuak> listaStock;
	private ArrayList<Erosketa> listaErosketak;
	public Denda(){
		erosketakHasieratu();
		stockaErreseteatu();
	}
	private void erosketakHasieratu(){
		listaErosketak.clear();
		ErosketaFactory eros=ErosketaFactory.getErosketaFactory();
		listaErosketak.add(eros.createErosketa("Bomba"));
		listaErosketak.add(eros.createErosketa("Misila"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua"));
		listaErosketak.add(eros.createErosketa("Misil Zuzendua Pro"));
		listaErosketak.add(eros.createErosketa("Radarra"));
		listaErosketak.add(eros.createErosketa("Fragata"));
		listaErosketak.add(eros.createErosketa("Itsaspeko"));
		listaErosketak.add(eros.createErosketa("Suntsitzailea"));
		listaErosketak.add(eros.createErosketa("HegazkinOntzia"));
		listaErosketak.add(eros.createErosketa("Itsasontzi Guztiak"));
		listaErosketak.add(eros.createErosketa("x5Bomba"));
	}
	private void stockaErreseteatu(){
		listaStock.clear();
		gehituXAldiz("Bomba", 50);
		gehituXAldiz("Misila", 20);
		gehituXAldiz("Misil zuzendua", 5);
		gehituXAldiz("Misil Zuzendua Pro", 2);
		gehituXAldiz("Radarra",5);
		gehituXAldiz("Fragata", 4);
		gehituXAldiz("Itsaspeko", 3);
		gehituXAldiz("Suntsitzailea", 2);
		gehituXAldiz("HegazkinOntzia", 1);
	}
	public void dendaEguneratu(){
		
	}
	public ArrayList<Objektuak> dendakIzakinakDitu(Erosketa pErosketa) {
		ArrayList<Objektuak> ob = pErosketa.getObjektuak(), aux=listaStock;
		Objektuak azkenengoObj=ob.get(ob.size());
		boolean dauzka=true;
		while(dauzka && ob.size()!=0){
			azkenengoObj=ob.get(ob.size());
			if(aux.contains(azkenengoObj)){
				aux.remove(azkenengoObj);
				ob.remove(ob.size()-1);
			}else dauzka=false;
		}
		if(dauzka){
			listaStock=aux;
			ob=pErosketa.getObjektuak();
		}else ob=null;
		return ob;
	}
	public void objektuakEman(ArrayList<Objektuak> pObjektuak, boolean pZer) {
		if(pZer){ listaStock.addAll(pObjektuak);
		}else listaStock.removeAll(pObjektuak);
		
	}
	private void gehituXAldiz(String pIzen,int pZ){
		Objektuak e=ObjektuakFactory.getObjektuakFactory().createObjektua(pIzen);
		for(int i=0;i<pZ;i++){listaStock.add(e);}
=======
	private ArrayList<Objektuak> lista;
	private static Denda nDenda=null;
	private Denda(){}
	public static synchronized Denda getDenda(){
		if(nDenda==null){ nDenda= new Denda();}
		return nDenda;
	}
	public void dendaEguneratu(){
		
>>>>>>> branch 'master' of https://github.com/Kaskagues/UrriGorria
	}
}
