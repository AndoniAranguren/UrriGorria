package frontend;

import javax.swing.JPanel;

import properties.Hizkuntza;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class DendaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria = null;
	private JButton[] denda;
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
		this.setLayout(new GridLayout(den.size(), 1));
		this.setBorder(BorderFactory.createTitledBorder(hizkuntza.getProperty("denda") + ": "+dirua+"€"));
		this.dendaAktualizatu();
	}
	
	private void dendaAktualizatu() {
		denda = new JButton[den.size()];
		for(int i=0; i<den.size(); i++){
			denda[i] = new JButton();
			denda[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			denda[i].setName(den.get(i).split(":")[0]);
			denda[i].setText(hizkuntza.getProperty(den.get(i).split(":")[0]) + den.get(i).split(":")[1]+")");
	        denda[i].addActionListener(this);
	        denda[i].setEnabled(faseZuzenean);
	        int kopuru=Integer.parseInt(den.get(i).split(": ")[1].split(" \\(")[0]);
	        int diru=Integer.parseInt(den.get(i).split("\\(")[1].split("€")[0]);
	        if(kopuru<1 || diru>dirua)
	        	denda[i].setEnabled(false);
			this.add(denda[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] info= new String[1];
		String sourceText=(String)((JButton)e.getSource()).getName();
		info[0]=(sourceText.split(":")[0]);
		UrriGorriaUI.getUrriGorriaUI().komandoaEgikaritu(jokalaria,"CommandErosketaEgin",info);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}
}
