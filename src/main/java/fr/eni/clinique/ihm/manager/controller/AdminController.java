package fr.eni.clinique.ihm.manager.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.ihm.manager.model.AdminModel;

public class AdminController {
	private AdminModel model;
    private LoginMger loginManager = ManagerFactory.loginMger();
    
    public AdminController(AdminModel model) {
        super();
        this.model = model;
    }
    
    public void init() throws BLLException, DaoException {

        List<Personnel> personnels = loginManager.toutLePersonnel();

        model.loadPersonnels(personnels);
    }
    
	public void seConnecter() {
		
	}
}
