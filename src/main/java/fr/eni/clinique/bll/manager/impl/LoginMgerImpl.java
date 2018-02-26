package fr.eni.clinique.bll.manager.impl;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.impl.ConnexionDAO;

public class LoginMgerImpl implements LoginMger{
 
	private static LoginMgerImpl SINGLETON;
 
    private ConnexionDAO connexionDAO = DaoFactory.connexionDAO();

    private LoginMgerImpl() {
        
    }
 
    public static LoginMgerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LoginMgerImpl();
        }
        return SINGLETON;
    }
   // List<Personnel> getPersonnel() throws BLLException;
    
    
	@Override
	public Personnel ajoutPersonnel(Personnel newPersonnel) throws BLLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePersonnel(Personnel personnel) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArticle(Personnel personnel) throws BLLException {
		// TODO Auto-generated method stub
		
	}
    
    
}
