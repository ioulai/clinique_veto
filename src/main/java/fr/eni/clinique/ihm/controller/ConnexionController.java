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
	
	private ConnexionModel connexionModel;
    private LoginMger loginManager = ManagerFactory.loginMger();
    
    public ConnexionController(ConnexionModel connexionModel) {
        super();
        this.connexionModel = connexionModel;
       try {
		this.init();
	} catch (BLLException | DaoException e) {
		e.printStackTrace();
	}
    }
    
    public void init() throws BLLException, DaoException {

        List<Personnel> personnels = loginManager.toutLePersonnel();
        connexionModel.loadPersonnels(personnels);
        
        List<Animal> animaux = loginManager.tousLesAnimaux();
        connexionModel.loadAnimaux(animaux);
        
        List<Client> clients = loginManager.tousLesClients();
<<<<<<< HEAD
        connexionModel.loadClients(clients);
        
=======
        model.loadClients(clients);
>>>>>>> c22ca9670422402cf3bfe74b5499c8ba33d03987
    }
    
	public void deletePersonnel(Personnel personnel) throws BLLException{
	
		if(personnel.getCodePers() != null){
			loginManager.removePersonnel(personnel);
			connexionModel.removePersonnel(personnel.getCodePers());
		}		
	}
	
	public void AjoutPersonnel(Personnel personnel) throws BLLException{
		if(personnel.getCodePers() == null){
			loginManager.ajoutPersonnel(personnel);			
		}
		connexionModel.addPersonnel(personnel);		
	}
	
	public void AjoutClient(Client c) throws BLLException{
		if(Client.getCodeClient() == null){
			loginManager.ajoutClient(c);			
		}
		model.addClient(c);		
	}
}
