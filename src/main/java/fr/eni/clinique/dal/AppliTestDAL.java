package fr.eni.clinique.dal;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.CliniqueController;
import fr.eni.clinique.ihm.model.CliniqueModel;
import fr.eni.clinique.ihm.screen.ConnexionScreen;

public class AppliTestDAL {

	public static void main(String[] args) {
		 try {
	            
	            // Appliquer le Look And Feel Windows
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    
	                    // Create A Catalog Model.
	                    CliniqueModel cliniqueModel = new CliniqueModel();
	                    
	                    // Create A Catalog controller
	                    CliniqueController cliniqueController = new CliniqueController(cliniqueModel);
	                    
	                    // Create A Catalog View
	                    ConnexionScreen screen = new ConnexionScreen(AppConstants.APP_NAME, cliniqueController, cliniqueModel);
	         
	                }
	            });
	        } catch (Exception e) {
	            throw new TechnicalException("Erreur Technique", e);
	        }
		
	}

}
