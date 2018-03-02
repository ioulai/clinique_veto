package fr.eni.clinique;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.AdminController;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.AdminModel;
import fr.eni.clinique.ihm.model.ConnexionModel;
import fr.eni.clinique.ihm.screen.ConnexionScreen;

public class CliniqueVeto {

	public static void main(String[] args) {
		 try {

	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                   ConnexionModel connexionModel = new ConnexionModel();
	                   
	                    ConnexionController connexionController = new ConnexionController(connexionModel);
						ConnexionScreen screen = new ConnexionScreen(AppConstants.APP_NAME, connexionController, connexionModel);
	                }
	            });
	        } catch (Exception e) {
	            throw new TechnicalException("Erreur Technique", e);
	        }
	}

}
