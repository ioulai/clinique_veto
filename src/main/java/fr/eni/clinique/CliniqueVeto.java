package fr.eni.clinique;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.CliniqueController;
import fr.eni.clinique.ihm.model.CliniqueModel;
import fr.eni.clinique.ihm.screen.ConnexionScreen;

public class CliniqueVeto {

	public static void main(String[] args) {
		 try {

	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    CliniqueModel cliniqueModel = new CliniqueModel();
	                    CliniqueController cliniqueController = new CliniqueController(cliniqueModel);
	                    ConnexionScreen screen = new ConnexionScreen(AppConstants.APP_NAME,cliniqueController, cliniqueModel);
	                }
	            });
	        } catch (Exception e) {
	            throw new TechnicalException("Erreur Technique", e);
	        }
	}

}
