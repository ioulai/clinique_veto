package fr.eni.clinique.bll;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;


import fr.eni.clinique.common.exception.TechnicalException;



public class AppliTestBLL {

	public static void main(String[] args) {
		try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                	
                  //  AdminModel adminModel = new AdminModel();
                    
                   // AdminController adminController = new AdminController(adminModel);
        
                   // GestionPersonnel screen = new GestionPersonnel(adminController, adminModel);
                }
            });
        } catch (Exception e) {
            throw new TechnicalException("Erreur Technique", e);
        }
	}

}
