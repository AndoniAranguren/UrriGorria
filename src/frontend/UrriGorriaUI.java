package frontend;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negozioLogika.Partida;
import negozioLogika.interfaces.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	private JPanel oraingoa;
	private static UrriGorriaUI ui;
	private String objektua="Ezer";
	private int norabidea;
	
	public UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa = new PartidaZehaztuUI();
		this.add(oraingoa);	
		setBounds(550, 350, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static UrriGorriaUI getUrriGorriaUI() {
		return ui == null ? (ui = new UrriGorriaUI()) : ui;
	}
	
	
	public void panelaAldatu(JPanel jartzeko) {
		this.remove(oraingoa);
		oraingoa = jartzeko;
		this.add(oraingoa);
//		setMinimumSize(new Dimension(825, 825));
		this.revalidate();
		this.repaint();
	}
	public void objektuaAldatu(String pObj){
		objektua=pObj;
	}
	public String objektuaEman(){
		return objektua;
	}

	public void komandoaEgikaritu(String pJokalaria, String pKomandoa, String[] pInfo) {
		Partida.getPartida().komandoaEgikaritu(pJokalaria, pKomandoa, pInfo);
	}

	public void partidaZehaztu(String pInfo) {
		Partida.getPartida().partidaZehaztu(pInfo);
	}

	public ArrayList<String> logaEman(String pJokalaria) {
		return Partida.getPartida().logaEman(pJokalaria);
	}

	public void panelaAktualizatu() {
		Partida.getPartida();
//		panelaAldatu(new PantailaUI(Partida.norenTxandaDa()));
		System.out.println("PanelaAktualizatu");
	}

	public void komandoaAtzera() {
		Partida.getPartida().komandoaAtzera();
	}
	public int norabideaLortu() {
		return norabidea;
	}
	public void norabideaAldatu(){
		if(norabidea>=3)norabidea=0;
		else norabidea++;
	}

	public void objektuaErabili(String pNori, String[] pInfo) {
		pInfo[0]=objektua;
		System.out.println(pInfo[0]+" "+ pInfo[1]+" "+pInfo[2]+" "+pInfo[3]);
		Partida.getPartida().jokalariakObjektuaErabili(pNori, pInfo);
	}
}