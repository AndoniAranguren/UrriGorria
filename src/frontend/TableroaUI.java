package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import negozioLogika.interfaces.UGKonstanteak;

public class TableroaUI extends JPanel implements UGKonstanteak, ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton[][] tableroa;
	private int ontziak = 10;
	
	public TableroaUI() {
		this.setLayout(new GridLayout(ERRENKADA_KOPURUA, ZUTABE_KOPURUA));
		tableroa = new JButton[ERRENKADA_KOPURUA][ZUTABE_KOPURUA];
		for(int i=0; i<ERRENKADA_KOPURUA; i++){
			for(int j=0; j<ZUTABE_KOPURUA; j++){
				tableroa[i][j] = new JButton();
				tableroa[i][j].setName(i + "-" + j);
				tableroa[i][j].addActionListener(this);
				tableroa[i][j].setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ura.png")));
				this.add(tableroa[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botoia = (JButton) e.getSource();
		//String errenkada = botoia.getName().substring(0,1);
		//String zutabea = botoia.getName().substring(2);
		//botoia.setEnabled(false);
		botoia.setIcon(new ImageIcon(TableroaUI.class.getResource("/externals/ontzia.png")));
	}

}
