package interfazeGrafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LeihoaGUI extends JFrame {
	
	private static LeihoaGUI nLeihoa = null;
	private TableroaGUI tableroa = new TableroaGUI();
	private ItsasontziaGUI ontzia = new ItsasontziaGUI();

	private LeihoaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		setLayout(new BorderLayout());

	}
	
	public static LeihoaGUI getLehioa() {
		if (nLeihoa == null) {
			nLeihoa = new LeihoaGUI();
		}
		return nLeihoa ;
	}
	
	public void ontziakKokatu(){
		add(tableroa, BorderLayout.CENTER);
		add(ontzia, BorderLayout.SOUTH);
	}
	
	public void jokZehaztu(){
		
	}

	public TableroaGUI getTableroa() {
		return tableroa;
	}

	public ItsasontziaGUI getOntzia() {
		return ontzia;
	}		
}
