package fr.eni.clinique.ihm.controller;



import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class ConnexionController {
	
	private ConnexionModel model;
    private LoginMger loginManager = ManagerFactory.loginMger();
    
    public ConnexionController(ConnexionModel model) {
        super();
        this.model = model;
    }
    
    public void init() throws BLLException, DaoException {

        List<Personnel> personnels = loginManager.toutLePersonnel();

        model.loadPersonnels(personnels);
    }
    
	public boolean seConnecter(String nom, String motPasse) {
		
		return true;
		
		
	}


}
