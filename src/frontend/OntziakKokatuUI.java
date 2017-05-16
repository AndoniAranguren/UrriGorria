package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.Partida;

public class OntziakKokatuUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private TableroaUI jok_tableroa;
	private InbentarioaUI inb;
	private JPanel ontziak;

	public OntziakKokatuUI(String jokalaria, Color c) {
		this.setLayout(new BorderLayout());
		jok_tableroa = new TableroaUI(jokalaria, c);
		this.add(jok_tableroa, BorderLayout.CENTER);
		
		ontziak = new JPanel();
		inb = new InbentarioaUI(jokalaria);
		JButton nora = new JButton(new ImageIcon(TableroaUI.class.getResource(norabideaLortu())));
		nora.setName("Norabidea");
		nora.addActionListener(this);
		ontziak.add(inb);
		ontziak.add(nora);
		this.add(ontziak, BorderLayout.WEST);
		JButton jarraitu = new JButton("Jarraitu");
		jarraitu.setName("Jarraitu");
		jarraitu.addActionListener(this);
		this.add(jarraitu, BorderLayout.EAST);
		
	}
	
	private String norabideaLortu() {
		String irudi;
		switch (UrriGorriaUI.getUrriGorriaUI().norabideaLortu()){
			case 0: irudi="/externals/eki.png";
				break;
			case 1: irudi="/externals/hego.png";
				break;
			case 2: irudi="/externals/mend.png";
				break;
			case 3: irudi="/externals/ipar.png";
				break;
			default: irudi="/externals/eki.png";
				break;
		}
		return irudi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Jarraitu")){
			UrriGorriaUI.getUrriGorriaUI().panelaAldatu(new PantailaUI(Partida.norenTxandaDa()));
		}
	}
}
