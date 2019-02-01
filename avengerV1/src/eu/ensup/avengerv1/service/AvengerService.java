package eu.ensup.avengerv1.service;

import java.util.ArrayList;

import eu.ensup.avengerv1.dao.AvengerDao;
import eu.ensup.avengerv1.domaine.Avenger;


public class AvengerService {
	
	private AvengerDao av;
	
	public void recruterAvenger(Avenger avenger){
		av = new AvengerDao();
		av.createAvenger(avenger);
	}

	public void trouverUnAvenger(String nomAv){
		av = new AvengerDao();
		av.readAvenger(nomAv);
	}
	
	public void virerAvenger(Avenger avenger){
		av = new AvengerDao();
		av.deleteAvenger(avenger);
	}
	
	public void modifierInfoAvenger(Avenger avenger){
		av = new AvengerDao();
		av.updateAvenger(avenger);
	}
	
	public ArrayList<Avenger> getAllAvengers(){
		av = new AvengerDao();
		return av.getAll();
	}
	
}
