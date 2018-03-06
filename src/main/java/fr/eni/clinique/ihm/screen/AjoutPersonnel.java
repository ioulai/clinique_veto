package fr.eni.clinique.ihm.screen;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class AjoutPersonnel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JLabel nomLabel;
	private JLabel motPasseLabel;
	private JLabel roleLabel;
	private JLabel archiveLabel;

	private JTextField nomTxt;
	private JTextField motPasseTxt;
	private JTextField roleTxt;
	private JTextField archiveTxt;

	private Font defaultLabelFont = new Font("Arial", Font.BOLD, 14);
	private Font defaultFont = new Font("Arial", Font.PLAIN, 14);

	public AjoutPersonnel(ConnexionController connexionController, ConnexionModel connexionModel) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setResizable(false);
		setTitle("Ajout personnel");
		setUp() ;

	}

	private void setUp() {
		mainPanel = new JPanel();
		mainPanel.setOpaque(true);
		setVisible(true);
		setLocationRelativeTo(null);

		setContentPane(mainPanel);

		mainPanel.setLayout(new GridBagLayout());
		
		nomLabel = createLabel("Nom : ");
		nomTxt = createTextField(null, "Entrez le Nom");
		motPasseLabel = createLabel("Mot de passe : ");
		motPasseTxt = createTextField(null, "Entrez le Mot de passe");
		roleLabel = createLabel("Rôle (Adm / Sec/ Vet) :");
		roleTxt = createTextField(null, "Entrez le Rôle ");
		archiveLabel = createLabel("Archive : ");
		archiveTxt = createTextField(null, "Archiver ?");
		
		 // Creation de la grille et placement des composants sur la grille
		GridBagConstraints gridBagConstraints = createGridBagConstraints();
		
		addComponentOnGrid(mainPanel, nomLabel, gridBagConstraints, 1, 1, 0.15);
		addComponentOnGrid(mainPanel, nomTxt, gridBagConstraints, 2, 1, 0.85);
		addComponentOnGrid(mainPanel, motPasseLabel, gridBagConstraints, 1, 2, 0.15);
		addComponentOnGrid(mainPanel, motPasseTxt, gridBagConstraints, 2, 2, 0.85);
		addComponentOnGrid(mainPanel, roleLabel, gridBagConstraints, 1, 3, 0.15);
		addComponentOnGrid(mainPanel, roleTxt, gridBagConstraints, 2, 3, 0.85);
		addComponentOnGrid(mainPanel, archiveLabel, gridBagConstraints, 1, 4, 0.15);
		addComponentOnGrid(mainPanel, archiveTxt, gridBagConstraints, 2, 4, 0.85);
		

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

	private void addComponentOnGrid(JPanel panel, JComponent component, GridBagConstraints gridBagConstraints,
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
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		return gridBagConstraints;
	}

}
