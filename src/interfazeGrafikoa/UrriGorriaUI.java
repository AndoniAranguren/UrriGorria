package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.font.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfazeGrafikoa.properties.Hizkuntza;
import javafx.scene.text.Font;
import negozioLogika.Partida;
import negozioLogika.interfaces.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	private JPanel oraingoa;
	private static UrriGorriaUI ui;
	private String objektua="Ezer";
	private static int norabidea;
	private static String norenTxanda=null,txandaLehen;
	private int monitoreaW=(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	private int monitoreaH=(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	private static int leihoaW, leihoaH;
	private MenuBarra menubar;
	private String hizkuntza = "euskera";
	private boolean partidaZehaztuDa;
	
	private UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa=new JPanel();
		partidaZehaztuDa=false;
		menubar=new MenuBarra();
        this.setJMenuBar(menubar);
		panelaAktualizatu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void urriGorriaUIErreseteatu(){
		setVisible(false);
		dispose();
		ui=new UrriGorriaUI();
	}
	public static UrriGorriaUI getUrriGorriaUI() {
		return ui == null ? (ui = new UrriGorriaUI()) : ui;
	}
	
	
	private void panelaAldatu(JPanel jartzeko) {
		this.remove(oraingoa);
		oraingoa = jartzeko;
		this.add(oraingoa);
		this.revalidate();
		this.repaint();
	}
	public void objektuaAldatu(String pObj){
		objektua=pObj;
	}
	public String getObjektua(){
		return objektua;
	}
	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		Partida.getPartida().komandoaEgikaritu(pJokalaria, pKomandoa, pInfo);
		panelaAktualizatu();
	}

	public void partidaZehaztu(int[] pInfo) {
		partidaZehaztuDa=true;
		Partida.getPartida().partidaZehaztu(pInfo);
	}

	public ArrayList<String> logaEman(String pJokalaria) {
		return Partida.logaEman(pJokalaria);
	}
	public ArrayList<String> dendaEman(String pJokalaria) {
		return Partida.dendaEman(pJokalaria);
	}
	public ArrayList<String> inbentarioaEman(String pJokalaria) {
		return Partida.inbentarioaEman(pJokalaria);
	}

	public void panelaAktualizatu() {
		JPanel panela= new JPanel();
		Hizkuntza hizk=new Hizkuntza(hizkuntza);
		if(partidaZehaztuDa){
			int[] egoera=Partida.getPartida().egoeraLortu();
	        norenTxanda=Partida.getPartida().norenTxandaDaIzena();
	        String irabazlea=Partida.getPartida().getIrabazlea();
			//fasea=egoera[0];
			//txanda=egoera[1];
			//iraupena=egoera[2];
			setMenua(egoera[2]!=0);
	        if(irabazlea==null){//Jolasten jarraitu
	        	if(egoera[2]!=0){//Turno normalak
	    			leihoaW=monitoreaW*55/100;
	    			leihoaH=monitoreaH*90/100;
	    			panela=new PantailaUI(norenTxanda,getAurkaria(),egoera, hizkuntza);
	    		}
	    		else{//Barkuak jarri
	    			leihoaW=monitoreaW*50/100;
	    			leihoaH=monitoreaH*50/100;
	    			panela=new OntziakKokatuUI(norenTxanda, hizkuntza);
	    		}
	        }
	        else{//Irabazle bat dago AMAITU
	        	JPanel amaituta=new JPanel();
	        	amaituta.add(new javax.swing.JLabel(hizk.getIzena(irabazlea)+" "+hizk.getProperty("irabazi")));
	        	JButton berriro= new JButton(hizk.getProperty("Berriro"));
	        	berriro.setName("Berriro hasi");
	        	berriro.addActionListener(e->Partida.getPartida().partidaErreseteatu());
	        	amaituta.add(berriro);
	        	leihoaW=300;
	    		leihoaH=100;
	    		panela=amaituta;
	        }
			this.setMinimumSize(new Dimension(leihoaW,leihoaH));
			
		}
		else{//Jokalariak aukeratu behar dira
			panela=new PartidaZehaztuUI(hizkuntza);
			setMenua(false);
			leihoaW=320;
			leihoaH=220;
		}
		panelaAldatu(panela);
		setBounds((monitoreaW-leihoaW)/2, (monitoreaH-leihoaH)/2, leihoaW, leihoaH);
		System.out.println("PanelaAktualizatu");
		if(partidaZehaztuDa){
			
			int[] egoera=Partida.getPartida().egoeraLortu();
			if(!norenTxanda.equals(txandaLehen)){
				panela.setVisible(false);
				
				Object[] choices = {hizk.getProperty("aurrera")};
				Object defaultChoice = choices;
				JOptionPane.showOptionDialog(this,
						hizk.getIzena(norenTxanda),
						hizk.getProperty("iraupena")+" "+egoera[2],
			            JOptionPane.YES_NO_CANCEL_OPTION,
			            JOptionPane.YES_NO_CANCEL_OPTION,
			            null,
			            choices,
			            defaultChoice);
	    	    txandaLehen=norenTxanda;
				panela.setVisible(true);
				
			}else if(egoera[0]==0){
				String atera="";
				ArrayList<String> lista=Partida.getPartida().getTurnoanHilDirenak();
				for(String izena:lista){
					if(atera.length()>0) atera=", "+atera;
					atera=hizk.getIzena(izena)+atera;
				}
				if(atera.length()>0)
					JOptionPane.showMessageDialog(this,
						("("+Partida.getPartida().egoeraLortu()[2]+") "+hizk.getProperty("hilDira")+" "+atera));
			}
		}
	}

	public void komandoaAtzera() {
		komandoaAtzera(1);
	}
	public void komandoaAtzera(int pZenbat) {
		Partida.getPartida().komandoaAtzera(pZenbat);
		panelaAktualizatu();
	}
	public void itsasontziakIpini() {
		Partida.getPartida().itsasontziakIpini();	
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();	
	}
	public static int norabideaLortu() {
		return norabidea;
	}
	public void norabideaAldatu(){
		if(norabidea>=3)norabidea=0;
		else norabidea++;
		panelaAktualizatu();
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		System.out.println(pInfo[0]+" "+ pInfo[1]+" "+pInfo[2]+" "+pInfo[3]+" "+pNori+"-ri");
		Partida.getPartida().jokalariakObjektuaErabili(pNori, pInfo);
	}

	public void faseaAldatu() {
		Partida.getPartida().faseaAldatu(true);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}
	private void setMenua(boolean pJokalariakJarri) {
		menubar.erreseteatu(hizkuntza,pJokalariakJarri);
	}

	public static String[][] mapaInterpretatu(String pIzena) {
		return Partida.getPartida().mapaInterpretatu(pIzena);
	}

	public String norenTxandaDaIzena() {
		return norenTxanda;
	}

	public static int getLeihoaW() {
		return leihoaW;
	}
	public static int getLeihoaH() {
		return leihoaH;
	}
	public Color getKolorKontraste(Color c){
		double y = (299 * c.getRed() + 587 * c.getGreen() + 114 * c.getBlue()) / 1000;
		return (y >= 128 ? Color.black : Color.white);
	}
	public Color getKolorea(String pJokalaria) {
		return Partida.getPartida().getKolorea(pJokalaria);
	}

	public int jokalariakZenbatDiru(String pJokalaria) {
		return Partida.getPartida().jokalariakZenbatDiru(pJokalaria);
	}

	public String getAurkaria() {
		return Partida.getPartida().getAurkaria(norenTxanda);
	}
	public void setAurkaria(String pAurkaria) {
		Partida.getPartida().setAurkaria(pAurkaria);
		panelaAktualizatu();
	}
	public String getHizkuntza() {
		return this.hizkuntza;
	}
	public void setHizkuntza(String pHiz) {
		hizkuntza=pHiz;		
		panelaAktualizatu();
	}
	
	public JPanel getOraingoa() {
		return this.oraingoa;
	}

}