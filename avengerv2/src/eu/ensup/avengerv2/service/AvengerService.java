package eu.ensup.avengerv2.service;

import java.util.ArrayList;

import eu.ensup.avengerv2.dao.AvengerDao;
import eu.ensup.avengerv2.dao.ExceptionDao;
import eu.ensup.avengerv2.domaine.Avenger;


public class AvengerService {
	
	private AvengerDao av;
	
	public void recruterAvenger(Avenger avenger) throws ExceptionDao {
		av = new AvengerDao();
		av.createAvenger(avenger);
	}

	public void trouverUnAvenger(String nomAv) throws ExceptionDao {
		av = new AvengerDao();
		av.readAvenger(nomAv);
	}
	
	public void virerAvenger(Avenger avenger) throws ExceptionDao{
		av = new AvengerDao();
		av.deleteAvenger(avenger);
	}
	
	public void modifierInfoAvenger(Avenger avenger) throws ExceptionDao {
		av = new AvengerDao();
		av.updateAvenger(avenger);
	}
	
	public ArrayList<Avenger> getAllAvengers() throws ExceptionDao{
		av = new AvengerDao();
		return av.getAll();
	}
	
}
