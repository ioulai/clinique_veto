package fr.eni.clinique.ihm.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.ihm.controller.AdminController;
import fr.eni.clinique.ihm.model.AdminModel;

public class ConnexionScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8873958310825089378L;

	 	private JPanel mainPanel;
	    private JLabel nomLbl;
	    public JTextField nomTxt; 
	    private JLabel mdpLbl; 
	    public JPasswordField mdpTxt; 
	
	    private JButton validerConnexion;
	    
	    private Font defaultLabelFont = new Font("Arial", Font.BOLD, 14); 
	   
	    public ConnexionScreen(String titre,AdminController adminController, AdminModel adminModel) {

	        setDefaultCloseOperation(EXIT_ON_CLOSE); // Action de fermeture
	        setSize(300, 200); // Taille de la fenetre
	        setResizable(false); // Fenetre pas redimensionnable
	        setTitle(titre);
	        try {
	            setUp(); 
	            adminController.init();

	        } catch (Exception e) {
	            showFailureMessage(e.getMessage());
	        }
	    }
	    
	    private void showFailureMessage(String message) {
	        JOptionPane.showMessageDialog(ConnexionScreen.this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	    }
	    
		private void showSuccessMessage(String message) {
	        JOptionPane.showMessageDialog(ConnexionScreen.this,message);
	    }
	    
	    private void setUp() {

	        mainPanel = new JPanel();
	        mainPanel.setOpaque(true);
	        setVisible(true);
	        setLocationRelativeTo(null);

	        setContentPane(mainPanel);
	        
	        mainPanel.setLayout(new GridBagLayout());
	        
	        nomLbl = createLabel("Nom");
	        nomTxt = new JTextField();
	        
	        mdpLbl = createLabel("Mot de Passe");
	        mdpTxt = new JPasswordField();
	        
	        JPanel panel = new JPanel();
	        panel.setOpaque(true);
	        panel.setLayout(new GridBagLayout());

	        validerConnexion = new JButton("VALIDER");
	        validerConnexion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(nomTxt.getText() =="" || mdpTxt.getPassword().toString()=="" ){
	            		showFailureMessage("Veuillez saisir tous les champs");	
	            	}
	            	else if(nomTxt.getText()=="test" && mdpTxt.getPassword().toString()=="1234"){
	            		showSuccessMessage("Authentification réussie");
	            		GestionPersonnel frame = new GestionPersonnel();
						frame.setVisible(true);
	            	}
					
				}
			});
	        GridBagConstraints gridBagConstraints = createGridBagConstraints();
	        addComponentOnGrid(mainPanel, nomLbl, gridBagConstraints, 1, 1, 0.15);
	        addComponentOnGrid(mainPanel, nomTxt, gridBagConstraints, 2, 1, 0.85);
	        addComponentOnGrid(mainPanel, mdpLbl, gridBagConstraints, 1, 2, 0.15);
	        addComponentOnGrid(mainPanel, mdpTxt, gridBagConstraints, 2, 2, 0.85);
	        addComponentOnGrid(mainPanel, validerConnexion, gridBagConstraints, 2, 3, 1);
	    }
	    
	    
	    private void addComponentOnGrid(
	            JPanel panel,
	            JComponent component,
	            GridBagConstraints gridBagConstraints,
	            int gridX, int gridY, double weightX) {

	        gridBagConstraints.gridx = gridX; // Place on X Axis
	        gridBagConstraints.gridy = gridY; // Place on Y Axis
	        gridBagConstraints.weightx = weightX; // Weight on X Axis

	        panel.add(component, gridBagConstraints);
	    }
	    
	    private GridBagConstraints createGridBagConstraints() {

	        GridBagConstraints gridBagConstraints = new GridBagConstraints();
	        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; 
	        gridBagConstraints.insets = new Insets(5,5,5,5);

	        return gridBagConstraints; 
	    }
	    private JLabel createLabel(String text) {
	        JLabel label = new JLabel(text);
	        label.setFont(defaultLabelFont);

	        return label;
	    }
	    
}
	    
