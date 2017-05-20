package interfazeGrafikoa;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfazeGrafikoa.properties.Hizkuntza;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class DendaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria = null;
	private JScrollPane  scroll;
	private JPanel denda;
	private ArrayList<String> den = new ArrayList<>();
	private int dirua;
	private boolean faseZuzenean;
	private Hizkuntza hizkuntza;
	
	public DendaUI(String pIzena, boolean pFaseZuzenean, String hizk) {
		hizkuntza = new Hizkuntza(hizk);
		jokalaria=pIzena;
		faseZuzenean=pFaseZuzenean;
		dirua = UrriGorriaUI.getUrriGorriaUI().jokalariakZenbatDiru(jokalaria);
		den = UrriGorriaUI.getUrriGorriaUI().dendaEman(jokalaria);
		this.setLayout(new BorderLayout());
		denda= new JPanel();
		denda.setLayout(new GridLayout(den.size(), 1));
		this.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("denda") + ": "+dirua+"€"));
		dendaAktualizatu();

		scroll.setPreferredSize(new java.awt.Dimension(UrriGorriaUI.getLeihoaW()/4,UrriGorriaUI.getLeihoaH()/3));
		this.add(scroll, BorderLayout.CENTER);
	}
	
	private void dendaAktualizatu() {
		JButton[] dendaButton = new JButton[den.size()];
		for(int i=0; i<den.size(); i++){
			String[] izena=den.get(i).split(":");
			String iz;
			dendaButton[i] = new JButton();
			dendaButton[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			dendaButton[i].setName(izena[0]);
			if(izena[0].contains("x")){
				iz=(hizkuntza.getProperty(izena[0].split("x")[0]).concat("x"+izena[0].split("x")[1]));
			}else{
				iz=hizkuntza.getProperty(izena[0]);
			}
			iz=iz+ den.get(i).split(":")[1]+")";
			dendaButton[i].setText(iz);
			dendaButton[i].addActionListener(this);
			dendaButton[i].setEnabled(faseZuzenean);
	        int kopuru=Integer.parseInt(den.get(i).split(": ")[1].split(" \\(")[0]);
	        int diru=Integer.parseInt(den.get(i).split("\\(")[1].split("€")[0]);
	        if(kopuru<1 || diru>dirua)
	        	dendaButton[i].setEnabled(false);
			denda.add(dendaButton[i]);
		}
		scroll=new JScrollPane(denda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] info= new String[1];
		String sourceText=(String)((JButton)e.getSource()).getName();
		info[0]=(sourceText.split(":")[0]);
		UrriGorriaUI.getUrriGorriaUI().komandoaEgikaritu(jokalaria,"CommandErosketaEgin",info);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}
}
