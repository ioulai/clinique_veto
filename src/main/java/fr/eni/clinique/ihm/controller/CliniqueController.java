package fr.eni.clinique.ihm.controller;



import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.ihm.model.CliniqueModel;

public class CliniqueController {
	
	private CliniqueModel model;
	
    private LoginMger loginManager = ManagerFactory.loginMger();
    
    public CliniqueController(CliniqueModel model) {
        super();
        this.model = model;
    }
    
    public void init() throws BLLException {

        //List<Personnel> personnels = loginManager.getPersonnel();

       // model.loadPersonnels(personnels);
    }

}
