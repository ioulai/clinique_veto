package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.dao.AnimalDAO;
import fr.eni.clinique.dal.dao.ClientDAO;
import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.dao.impl.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.dao.impl.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.dao.impl.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.dao.impl.PersonnelDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ConnexionDAO;

public class DaoFactory {

	public static ConnexionDAO connexionDAO() {

		return ConnexionDAOJdbcImpl.getInstance();
	}

	public static PersonnelDAO personnelDao() {
		PersonnelDAOJdbcImpl personnel = new PersonnelDAOJdbcImpl();
		return personnel;
	}
	
	public static AnimalDAO animalDao() {
		AnimalDAOJdbcImpl animal = new AnimalDAOJdbcImpl();
		return animal;
	}

	public static ClientDAO clientDAO() {
		ClientDAOJdbcImpl client = new ClientDAOJdbcImpl();
		
		return client;
	}

	public AnimalDAO AnimalDAO() {
		AnimalDAOJdbcImpl animal = new AnimalDAOJdbcImpl();
		
		return animal;	}
}
