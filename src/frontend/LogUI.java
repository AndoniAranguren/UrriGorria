package frontend;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negozioLogika.Partida;

public class LogUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JTextArea[] BattleLoga;
	private ArrayList<String> loga = new ArrayList<>();


	public LogUI(String pIzena) {
		jokalaria=pIzena;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Loga:"));
		this.logaAktualizatu();
	}
	public void logaAktualizatu(){
		loga = UrriGorriaUI.getUrriGorriaUI().logaEman(jokalaria);
		BattleLoga = new JTextArea[loga.size()];
		for(int i=(loga.size()-10 <0 ? 0 : loga.size()-10); i<loga.size(); i++){
			BattleLoga[i] = new JTextArea();
			BattleLoga[i].setText(loga.get(i));
			this.add(BattleLoga[i]);
		}
	}
}
