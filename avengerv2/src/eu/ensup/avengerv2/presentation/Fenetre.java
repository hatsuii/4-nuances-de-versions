package eu.ensup.avengerv2.presentation;

import javax.swing.JComponent;

import eu.ensup.avengerv2.dao.ExceptionDao;
import eu.ensup.avengerv2.domaine.Avenger;
import eu.ensup.avengerv2.service.AvengerService;

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
		
	}

}
