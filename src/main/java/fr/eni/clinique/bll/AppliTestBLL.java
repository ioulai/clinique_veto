package fr.eni.clinique.bll;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.bll.manager.ihm.GestionPersonnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.CliniqueController;
import fr.eni.clinique.ihm.model.CliniqueModel;

public class AppliTestBLL {

	public static void main(String[] args) {
		try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                	
                    CliniqueModel cliniqueModel = new CliniqueModel();
                    
                    CliniqueController cliniqueController = new CliniqueController(cliniqueModel);
        
                    GestionPersonnel screen = new GestionPersonnel(cliniqueController, cliniqueModel);
                }
            });
        } catch (Exception e) {
            throw new TechnicalException("Erreur Technique", e);
        }
	}

}
