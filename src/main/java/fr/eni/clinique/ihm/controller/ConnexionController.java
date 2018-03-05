package fr.eni.clinique.ihm.controller;



import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class ConnexionController {
	
	private ConnexionModel model;
    private LoginMger loginManager = ManagerFactory.loginMger();
    
    public ConnexionController(ConnexionModel model) {
        super();
        this.model = model;
       try {
		this.init();
	} catch (BLLException | DaoException e) {
		e.printStackTrace();
	}
    }
    
    public void init() throws BLLException, DaoException {

        List<Personnel> personnels = loginManager.toutLePersonnel();
        model.loadPersonnels(personnels);
        
        List<Animal> animaux = loginManager.tousLesAnimaux();
        model.loadAnimaux(animaux);
        
        List<Client> clients = loginManager.tousLesClients();
        model.loadClients(clients);
        
    }
    
	public void deletePersonnel(Personnel personnel) throws BLLException{
	
		if(personnel.getCodePers() != null){
			loginManager.removePersonnel(personnel);
			model.removePersonnel(personnel.getCodePers());
		}
		
		
	}


}
