package fr.eni.clinique.dal;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.CliniqueController;
import fr.eni.clinique.ihm.model.CliniqueModel;
import fr.eni.clinique.ihm.screen.ConnexionScreen;

public class AppliTestDAL {

	public static void main(String[] args) {
		Personnel personnel = new Personnel();
		
		/* try {

	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    
	                    CliniqueModel cliniqueModel = new CliniqueModel();
	                    
	                    CliniqueController cliniqueController = new CliniqueController(cliniqueModel);
	        
	                    ConnexionScreen screen = new ConnexionScreen(cliniqueController, cliniqueModel);
	         
	                }
	            });
	        } catch (Exception e) {
	            throw new TechnicalException("Erreur Technique", e);
	        }*/
		
	}

}
