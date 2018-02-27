package fr.eni.clinique.bll.manager.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;
import fr.eni.clinique.dal.jdbc.impl.ConnexionDAO;

public class LoginMgerImpl implements LoginMger{
	private static LoginMgerImpl SINGLETON;
	private PersonnelDAO personnelDAO = DaoFactory.personnelDao();
    private ConnexionDAO connexionDAO = DaoFactory.connexionDAO();
    private LoginMgerImpl() {
        
    }
 
    public static LoginMgerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LoginMgerImpl();
        }
        return SINGLETON;
    }
   
	@Override
	public Personnel ajoutPersonnel(Personnel newPersonnel) throws BLLException {
		
		return null;
	}

	@Override
	public void updatePersonnel(Personnel personnel) throws BLLException {
		
	}

	@Override
	public void removePersonnel(Personnel personnel) throws BLLException {
		
	}

	@Override
	public List<Personnel> toutLePersonnel() {
		
		List<Personnel> personnels = null;
		try{
			personnels = personnelDAO.selectALL();
		}
		catch(DaoException e){
			throw new BLLException("Error getting personnels", e);
		}
		return personnels;
	}

	@Override
	public void reinitialiserMDP(Personnel personnel) throws BLLException {
		
	}
    
    
}
