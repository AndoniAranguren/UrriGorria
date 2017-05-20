package interfazeGrafikoa;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfazeGrafikoa.properties.Hizkuntza;
import negozioLogika.Partida;

public class MenuBarra extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu hizkuntza,jokalariMenu;
	private JMenuItem[] hizkBat;
	private String[] hizkuntzak;
	private Hizkuntza h;
	
	public MenuBarra() {
		hizkuntzak= new String[3];
		hizkuntzak[0]="Euskera";hizkuntzak[1]="Castellano";hizkuntzak[2]="English";
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
		h = new Hizkuntza(pHizkunta);
		hizkuntza = new JMenu(h.getProperty("hizkuntza"));
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
		jokalariMenu= new JMenu(h.getProperty("jokalariak"));
		
        String aurkaria=UrriGorriaUI.getUrriGorriaUI().getAurkaria();
        String[] jokalariak=Partida.getPartida().jokalarienIzenakEman();
        JMenuItem[] eMenuItem = new JMenuItem[jokalariak.length];
        String pNorenTxanda=UrriGorriaUI.getUrriGorriaUI().norenTxandaDaIzena();
        
        int ind=0;        
		for(String izena:jokalariak)
			if(izena!=null)
				if(!izena.equals(pNorenTxanda)){
					java.awt.Color c=UrriGorriaUI.getUrriGorriaUI().getKolorea(izena);

		     		String zenb=izena.split("\\.")[0]+".";
		     		String izena2=h.getProperty(izena.split("\\.")[1]);
		     		eMenuItem[ind] = new JMenuItem(zenb+izena2);
		            eMenuItem[ind].setName(izena);
		            eMenuItem[ind].addActionListener(e->this.aurkariaAldatu(((JMenuItem)e.getSource()).getName()));
//		            if(aurkaria!=null)
//		            	if(eMenuItem[ind].getName().equals(aurkaria))
//		            		eMenuItem[ind].setEnabled(false);

		            eMenuItem[ind].setBackground(c);
		            eMenuItem[ind].setForeground(UrriGorriaUI.getUrriGorriaUI().getKolorKontraste(c));
		            jokalariMenu.add(eMenuItem[ind]);
		     	}
       

        if(aurkaria==null||aurkaria.equals(pNorenTxanda))	
        	if(eMenuItem[ind]!=null)this.aurkariaAldatu(eMenuItem[ind].getName());
        
        this.add(jokalariMenu);
		
	}

	private void aurkariaAldatu(String pIzen) {
		UrriGorriaUI.getUrriGorriaUI().setAurkaria(pIzen);
	}
	private void hizkuntzaAldatu(String pHiz) {
		UrriGorriaUI.getUrriGorriaUI().setHizkuntza(pHiz.toLowerCase());
		this.hizkuntza.setText(h.getProperty("hizkuntza"));
	}

}