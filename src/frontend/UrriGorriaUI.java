package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private JMenuBar menubar = new JMenuBar();
	
	public UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa = new PartidaZehaztuUI();
		this.add(oraingoa);	
		leihoaW=300;
		leihoaH=150;
		setBounds((monitoreaW-leihoaW)/2, (monitoreaH-leihoaH)/2, leihoaW, leihoaH);
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
		int[] egoera=Partida.getPartida().egoeraLortu();
        norenTxanda=Partida.getPartida().norenTxandaDaIzena();
        String irabazlea=Partida.getPartida().getIrabazlea();
		//fasea=egoera[0];
		//txanda=egoera[1];
		//iraupena=egoera[2];
        if(irabazlea==null){
        	if(egoera[2]==0){
    			leihoaW=monitoreaW*50/100;
    			leihoaH=monitoreaH*50/100;
    			panelaAldatu(new OntziakKokatuUI(norenTxanda));
    		}
    		else{
    			leihoaW=monitoreaW*65/100;
    			leihoaH=monitoreaH*90/100;
    			setMenua(norenTxanda);
    			panelaAldatu(new PantailaUI(norenTxanda,aurkaria,egoera));
    		}
        }
        else{
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
	private void setMenua(String pNorenTxanda) {
        menubar.removeAll();
        JMenu menua = new JMenu("Aurkariaren mapa aukeratu");
        menua.setMnemonic(KeyEvent.VK_F);

        String[] jokalariak=Partida.getPartida().jokalarienIzenakEman();
        JMenuItem[] eMenuItem = new JMenuItem[jokalariak.length];
        int ind=-1;
        for(String izena:jokalariak){
        	if(!izena.equals(pNorenTxanda)){
                ind++;
            	eMenuItem[ind] = new JMenuItem(izena);
            	eMenuItem[ind].setMnemonic(KeyEvent.VK_E);
                eMenuItem[ind].setName(izena);
                eMenuItem[ind].addActionListener(this);
                menua.add(eMenuItem[ind]);
        	}
        }
        menubar.add(menua);

        setJMenuBar(menubar);

        if(aurkaria==null||aurkaria.equals(pNorenTxanda))	aurkaria=eMenuItem[ind].getName();
	}
	public static String getAurkaria() {
		return aurkaria;
	}

	public static String[][] mapaInterpretatu(String pIzena) {
		return Partida.getPartida().mapaInterpretatu(pIzena);
	}

	public static String norenTxandaDaIzena() {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem){
			JMenuItem menua = (JMenuItem) e.getSource();
			aurkaria= menua.getName();
			panelaAktualizatu();
		}else if(e.getSource() instanceof JButton)
			if(((Component) e.getSource()).getName().equals("Berriro hasi"))
				Partida.getPartida().partidaErreseteatu();
	}
}