package frontend;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
		ia.addActionListener(gureAL -> getZailtasuna());
		bijokalari = new JRadioButton("Bi jokalari");
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
		erreza = new JRadioButton("Erreza");
		zaila = new JRadioButton("Zaila");
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
		ButtonModel oraingoa = norekin.getSelection();
		System.out.println(oraingoa);
		if(oraingoa.isSelected()) 
			System.out.println(oraingoa.getActionCommand());
		else
			UrriGorria.getUrriGorria().setPartida(BI_JOKALARI);
	}
	
	public void getZailtasuna(){
		/*ButtonModel oraingoa = zailtasuna.getSelection();
		int zenbakia = Integer.parseInt(oraingoa.getActionCommand());
		*/
	}
}
