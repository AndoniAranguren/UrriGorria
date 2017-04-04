package interfazeGrafikoa;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DendaGUI extends JPanel {

	JLabel jLabel1 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JRadioButton hegazkinOntzia = new JRadioButton("Hegazkin-ontzia", true);
	JRadioButton itsaspekoa = new JRadioButton("Itsaspekoa", false);
	JRadioButton suntsitzailea = new JRadioButton("Suntsitzailea", false);
	JRadioButton fragata = new JRadioButton("Fragata", false);
	JRadioButton horizontala = new JRadioButton("Horizontala", true);
	JRadioButton bertikala = new JRadioButton("Bertikala", false);
	ButtonGroup g1 = new ButtonGroup();
	ButtonGroup g2 = new ButtonGroup();
	
	public DendaGUI() {
		
		
		setLayout(new GridLayout(4, 3));
		setBackground(Color.WHITE);
		
		jLabel1.setText("Aukeratu barku bat:");
		add(jLabel1);
		
		add(hegazkinOntzia);
		add(itsaspekoa);
		g2.add(hegazkinOntzia);
		g2.add(itsaspekoa);
		
		JLabel label2 = new JLabel("");
		add(label2);
		
		add(suntsitzailea);
		add(fragata);
		g2.add(suntsitzailea);
		g2.add(fragata);
		
		JLabel label3 = new JLabel("");
		add(label3);
		
		JLabel label4 = new JLabel("");
		add(label4);
		
		JLabel label5 = new JLabel("");
		add(label5);
		
		jLabel6.setText("Norabidea esleitu:");
		add(jLabel6);
		
		add(horizontala);
		add(bertikala);
		g1.add(horizontala);
		g1.add(bertikala);
	}
	
	public String ontziaBueltatu(){
		
		String ontzia = null;
		if(hegazkinOntzia.isSelected()){
			ontzia = "hegazkinOntzia";
		} else if(itsaspekoa.isSelected()){
			ontzia = "itsaspekoa";
		} else if(suntsitzailea.isSelected()){
			ontzia = "suntsitzailea";
		} else if(fragata.isSelected()){
			ontzia = "fragata";
		}
		return ontzia;
	}
	
	public String norabideaBueltatu(){
		
		String norabidea = null;
		if(horizontala.isSelected()){
			norabidea = "horizontala";
		} else if(bertikala.isSelected()){
			norabidea = "bertikala";
		}
		return norabidea;
	}
}