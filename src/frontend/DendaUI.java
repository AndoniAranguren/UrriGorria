package frontend;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import negozioLogika.Partida;

public class DendaUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria = null;
	private JButton[] denda;
	ArrayList<String> den = new ArrayList<>();
	
	public DendaUI(String pIzena) {
		jokalaria=pIzena;
		den = Partida.dendaEman(jokalaria);
		denda = new JButton[den.size()];
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.dendaHasieratu();
	}
	
	private void dendaHasieratu() {
		for(int i=0; i<den.size(); i++){
			denda[i] = new JButton();
			denda[i].setName(den.get(i));
			denda[i].setText(den.get(i));
			this.add(denda[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
