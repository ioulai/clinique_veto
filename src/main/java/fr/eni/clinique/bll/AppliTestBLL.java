package fr.eni.clinique.bll;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

<<<<<<< HEAD
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;
import fr.eni.clinique.ihm.screen.GestionPerso;
=======

import fr.eni.clinique.common.exception.TechnicalException;


>>>>>>> 14e620d76c6b618738a2c742086496a69dee414d

public class AppliTestBLL {

	public static void main(String[] args) {
		try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                	
<<<<<<< HEAD
                	ConnexionModel adminModel = new ConnexionModel();
                    
                    ConnexionController adminController = new ConnexionController(adminModel);
        
                    GestionPerso screen = new GestionPerso();
=======
                  //  AdminModel adminModel = new AdminModel();
                    
                   // AdminController adminController = new AdminController(adminModel);
        
                   // GestionPersonnel screen = new GestionPersonnel(adminController, adminModel);
>>>>>>> 14e620d76c6b618738a2c742086496a69dee414d
                }
            });
        } catch (Exception e) {
            throw new TechnicalException("Erreur Technique", e);
        }
	}

}
