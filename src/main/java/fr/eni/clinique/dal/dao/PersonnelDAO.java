package fr.eni.clinique.dal.dao;

import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.jdbc.impl.ConnexionDAOJdbcImpl;

public interface PersonnelDAO {
	
	List<Personnel> selectALL() throws DaoException;
	
	void insert(Personnel newPersonnel) throws DaoException;
	void update(Personnel newPersonnel, String pass) throws DaoException;
	void delete(Personnel newPersonnel) throws DaoException;
	
	List<Personnel> selectByRole(String role) throws DaoException;
	
	
}
