package frontend;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import negozioLogika.Partida;
import negozioLogika.UrriGorria;

public class DendaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria = null;
	private JButton[] denda;
	private ArrayList<String> den = new ArrayList<>();
	
	public DendaUI(String pIzena) {
		jokalaria=pIzena;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Denda:"));
		this.dendaAktualizatu();
	}
	
	private void dendaAktualizatu() {
		den = Partida.dendaEman(jokalaria);
		denda = new JButton[den.size()];
		for(int i=0; i<den.size(); i++){
			denda[i] = new JButton();
			denda[i].setName(den.get(i));
			denda[i].setText(den.get(i));
	        denda[i].addActionListener(this);
			this.add(denda[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] info= new String[1];
		String sourceText=(String)((JButton)e.getSource()).getText();
		info[0]=(sourceText.split(":")[0]);
		UrriGorriaUI.getUrriGorriaUI().komandoaEgikaritu(jokalaria,"CommandErosketaEgin",info);
		UrriGorriaUI.getUrriGorriaUI().panelaAktualizatu();
	}
}
