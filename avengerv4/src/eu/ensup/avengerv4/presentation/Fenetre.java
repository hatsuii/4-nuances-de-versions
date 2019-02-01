package eu.ensup.avengerv4.presentation;


import javax.swing.JComponent;

import eu.ensup.avengerv4.dao.ExceptionDao;
import eu.ensup.avengerv4.domaine.Avenger;
import eu.ensup.avengerv4.service.AvengerService;

public class Fenetre extends JComponent{

	public static void main(String[] args) throws ExceptionDao {

		AvengerService as = new AvengerService();

		Avenger avenger = new Avenger(1,"Black windows","ordinateur","il crash");
		Avenger avenger1 = new Avenger(2,"Hulk","ordinateur","il crash");
		Avenger avenger2= new Avenger(3,"Iron man","ordinateur","il crash");
		Avenger avenger3 = new Avenger(4,"Black panter","ordinateur","il crash");
		Avenger avenger4 = new Avenger(5,"Dr strange","ordinateur","il crash");
		as.recruterAvenger(avenger) ;
		as.recruterAvenger(avenger1);
		as.recruterAvenger(avenger2);
		as.recruterAvenger(avenger3);
		as.recruterAvenger(avenger4);
		
		//as.trouverUnAvenger("hulk"); //ok
		//System.out.println(as.getAllAvengers().get(1));
		//as.tuerAvenger(avenger);	//ok
		//as.modifierInfoAvenger(avenger);
		
		
		/*		
		JFrame f = new JFrame("RH Avenger"); 
		f.setSize(700, 400);
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel();
		//p.setSize(20, 20);
		
		
		JMenu m1 = new JMenu("Accueil");
		JMenu m2 = new JMenu("Option");
		JMenu m3 = new JMenu("Edition");
		JMenuBar mb = new JMenuBar(); 
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		f.setJMenuBar(mb);
		
		JComboBox petList = new JComboBox(maListeAvengers.toArray());
		//petList.setSelectedIndex(4);
		//petList.addActionListener(this);
		p.add(petList);
		f.add(p);
		
		f.setVisible(true);
		*/
		
	}

}
