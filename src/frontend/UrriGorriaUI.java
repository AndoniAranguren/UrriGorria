package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negozioLogika.UGKonstanteak;

public class UrriGorriaUI extends JFrame implements UGKonstanteak {
	
	private static final long serialVersionUID = 1L;
	//private static UrriGorriaUI nLeihoa = null;
	//private TableroaGUI tableroa = new TableroaGUI();
	//private ItsasontziaGUI ontzia = new ItsasontziaGUI();
	private JPanel oraingoa;

	public UrriGorriaUI() {
		this.setTitle(IZENBURUA);
		oraingoa = new PartidaZehaztu();
		this.add(oraingoa);	
		setBounds(550, 350, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/*public static UrriGorriaUI getLehioa() {
		if (nLeihoa == null) {
			nLeihoa = new UrriGorriaUI();
		}
		return nLeihoa ;
	}
	
	public void ontziakKokatu(){
		setLayout(new BorderLayout());
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
	}	*/	
}
