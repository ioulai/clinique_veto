package fr.eni.clinique.dal.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;


public class PersonnelDAOJdbcImpl implements PersonnelDAO{
	private Connection connexion = null;
	private static final String SELECT_ALL_QUERY = "select * from Personnels";
	private static final String INSERT_QUERY = "insert into Personnels(Nom, MotPasse, Role, Archive) values(?,?,?,?)";
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
	
	private void ouvertureConnection() throws DaoException{
		try {
			if (connexion == null){
				connexion = MSSQLConnectionFactory.get();
			}
		} catch (SQLException e) {
		throw new DaoException("Erreur connexion",e);
		}
	}
	
	
	@Override
	public List<Personnel> selectALL() throws DaoException {
		ouvertureConnection();
		List<Personnel> personnels = new ArrayList<>();
		
		try {
			Statement statement = (Statement) connexion.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
			while(resultSet.next()){
				personnels.add(getPersonnel(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException("erreur recupération du personnels");
		}
	
		return personnels;
	}

	@Override
	public void insert(Personnel newPersonnel) throws DaoException {
		ouvertureConnection();
		PreparedStatement statement = null;
	
		try {
			statement = connexion.prepareStatement(INSERT_QUERY);
			remplissagePersonnel(statement, newPersonnel);
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException("erreur d'insertion personnel",e);
		}finally {
            ResourceUtil.safeClose(statement);
        }
		
		
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
