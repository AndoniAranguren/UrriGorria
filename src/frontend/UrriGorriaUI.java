package frontend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import negozioLogika.Partida;
import negozioLogika.interfaces.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak , ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel oraingoa;
	private static UrriGorriaUI ui;
	private static String objektua="Ezer";
	private static int norabidea;
	private static String aurkaria=null,norenTxanda;
	private int monitoreaW=(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	private int monitoreaH=(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	private static int leihoaW, leihoaH;
	private MenuBarra menubar;
	private String hizkuntza = "euskera";
	private boolean partidaZehaztuDa;
	
	public UrriGorriaUI() {
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
	public static String getObjektua(){
		return objektua;
	}

	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		Partida.getPartida().komandoaEgikaritu(pJokalaria, pKomandoa, pInfo);
	}

	public void partidaZehaztu(String pInfo) {
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
		if(partidaZehaztuDa){
			int[] egoera=Partida.getPartida().egoeraLortu();
	        norenTxanda=Partida.getPartida().norenTxandaDaIzena();
	        String irabazlea=Partida.getPartida().getIrabazlea();
			//fasea=egoera[0];
			//txanda=egoera[1];
			//iraupena=egoera[2];
	        if(irabazlea==null){//Jolasten jarraitu
				setMenua(egoera[2]!=0);
	        	if(egoera[2]!=0){//Turno normalak
	    			leihoaW=monitoreaW*65/100;
	    			leihoaH=monitoreaH*90/100;
	    			panelaAldatu(new PantailaUI(norenTxanda,aurkaria,egoera));
	    		}
	    		else{//Barkuak jarri
	    			leihoaW=monitoreaW*50/100;
	    			leihoaH=monitoreaH*50/100;
	    			panelaAldatu(new OntziakKokatuUI(norenTxanda));
	    		}
	        }
	        else{//Irabazle bat dago AMAITU
	        	JPanel amaituta=new JPanel();
	        	amaituta.setName(irabazlea+"-k jokoa irabazi du");
	        	amaituta.add(new javax.swing.JTextField(irabazlea+"-k jokoa irabazi du"));
	        	JButton berriro= new JButton("Berriro hasi");
	        	berriro.setName("Berriro hasi");
	        	berriro.addActionListener(this);
	        	amaituta.add(berriro);
	        	leihoaW=300;
	    		leihoaH=150;
	        	panelaAldatu(amaituta);
	        }
			this.setMinimumSize(new Dimension(leihoaW,leihoaH));
		}
		else{//Jokalariak aukeratu behar dira
			panelaAldatu(new PartidaZehaztuUI(hizkuntza));
			setMenua(false);
			leihoaW=400;
			leihoaH=200;
		}
		setBounds((monitoreaW-leihoaW)/2, (monitoreaH-leihoaH)/2, leihoaW, leihoaH);
		System.out.println("PanelaAktualizatu");
	}

	public void komandoaAtzera() {
		Partida.getPartida().komandoaAtzera();
	}
	public void komandoaAtzera(String[] pInfo) {
		Partida.getPartida().komandoaAtzera(pInfo);
	}
	public static int norabideaLortu() {
		return norabidea;
	}
	public void norabideaAldatu(){
		if(norabidea>=3)norabidea=0;
		else norabidea++;
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		System.out.println(pInfo[0]+" "+ pInfo[1]+" "+pInfo[2]+" "+pInfo[3]);
		Partida.getPartida().jokalariakObjektuaErabili(pNori, pInfo);
	}

	public void faseaAldatu() {
		Partida.getPartida().faseaAldatu(true);
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

	public int jokalariakZenbatDiru(String pJokalaria) {
		return Partida.getPartida().jokalariakZenbatDiru(pJokalaria);
	}

	public String getAurkaria() {
		return aurkaria;
	}
	public void setAurkaria(String pAurkaria) {
		aurkaria=pAurkaria;
		panelaAktualizatu();
	}
	public String getHizkuntza() {
		return this.hizkuntza;
	}
	public void setHizkuntza(String pHiz) {
		hizkuntza=pHiz;		
		panelaAktualizatu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton)
			if(((Component) e.getSource()).getName().equals("Berriro hasi"))
				Partida.getPartida().partidaErreseteatu();
	}
}