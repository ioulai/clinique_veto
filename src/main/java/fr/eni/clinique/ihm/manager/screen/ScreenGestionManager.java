package fr.eni.clinique.ihm.manager.screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.ihm.manager.controller.AdminController;
import fr.eni.clinique.ihm.manager.model.AdminModel;
public class ScreenGestionManager extends JFrame {

 	/**
	 * 
	 */
	private static final long serialVersionUID = -5384422349271584894L;
	
	private JPanel mainPanel;
	private JComboBox comboBox;
	
    private JButton previousButton;
    private JButton nextButton;
    private JButton validateButton;
    private JButton deleteButton;
    private JButton newButton;
    
private AdminController controller;
private AdminModel model;

public ScreenGestionManager (AdminController controller, AdminModel model) {

    this.model = model;
    this.controller = controller;
    
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    setSize(600, 300 ); 
    setResizable(false); 
    setTitle("Gestion du Personnel");
    try {
        setUp(); 
        controller.init();

    } catch (Exception e) {
        showFailureMessage(e.getMessage());
}
}
private void showFailureMessage(String message) {
    JOptionPane.showMessageDialog(ScreenGestionManager.this, message, "Erreur d'affichage", JOptionPane.ERROR_MESSAGE);
}
private void setUp() {

    mainPanel = new JPanel();
    mainPanel.setOpaque(true);
    setVisible(true);
    setLocationRelativeTo(null);

    setContentPane(mainPanel);
    
    mainPanel.setLayout(new GridBagLayout());
    
    JLabel nomLbl = createLabel("Nom");
    JTextField nomTxt = new JTextField();
    
    JLabel mdpLbl = createLabel("Mot de Passe");
    JTextField mdpTxt = new JTextField();
    
    GridBagConstraints gridBagConstraints = createGridBagConstraints();
    addComponentOnGrid(mainPanel, nomLbl, gridBagConstraints, 1, 1, 0.15);
    addComponentOnGrid(mainPanel, nomTxt, gridBagConstraints, 2, 1, 0.85);
    addComponentOnGrid(mainPanel, mdpLbl, gridBagConstraints, 1, 2, 0.15);
    addComponentOnGrid(mainPanel, mdpTxt, gridBagConstraints, 2, 2, 0.85);
    addComponentOnGrid(mainPanel, createButtonBar(), gridBagConstraints, 2, 3, 1);
}


private void addComponentOnGrid(JPanel panel,JComponent component,GridBagConstraints gridBagConstraints,int gridX, int gridY, double weightX) {
    gridBagConstraints.gridx = gridX; 
    gridBagConstraints.gridy = gridY;
    gridBagConstraints.weightx = weightX; 

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
    return label;
}

private JPanel createButtonBar() {

    JPanel panel = new JPanel();
    panel.setOpaque(true);
    panel.setLayout(new GridBagLayout());

    GridBagConstraints gridBagConstraints = new GridBagConstraints();

   previousButton = new JButton();
    previousButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Back24.gif")));
    previousButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });

    nextButton = new JButton();
    nextButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Forward24.gif")));
    nextButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });

    validateButton = new JButton();
    validateButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Save24.gif")));
    validateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });

    deleteButton = new JButton();
    deleteButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Delete24.gif")));
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
    });

    newButton = new JButton();
    newButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/New24.gif")));
    newButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });

    addComponentOnGrid(panel, previousButton, gridBagConstraints, 1, 1, 1);
    addComponentOnGrid(panel, nextButton, gridBagConstraints, 2, 1, 1);
    addComponentOnGrid(panel, validateButton, gridBagConstraints, 3, 1, 1);
    addComponentOnGrid(panel, deleteButton, gridBagConstraints, 4, 1, 1);
    addComponentOnGrid(panel, newButton, gridBagConstraints, 5, 1, 1);

    return panel;
}


}
