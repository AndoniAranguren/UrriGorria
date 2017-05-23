package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import interfazeGrafikoa.properties.Hizkuntza;

public class PartidaZehaztuUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int jokalariMaximoak=50;
	private ButtonGroup norekin, zailtasuna;
	private JButton sartu;
	private JPanel pNorekin, pZailtasuna,erdia,pAnitza;
	private Hizkuntza hizkuntza;
	private int[] jokalariak=new int[2];
	private JRadioButton erreza,normal,zaila;
	private boolean anitz=false;
	
	JTextField jokKop =new JTextField();
	JTextField cpuKop =new JTextField();
	
	public PartidaZehaztuUI(String h) {
		hizkuntza = new Hizkuntza(h);

		jokalariak[0]=1;
		jokalariak[1]=1;
		
		this.setLayout(new BorderLayout());
		this.norekinZehaztu();
		this.zailtasunaZehaztu();
		this.anitzakZehaztu();
		sartu = new JButton(hizkuntza.getProperty("hasi"));//	"Partida hasi"
		sartu.addActionListener(e->akzioaBota("SARTU"));
		JPanel zati=new JPanel(new GridLayout(1, 2));
		erdia=new JPanel(new BorderLayout());
		zati.add(pNorekin);
		zati.add(pZailtasuna);
		erdia.add(zati,BorderLayout.NORTH);
		erdia.add(pAnitza, BorderLayout.SOUTH);
		this.add(erdia);
		this.add(sartu, BorderLayout.SOUTH);
	}
	
	private void anitzakZehaztu() {
		pAnitza = new JPanel(new GridLayout(2,2));
		JLabel jok =new JLabel();
		JLabel cpu =new JLabel();
		
		jok.setText(hizkuntza.getProperty("jokKop"));
		cpu.setText(hizkuntza.getProperty("cpuKop"));
		
		pAnitza.add(jok);
		pAnitza.add(cpu);
		pAnitza.add(jokKop);
		pAnitza.add(cpuKop);
		pAnitza.setVisible(false);
	}

	private void norekinZehaztu() {
	
		JRadioButton ia, bijokalari,anitz;
		ia = new JRadioButton(hizkuntza.getProperty("makina"), true);	//	"Makinaren aurka"
		anitz = new JRadioButton(hizkuntza.getProperty("anitz"));	//	"Makinaren aurka"
		bijokalari = new JRadioButton(hizkuntza.getProperty("bi"));	//	"Bi jokalari"
	
		ia.addActionListener(e->akzioaBota("MAKINAREN_AURKA"));
		anitz.addActionListener(e->akzioaBota("ANITZ"));
		bijokalari.addActionListener(e->akzioaBota("BI_JOKALARI"));
	
		norekin = new ButtonGroup();
		norekin.add(ia);
		norekin.add(bijokalari);
		norekin.add(anitz);
	
		pNorekin = new JPanel(new GridLayout(3,1));	
		pNorekin.add(ia);
		pNorekin.add(bijokalari);
		pNorekin.add(anitz);
		pNorekin.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("norekin")));	//	"Norekin jokatu:"
	}
	
	private void zailtasunaZehaztu() {
		erreza = new JRadioButton(hizkuntza.getProperty("superZaila"));	//	"Erreza"
		normal = new JRadioButton(hizkuntza.getProperty("normal"), true);	//	"Normal"
		zaila = new JRadioButton(hizkuntza.getProperty("zaila"));	//	"Zaila"
	
		erreza.setActionCommand("MAKINAREN_AURKA_ERREZA");
		erreza.addActionListener(e->akzioaBota("MAKINAREN_AURKA_ERREZA"));
		normal.setActionCommand("MAKINAREN_AURKA_NORMAL");
		normal.addActionListener(e->akzioaBota("MAKINAREN_AURKA_ERREZA"));
		zaila.setActionCommand("MAKINAREN_AURKA_ZAILA");
		zaila.addActionListener(e->akzioaBota("MAKINAREN_AURKA_ERREZA"));
	
		zailtasuna = new ButtonGroup();
		zailtasuna.add(erreza);
		zailtasuna.add(zaila);
		zailtasuna.add(normal);
	
		pZailtasuna = new JPanel(new BorderLayout());
		pZailtasuna.setLayout(new GridLayout(3,1));	
		pZailtasuna.add(normal);
		pZailtasuna.add(zaila);
		pZailtasuna.add(erreza);
		pZailtasuna.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("zailtasuna")));	//	"Zailtasuna aukeratu:"
	}
	
	public void akzioaBota(String akzioa) {
		if(akzioa.equals("SARTU")){
			if(anitz){
				if(tryParseInt()&&mugetan()){
					datuakBidali();
				}
			}else{
				datuakBidali();
			}
		}if(akzioa.contains("MAKINAREN_AURKA")){
			java.util.Enumeration<javax.swing.AbstractButton> j=zailtasuna.getElements();
			while(j.hasMoreElements())j.nextElement().setEnabled(true);
		}else{
			java.util.Enumeration<javax.swing.AbstractButton> j=zailtasuna.getElements();
			while(j.hasMoreElements())j.nextElement().setEnabled(false);
			if(akzioa.equals("BI_JOKALARI")){
				jokalariak[0]=2;
				jokalariak[1]=0;
			}	
		}if(zailtasuna.getSelection().isEnabled()){
			if(zailtasuna.getSelection().getActionCommand().equals("MAKINAREN_AURKA_ERREZA")){
				jokalariak[0]=1;
				jokalariak[1]=0;
				Object[] choices = {hizkuntza.getProperty("aurrera")};
				Object defaultChoice = choices;
				JOptionPane.showOptionDialog(this,
						hizkuntza.getProperty("abisua"),
						hizkuntza.getProperty("kontuz"),
			            JOptionPane.WARNING_MESSAGE,
			            JOptionPane.WARNING_MESSAGE,
			            null,
			            choices,
			            defaultChoice);
			}else if(zailtasuna.getSelection().getActionCommand().equals("MAKINAREN_AURKA_NORMAL")){
				jokalariak[0]=1;
				jokalariak[1]=1;
			}else if(zailtasuna.getSelection().getActionCommand().equals("MAKINAREN_AURKA_ZAILA")){
				jokalariak[0]=1;
				jokalariak[1]=2;
			}
		}
		anitz=akzioa.equals("ANITZ")||akzioa.equals("SARTU");
		pAnitza.setVisible(anitz);
	}
	private boolean mugetan() {
		boolean ondo=true;
		if(jokalariak[0]+jokalariak[1]>jokalariMaximoak){
			jokKop.setText("MAX 50");
			cpuKop.setText("MAX 50");
			ondo= false;
		}if(jokalariak[0]<=0){
			jokKop.setText("MIN 1");
			ondo= false;
		}if(jokalariak[1]<0){
			cpuKop.setText("MIN 0");
			ondo= false;
		}
		return ondo;
	}

	private void datuakBidali() {
		UrriGorriaUI.getUrriGorriaUI().partidaZehaztu(jokalariak);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
}

	private boolean tryParseInt() {  
	     try {  
	         Integer.parseInt(jokKop.getText());  
	         Integer.parseInt(cpuKop.getText());
	         jokalariak[0]=Integer.parseInt(jokKop.getText());
		     jokalariak[1]=Integer.parseInt(cpuKop.getText());
	         return true;  
	      } catch (NumberFormatException e) {  
		     jokKop.setText("1");
		     cpuKop.setText("1");
	         return false;  
	      }  
	}
}
