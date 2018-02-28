package fr.eni.clinique.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ClientDAOJdbcImpl implements ClientDAO{

	private Connection connection = null;
	
	private static final String SELECT_ALL_QUERY = "select * from Clients";
	private static final String INSERT_QUERY = "insert into Clients(nomClient, prenomClient, adresse1, adresse2,ville,assurance,email,remarque,archive,lesAnimaux) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_QUERY ="DELETE FROM Clients WHERE codeClient=?";
	private static final String SELECT_BY_NOM="SELECT * FROM Personnels WHERE nomClient=?";
	private static final String UPDATE_QUERY="UPDATE Clients SET nomClient=?, prenomClient=?, adresse1=?, adresse2=?,ville=?,assurance=?,email=?,remarque=?,archive=?,lesAnimaux=?";
	
	private Client getClient(ResultSet res) throws SQLException{
		Client client = new Client();
		client.setCodeClient(res.getInt("CodeClient"));
		client.setNomClient(res.getString("nomClient"));
		client.setAdresse1(res.getString("adresse1"));
		client.setAdresse2(res.getString("adresse2"));
		client.setVille(res.getString("ville"));
		client.setAssurance(res.getString("assurance"));
		client.setEmail(res.getString("email"));
		client.setRemarque(res.getString("remarque"));
		client.setArchive(res.getBoolean("Archive"));
		//client.setLesAnimaux(res.getString("LesAnimaux"));
	
		return client;
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
	public List<Client> selectALL() throws DaoException {
		ouvertureConnection();
		List<Client> clients = new ArrayList<>();
		
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
			while(resultSet.next()){
				clients.add(getClient(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException("erreur recupération du personnels");
		}
	
		return clients;
	}

	@Override
	public List<Client> selectByNom(String nom) throws DaoException {
		
		  PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        
	        List<Client> lesClients = new ArrayList<Client>();
	        try {
	            connection = MSSQLConnectionFactory.get();
	            statement = connection.prepareStatement(SELECT_BY_NOM);
	            statement.setString(1, nom);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	lesClients.add((Client) resultSet);
	            }
	            
	        } catch(SQLException e) {
	            throw new DaoException(e.getMessage(), e);
	        } finally {
	            ResourceUtil.safeClose(connection, statement);
	        }
	        
	        return lesClients;
	}
	

	@Override
	public void update(Client newClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String ville, String assurance, String email, String remarque, Boolean archive, List<Animal> lesAnimaux)
			throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client insert(Client client) throws DaoException {
		   Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        
		try {
			  connection = MSSQLConnectionFactory.get();
			  statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
			
			  statement.setString(1,res.getString("nomClient"));
			  statement.setString(2,res.getString("adresse1"));
			  statement.setString(3,res.getString("adresse2"));
			  statement.setString(4,res.getString("ville"));
			  statement.setString(5,res.getString("assurance"));
			  statement.setString(6,res.getString("email"));
			  statement.setString(7,res.getString("remarque"));
			  statement.setBoolean(8,res.getBoolean("Archive"));
			//client.setLesAnimaux(res.getString("LesAnimaux"));
	            
	            if (statement.executeUpdate() == 1) {
	                res = statement.getGeneratedKeys();
	                if (res.next()) {
	                	client.setCodeClient(res.getInt(1));
	                }
			} }
		catch (SQLException e) {
			throw new DaoException("Erreur d'insertion personnel",e);
		}finally {
           ResourceUtil.safeClose(connection,statement,res);
       }
		return client;
	}
	

	@Override
	public void delete(Client newClient) throws DaoException {
		  Connection connection = null;
	        PreparedStatement statement = null;
	        
	        try {
	            connection = MSSQLConnectionFactory.get();
	            statement = connection.prepareStatement(DELETE_QUERY);
	            statement.setInt(1, newClient.getCodeClient());
	            statement.executeUpdate();
	            
	        } catch(SQLException e) {
	            throw new DaoException(e.getMessage(), e);
	        } finally {
	            ResourceUtil.safeClose(connection, statement);
	        }
		
	}

}
