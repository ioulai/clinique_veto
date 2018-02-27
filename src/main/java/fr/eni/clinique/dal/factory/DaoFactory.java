package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.jdbc.impl.ConnexionDAO;
import fr.eni.clinique.dal.jdbc.impl.ConnexionDAOJdbcImpl;

public class DaoFactory {

	public static ConnexionDAO connexionDAO() {

		return ConnexionDAOJdbcImpl.getInstance();
	}

	public static PersonnelDAO personnelDao() {
		
		return null;
	}

}
