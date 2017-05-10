package frontend;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import externals.Irudiak;
import negozioLogika.Partida;
import negozioLogika.UrriGorria;
import negozioLogika.interfaces.UGKonstanteak;

public class PartidaZehaztu extends JPanel implements UGKonstanteak {

	private static final long serialVersionUID = 1L;
	private JRadioButton ia, bijokalari, erreza, zaila;
	private ButtonGroup norekin, zailtasuna;
	private JButton sartu;
	private JPanel pNorekin, pZailtasuna;
	
	public PartidaZehaztu() {
		this.setLayout(new BorderLayout());
		this.norekinZehaztu();
		this.zailtasunaZehaztu();
		sartu = new JButton("Partida hasi");
		sartu.addActionListener(gureAL -> partidaHasi());
		this.add(pNorekin, BorderLayout.WEST);
		this.add(pZailtasuna, BorderLayout.CENTER);
		this.add(sartu, BorderLayout.SOUTH);
	}
	
	private void norekinZehaztu() {
		ia = new JRadioButton("Makinaren aurka", true);
		ia.setActionCommand("MAKINAREN_AURKA");
		ia.addActionListener(gureAL -> getZailtasuna());
		bijokalari = new JRadioButton("Bi jokalari");
		bijokalari.setActionCommand("BI_JOKALARI");
		bijokalari.addActionListener(gureAL -> getZailtasuna());
		norekin = new ButtonGroup();
		norekin.add(ia);
		norekin.add(bijokalari);
		pNorekin = new JPanel(new BorderLayout());
		pNorekin.add(ia, BorderLayout.NORTH);
		pNorekin.add(bijokalari, BorderLayout.SOUTH);
		pNorekin.setBorder(BorderFactory.createTitledBorder("Norekin jokatu:"));
	}
	
	private void zailtasunaZehaztu() {
		erreza = new JRadioButton("Erreza", true);
		erreza.setActionCommand("MAKINAREN_AURKA_ERREZA");
		zaila = new JRadioButton("Zaila");
		zaila.setActionCommand("MAKINAREN_AURKA_ZAILA");
		zailtasuna = new ButtonGroup();
		zailtasuna.add(erreza);
		zailtasuna.add(zaila);
		pZailtasuna = new JPanel(new BorderLayout());
		pZailtasuna.setLayout(new BorderLayout());	
		pZailtasuna.add(erreza, BorderLayout.NORTH);
		pZailtasuna.add(zaila, BorderLayout.SOUTH);
		pZailtasuna.setBorder(BorderFactory.createTitledBorder("Zailtasuna aukeratu:"));
	}
	
	public void partidaHasi(){
		String info;
		ButtonModel oraingoa = zailtasuna.getSelection();
		info=(oraingoa.isEnabled() ? oraingoa.getActionCommand(): "BI_JOKALARI");
		Partida.getPartida().partidaZehaztu(info);
		Partida.getPartida().getUi().panelaAldatu(new PantailaUI(Partida.norenTxandaDa()));
	}
	
	public void getZailtasuna(){
		ButtonModel oraingoa = norekin.getSelection();
		String zailtasuna = oraingoa.getActionCommand();
		erreza.setEnabled(zailtasuna.equals("MAKINAREN_AURKA") ? true : false);
		zaila.setEnabled(zailtasuna.equals("MAKINAREN_AURKA") ? true : false);
	}
}
