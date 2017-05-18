package frontend;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import negozioLogika.interfaces.UGKonstanteak;
import properties.Hizkuntza;

public class PartidaZehaztuUI extends JPanel implements UGKonstanteak {

	private static final long serialVersionUID = 1L;
	private JRadioButton ia, bijokalari, erreza, zaila;
	private ButtonGroup norekin, zailtasuna;
	private JButton sartu;
	private JPanel pNorekin, pZailtasuna;
	private Hizkuntza hizkuntza;
	
	public PartidaZehaztuUI(String h) {
		hizkuntza = new Hizkuntza(h);
		this.setLayout(new BorderLayout());
		this.norekinZehaztu();
		this.zailtasunaZehaztu();
		sartu = new JButton(hizkuntza.getProperty("hasi"));//	"Partida hasi"
		sartu.addActionListener(gureAL -> partidaHasi());
		this.add(pNorekin, BorderLayout.WEST);
		this.add(pZailtasuna, BorderLayout.CENTER);
		this.add(sartu, BorderLayout.SOUTH);
	}
	
	private void norekinZehaztu() {
		ia = new JRadioButton(hizkuntza.getProperty("makina"), true);	//	"Makinaren aurka"
		ia.setActionCommand("MAKINAREN_AURKA");
		ia.addActionListener(gureAL -> getZailtasuna());
		bijokalari = new JRadioButton(hizkuntza.getProperty("bi"));	//	"Bi jokalari"
		bijokalari.setActionCommand("BI_JOKALARI");
		bijokalari.addActionListener(gureAL -> getZailtasuna());
		norekin = new ButtonGroup();
		norekin.add(ia);
		norekin.add(bijokalari);
		pNorekin = new JPanel(new BorderLayout());
		pNorekin.add(ia, BorderLayout.NORTH);
		pNorekin.add(bijokalari, BorderLayout.SOUTH);
		pNorekin.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("norekin")));	//	"Norekin jokatu:"
	}
	
	private void zailtasunaZehaztu() {
		erreza = new JRadioButton(hizkuntza.getProperty("erreza"), true);	//	"Erreza"
		erreza.setActionCommand("MAKINAREN_AURKA_ERREZA");
		zaila = new JRadioButton(hizkuntza.getProperty("zaila"));	//	"Zaila"
		zaila.setActionCommand("MAKINAREN_AURKA_ZAILA");
		zailtasuna = new ButtonGroup();
		zailtasuna.add(erreza);
		zailtasuna.add(zaila);
		pZailtasuna = new JPanel(new BorderLayout());
		pZailtasuna.setLayout(new BorderLayout());	
		pZailtasuna.add(erreza, BorderLayout.NORTH);
		pZailtasuna.add(zaila, BorderLayout.SOUTH);
		pZailtasuna.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("zailtasuna")));	//	"Zailtasuna aukeratu:"
	}
	
	public void partidaHasi(){
		String info;
		ButtonModel oraingoa = zailtasuna.getSelection();
		info=(oraingoa.isEnabled() ? oraingoa.getActionCommand(): "BI_JOKALARI");
		UrriGorriaUI.getUrriGorriaUI().partidaZehaztu(info);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}
	
	public void getZailtasuna(){
		ButtonModel oraingoa = norekin.getSelection();
		String zailtasuna = oraingoa.getActionCommand();
		erreza.setEnabled(zailtasuna.equals("MAKINAREN_AURKA") ? true : false);
		zaila.setEnabled(zailtasuna.equals("MAKINAREN_AURKA") ? true : false);
	}
	
}
