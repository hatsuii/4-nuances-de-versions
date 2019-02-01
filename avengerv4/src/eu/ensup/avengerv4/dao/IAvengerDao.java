package eu.ensup.avengerv4.dao;

import java.util.ArrayList;

import eu.ensup.avengerv4.domaine.Avenger;

public interface IAvengerDao {
	
	public void createAvenger(Avenger avenger) throws ExceptionDao;
	public void updateAvenger(Avenger avenger) throws ExceptionDao;
	public void deleteAvenger(Avenger avenger) throws ExceptionDao;
	public Avenger readAvenger(String nomavenger) throws ExceptionDao;
	public ArrayList<Avenger> getAll() throws ExceptionDao;
}
