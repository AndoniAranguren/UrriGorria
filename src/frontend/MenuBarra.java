package frontend;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import negozioLogika.Partida;

public class MenuBarra extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu hizkuntza,jokalariMenu;
	private JMenuItem[] hizkBat;
	private String[] hizkuntzak;
	
	public MenuBarra() {
		hizkuntzak= new String[3];
		hizkuntzak[0]="Euskera";hizkuntzak[1]="Gaztelera";hizkuntzak[2]="Ingelesa";
		hizkBat= new JMenuItem[hizkuntzak.length];
		erreseteatu("Euskera",false);
	}
	public void erreseteatu(String pHizkunta,boolean pJokalariakJarri){
		this.removeAll();
		this.hizkuntzaEraiki(pHizkunta);
		if(pJokalariakJarri)this.jokalariaJarri();
		this.revalidate();
	}
	private void hizkuntzaEraiki(String pHizkunta) {
		hizkuntza = new JMenu("Hizkuntza");
		int i=0;
		for(String hiz:hizkuntzak){
			hizkBat[i] = new JMenuItem(hiz);
			hizkBat[i].addActionListener(gureAE -> this.hizkuntzaAldatu(hiz));
			if(pHizkunta.equals(hiz.toLowerCase()))
				hizkBat[i].setBackground(new Color(175, 255, 175));
			hizkuntza.add(hizkBat[i]);
			i++;
		}
		this.add(hizkuntza);
	}
	
	private void jokalariaJarri() {		
		jokalariMenu= new JMenu("Jokalariak");
		
        String aurkaria=UrriGorriaUI.getUrriGorriaUI().getAurkaria();
        String[] jokalariak=Partida.getPartida().jokalarienIzenakEman();
        JMenuItem[] eMenuItem = new JMenuItem[jokalariak.length];
        String pNorenTxanda=UrriGorriaUI.getUrriGorriaUI().norenTxandaDaIzena();
        
        int ind=0;
        for(String izena:jokalariak){
        	if(!izena.equals(pNorenTxanda)){
            	eMenuItem[ind] = new JMenuItem(izena);
                eMenuItem[ind].setName(izena);
                eMenuItem[ind].addActionListener(e->this.aurkariaAldatu(((JMenuItem)e.getSource()).getName()));
                if(aurkaria!=null)
                	if(eMenuItem[ind].getName().equals(aurkaria))
                		eMenuItem[ind].setBackground(new Color(175, 255, 175));
                jokalariMenu.add(eMenuItem[ind]);
        	}
        }

        if(aurkaria==null||aurkaria.equals(pNorenTxanda))	
        	this.aurkariaAldatu(eMenuItem[ind].getName());
        
        this.add(jokalariMenu);
		
	}

	private void aurkariaAldatu(String pIzen) {
		UrriGorriaUI.getUrriGorriaUI().setAurkaria(pIzen);
	}
	private void hizkuntzaAldatu(String pHiz) {
		UrriGorriaUI.getUrriGorriaUI().setHizkuntza(pHiz.toLowerCase());
		
	}

}
