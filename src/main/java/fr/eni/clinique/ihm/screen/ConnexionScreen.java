package fr.eni.clinique.ihm.screen;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
	    private JLabel nomLbl; // Label Reference
	    private JTextField nomTxt; // TextField Reference
	    private JLabel mdpLbl; // Label de designation
	    private JTextField mdpTxt; // TextField de designation
	
	    private JButton validerConnexion;
	    private Font defaultLabelFont = new Font("Arial", Font.BOLD, 14); // Font
        // Label
	    private Font defaultFont = new Font("Arial", Font.PLAIN, 14); // Other

	    private CliniqueController controller;
	    private CliniqueModel model;
	    
	    public ConnexionScreen(String title, CliniqueController controller, CliniqueModel model) {

	        this.model = model;
	        this.controller = controller;
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE); // Action de fermeture
	        setSize(600, 500); // Taille de la fenetre
	        setResizable(false); // Fenetre pas redimensionnable
	        setTitle(title); // Titre de la fenetre
	        
	        try {
	            setUp(); // Construct Components.

	            // Fire Initialisation Event.
	            controller.init();

	        } catch (Exception e) {
	            showFailureMessage(e.getMessage());
	        }
	    }
	    
	    private void showFailureMessage(String message) {
	        JOptionPane.showMessageDialog(ConnexionScreen.this, message, "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    private void showSuccessMessage(String message) {
	        JOptionPane.showMessageDialog(ConnexionScreen.this, message, "Authentification reussie",1);
	    }
	    private void setUp() {

	        // Main Panel
	        mainPanel = new JPanel();
	        mainPanel.setOpaque(true);
	        setVisible(true);
	        setLocationRelativeTo(null);

	        setContentPane(mainPanel);
	        // Use GridBagLayout on main Panel
	        mainPanel.setLayout(new GridBagLayout());
	        // Creation des composants
	        nomLbl = createLabel("Nom");
	        nomTxt = createTextField(null,null);
	        mdpLbl = createLabel("Mot de Passe");
	        mdpTxt = createTextField(null, " ");
	        GridBagConstraints gridBagConstraints = createGridBagConstraints();

	        addComponentOnGrid(mainPanel, nomLbl, gridBagConstraints, 1, 1, 0.15);
	        addComponentOnGrid(mainPanel, nomTxt, gridBagConstraints, 2, 1, 0.85);
	        addComponentOnGrid(mainPanel, mdpLbl, gridBagConstraints, 1, 2, 0.15);
	        addComponentOnGrid(mainPanel, mdpTxt, gridBagConstraints, 2, 2, 0.85);
	 
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
	        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; // Redimensionne
	                                                                 // horizontalement
	        gridBagConstraints.insets = new Insets(5,5,5,5);

	        return gridBagConstraints; 
	    }
	    private JLabel createLabel(String text) {

	        JLabel label = new JLabel(text);
	        label.setFont(defaultLabelFont);

	        return label;
	    }
	    
	    private JTextField createTextField(String text, String tooltip) {

	        JTextField textField = new JTextField(text);
	        textField.setFont(defaultFont);
	        textField.setToolTipText(tooltip);
	        return textField;
	    }

}
	    
