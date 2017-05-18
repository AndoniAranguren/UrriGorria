package frontend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Parser;

import properties.Hizkuntza;

public class LogUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String jokalaria=null;
	private JButton[] BattleLoga;
	private ArrayList<String> loga = new ArrayList<>();
	private Hizkuntza h;


	public LogUI(String pIzena, String hizkuntza) {
		h = new Hizkuntza(hizkuntza);
		jokalaria=pIzena;
		loga = UrriGorriaUI.getUrriGorriaUI().logaEman(jokalaria);
		this.setLayout(new GridLayout(16, 1));
		this.setBorder(BorderFactory.createTitledBorder("Log:"));
		this.setPreferredSize(new Dimension(250, UrriGorriaUI.getLeihoaH()-150));
		this.logaAktualizatu();
	}
	public void logaAktualizatu(){
		BattleLoga = new JButton[loga.size()];
		for(int i=(loga.size()-16 <0 ? 0 : loga.size()-16); i<loga.size(); i++){
			BattleLoga[i] = new JButton();
			BattleLoga[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			String info=loga.get(i);
			BattleLoga[i].setName(info.split("#")[0]);
			
			info=info.split("#")[1];
			String jok=h.getProperty(info.split("'")[1]);
			String kom=h.getProperty(info.split("'")[4]);
			String obj=h.getProperty(info.split("'")[5]);
			BattleLoga[i].setText("<html>" +info.split("'")[0]+ jok+info.split("'")[2]+" "+kom+" ("+obj + ")</html>");
			BattleLoga[i].addActionListener(this);
			this.add(BattleLoga[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String info=((Component) e.getSource()).getName();
		UrriGorriaUI.getUrriGorriaUI().komandoaAtzera(info.split("'"));
	}
}
