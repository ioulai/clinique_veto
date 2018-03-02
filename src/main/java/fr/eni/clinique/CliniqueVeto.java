package fr.eni.clinique;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.AdminController;
import fr.eni.clinique.ihm.model.AdminModel;
import fr.eni.clinique.ihm.screen.ConnexionScreen;

public class CliniqueVeto {

	public static void main(String[] args) {
		 try {

	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    AdminModel adminModel = new AdminModel();
	                    AdminController adminController = new AdminController(adminModel);
						ConnexionScreen screen = new ConnexionScreen(AppConstants.APP_NAME, adminController, adminModel);
	                }
	            });
	        } catch (Exception e) {
	            throw new TechnicalException("Erreur Technique", e);
	        }
	}

}
