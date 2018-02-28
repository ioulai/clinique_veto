package fr.eni.clinique.ihm.screen;

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
import javax.swing.JTextField;

import fr.eni.clinique.ihm.controller.CliniqueController;
import fr.eni.clinique.ihm.model.CliniqueModel;

public class ConnexionScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8873958310825089378L;

	 	private JPanel mainPanel;
	    private JLabel nomLbl;
	    private JTextField nomTxt; 
	    private JLabel mdpLbl; 
	    private JTextField mdpTxt; 
	
	    private JButton validerConnexion;
	    
	    private Font defaultLabelFont = new Font("Arial", Font.BOLD, 14); 

	    private CliniqueController controller;
	    private CliniqueModel model;
	    
	    public ConnexionScreen(String titre,CliniqueController controller, CliniqueModel model) {

	        this.model = model;
	        this.controller = controller;
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE); // Action de fermeture
	        setSize(300, 200); // Taille de la fenetre
	        setResizable(false); // Fenetre pas redimensionnable
	        setTitle(titre);
	        try {
	            setUp(); 
	            controller.init();

	        } catch (Exception e) {
	            showFailureMessage(e.getMessage());
	        }
	    }
	    
	    private void showFailureMessage(String message) {
	        JOptionPane.showMessageDialog(ConnexionScreen.this, message, "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    private void showSuccessMessage() {
	        JOptionPane.showMessageDialog(ConnexionScreen.this,"Authentification reussie");
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
	        mdpTxt = new JTextField();
	        
	        GridBagConstraints gridBagConstraints = createGridBagConstraints();
	        addComponentOnGrid(mainPanel, nomLbl, gridBagConstraints, 1, 1, 0.15);
	        addComponentOnGrid(mainPanel, nomTxt, gridBagConstraints, 2, 1, 0.85);
	        addComponentOnGrid(mainPanel, mdpLbl, gridBagConstraints, 1, 2, 0.15);
	        addComponentOnGrid(mainPanel, mdpTxt, gridBagConstraints, 2, 2, 0.85);
	        addComponentOnGrid(mainPanel, createButtonBar(), gridBagConstraints, 2, 3, 1);
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
	    
	    private JPanel createButtonBar() {
	    	
	        JPanel panel = new JPanel();
	        panel.setOpaque(true);
	        panel.setLayout(new GridBagLayout());

	        GridBagConstraints gridBagConstraints = new GridBagConstraints();

	        validerConnexion = new JButton("OK");
	        validerConnexion.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                seConnecter();
	            }
	        });
	       
	        addComponentOnGrid(panel, validerConnexion, gridBagConstraints, 2, 1, 1);
	       
	        return panel;
	    }
	    private void seConnecter() {
	        try {
	            if (nomTxt == null) {
	                showFailureMessage("Veuillez saisir un nom !");
	            } 
	            else if(mdpTxt == null) {
	            	 showFailureMessage("Veuillez saisir un mot de passe !");
	            }
	            else {
	                controller.seConnecter();
	                model.pageAccueil();
	            }
	        } catch (Exception e) {
	            showFailureMessage(e.getMessage());
	        }
	    }
	    
	    
}
	    
