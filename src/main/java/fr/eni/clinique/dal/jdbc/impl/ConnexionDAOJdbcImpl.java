package fr.eni.clinique.dal.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ConnexionDAOJdbcImpl implements ConnexionDAO{
	 private static final String SELECT_ALL = "SELECT * FROM personnels";
	   
	 private static ConnexionDAOJdbcImpl instance;


private ConnexionDAOJdbcImpl(){
	
}

public static ConnexionDAOJdbcImpl getInstance() {
    if(instance == null) {
        instance = new ConnexionDAOJdbcImpl();
    }
    return instance;
}

@Override
public void connexion() throws DaoException {
	Connection connexion = null;
    PreparedStatement statement = null;
    
	 try {
         connexion = MSSQLConnectionFactory.get();
         statement = connexion.prepareStatement(SELECT_ALL);
         statement.execute();
	 }
	 catch(SQLException e) {
         throw new DaoException(e.getMessage(), e);
     } 
	 finally {
         ResourceUtil.safeClose(connexion, statement);
     }
}
}
