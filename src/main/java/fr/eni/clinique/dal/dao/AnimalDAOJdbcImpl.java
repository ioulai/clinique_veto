package fr.eni.clinique.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class AnimalDAOJdbcImpl implements AnimalDAO{
	private Connection connection = null;
	
	private static final String SELECT_ALL_QUERY = "select * from Animaux";
	private static final String INSERT_QUERY = "insert into Animaux (NomAnimal, Sexe, Espece, CodeClient,Tatouage,Antecedents,Archive) values(?,?,?,?,?,?,?)";
	private static final String DELETE_QUERY ="DELETE FROM Animaux WHERE CodeAnimal=?";
	private static final String SELECT_BY_ROLE="SELECT * FROM Personnels WHERE Role=?";
	private static final String UPDATE_QUERY="UPDATE Personnels SET Nom=?, MotPasse=?, Role=?, Archive=? WHERE CodePers=?";
	
	private Animal getAnimal(ResultSet res) throws SQLException{
		Animal animal = new Animal();
		animal.setCodeAnimal(res.getInt("CodeAnimal"));
		animal.setNomAnimal(res.getString("NomAnimal"));
		animal.setSexe(res.getString("Sexe"));
		animal.setEspece(res.getString("Espece"));
		animal.setCodeClient(res.getInt("CodeClient"));
		animal.setTatouage(res.getString("Tatouage"));
		animal.setAntecedents(res.getString("Antecedents"));
		animal.setArchive(res.getBoolean("Archive"));
		
		return animal;
	}
	
	private void ouvertureConnection() throws DaoException{
		try {
			if (connection == null){
				connection = MSSQLConnectionFactory.get();
			}
		} catch (SQLException e) {
		throw new DaoException("Erreur connexion",e);
		}
	}
	
	@Override
	public List<Animal> selectALL() throws DaoException {
		ouvertureConnection();
		List<Animal> animaux = new ArrayList<>();
		
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
			while(resultSet.next()){
				animaux.add(getAnimal(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException("erreur recupération des animaux");
		}
	
		return animaux;
	}

	@Override
	public Animal insert(Animal newAnimal) throws DaoException {
			Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        
		try {
			   connection = MSSQLConnectionFactory.get();
	           statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

	            statement.setString(1, newAnimal.getNomAnimal());
	            statement.setString(2, newAnimal.getSexe());
	            statement.setString(3, newAnimal.getEspece());
	            statement.setInt(4, newAnimal.getCodeClient());
	            statement.setString(5, newAnimal.getTatouage());
	            statement.setString(6, newAnimal.getAntecedents());
	            statement.setBoolean(7, newAnimal.getArchive());
	            
	            if (statement.executeUpdate() == 1) {
	                resultSet = statement.getGeneratedKeys();
	                if (resultSet.next()) {
	                	newAnimal.setCodeAnimal(resultSet.getInt(1));
	                }
			} }
		catch (SQLException e) {
			throw new DaoException("Erreur d'insertion personnel",e);
		}finally {
         ResourceUtil.safeClose(connection,statement,resultSet);
     }
		return newAnimal;
	}

	@Override
	public void update(Animal newAnimal, int codeClient, String tatouage, String antecedents, Boolean archive)
			throws DaoException {
		
		
	}

	@Override
	public void delete(Animal newAnimal) throws DaoException {
		    Connection connection = null;
	        PreparedStatement statement = null;
	        
	        try {
	            connection = MSSQLConnectionFactory.get();
	            statement = connection.prepareStatement(DELETE_QUERY);
	            statement.setInt(1, newAnimal.getCodeAnimal());
	            statement.executeUpdate();
	            
	        } catch(SQLException e) {
	            throw new DaoException(e.getMessage(), e);
	        } finally {
	            ResourceUtil.safeClose(connection, statement);
	        }
		
	}

	@Override
	public List<Animal> selectByRace(String race) throws DaoException {
		
		return null;
	}

}
