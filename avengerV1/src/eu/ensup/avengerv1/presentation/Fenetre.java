package eu.ensup.avengerv1.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import eu.ensup.avengerv1.domaine.Avenger;
import eu.ensup.avengerv1.service.AvengerService;

public class Fenetre extends JComponent{

	public static void main(String[] args){

		AvengerService as = new AvengerService();

		Avenger avenger = new Avenger(1,"Black windows","ordinateur","il crash");
		Avenger avenger1 = new Avenger(2,"Hulk","ordinateur","il crash");
		Avenger avenger2= new Avenger(3,"Iron man","ordinateur","il crash");
		Avenger avenger3 = new Avenger(4,"Black panter","ordinateur","il crash");
		Avenger avenger4 = new Avenger(5,"Dr strange","ordinateur","il crash");
		as.recruterAvenger(avenger) ;
		
		/*as.recruterAvenger(avenger1);
		as.recruterAvenger(avenger2);
		as.recruterAvenger(avenger3)
		as.recruterAvenger(avenger4);*/
		
		//as.trouverUnAvenger("hulk"); //ok
		//System.out.println(as.getAllAvengers().get(1));
		//as.tuerAvenger(avenger);	//ok
		//as.modifierInfoAvenger(avenger);
		
	}

}
