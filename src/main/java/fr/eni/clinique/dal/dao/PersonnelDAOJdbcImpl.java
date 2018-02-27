package fr.eni.clinique.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DaoException;

public class PersonnelDAOJdbcImpl implements PersonnelDAO{
	private Connection connexion = null;
	
	private Personnel getPersonnel(ResultSet res) throws SQLException{
		Personnel personnel = new Personnel();
		personnel.setCodePers(res.getInt("CodePers"));
		personnel.setNom(res.getString("Nom"));
		personnel.setMotPasse(res.getString("MotPasse"));
		personnel.setRole(res.getString("Role"));
		
		return personnel;
	}
	
	private void remplissagePersonnel(PreparedStatement statement, Personnel personnel) throws SQLException{
		
		statement.setString(1,  personnel.getNom());
		statement.setString(2,  personnel.getMotPasse());
		statement.setString(3,  personnel.getRole());
	}
	
	
	@Override
	public List<Personnel> selectALL() throws DaoException {
	
		return null;
	}

	@Override
	public void insert(Personnel newPersonnel) throws DaoException {
		
		
	}

	@Override
	public void update(Personnel newPersonnel, String pass) throws DaoException {
		
		
	}

	@Override
	public void delete(Personnel newPersonnel) throws DaoException {
	
		
	}

	@Override
	public List<Personnel> selectByRole(String role) throws DaoException {

		return null;
	}

}
