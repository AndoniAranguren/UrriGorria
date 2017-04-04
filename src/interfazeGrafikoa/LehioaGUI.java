package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LehioaGUI extends JFrame {
	
	private static LehioaGUI nLehioa = null;
	private TableroaGUI tableroa = new TableroaGUI();
	private DendaGUI denda = new DendaGUI();

	private LehioaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		setLayout(new BorderLayout());
		add(tableroa, BorderLayout.CENTER);
		add(denda, BorderLayout.SOUTH);

	}
	
	public static LehioaGUI getLehioa() {
		if (nLehioa == null) {
			nLehioa = new LehioaGUI();
		}
		return nLehioa ;
	}

	public TableroaGUI getTableroa() {
		return tableroa;
	}

	public DendaGUI getDenda() {
		return denda;
	}		
}
