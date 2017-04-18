package frontend;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import externals.Irudiak;
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
		ia.setActionCommand(String.valueOf(MAKINAREN_AURKA));
		ia.addActionListener(gureAL -> getZailtasuna());
		bijokalari = new JRadioButton("Bi jokalari");
		bijokalari.setActionCommand(String.valueOf(BI_JOKALARI));
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
		erreza.setActionCommand(String.valueOf(MAKINAREN_AURKA_ERREZA));
		zaila = new JRadioButton("Zaila");
		zaila.setActionCommand(String.valueOf(MAKINAREN_AURKA_ZAILA));
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
		ButtonModel oraingoa = zailtasuna.getSelection();
		if(oraingoa.isEnabled()) 
			UrriGorria.getUrriGorria().setPartida(Integer.parseInt(oraingoa.getActionCommand()));
		else
			UrriGorria.getUrriGorria().setPartida(BI_JOKALARI);
		UrriGorria.getUrriGorria().getUi().panelaAldatu(new OntziakAukeratu1());
	}
	
	public void getZailtasuna(){
		ButtonModel oraingoa = norekin.getSelection();
		int zenbakia = Integer.parseInt(oraingoa.getActionCommand());
		erreza.setEnabled(zenbakia==MAKINAREN_AURKA ? true : false);
		zaila.setEnabled(zenbakia==MAKINAREN_AURKA ? true : false);
	}
}
