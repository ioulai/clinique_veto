package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;


public class GestionPerso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private  ConnexionModel connexionModel;
	private ConnexionController connexionController ;

	public GestionPerso() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setResizable(true);
		 connexionModel = new ConnexionModel();
		 connexionController = new ConnexionController(connexionModel);
	
		tableau = new JTable(connexionModel.getTableModel());
		setTitle("Gestion du personnel");
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		JPanel boutons = new JPanel();
		boutons.add(new JButton(new AddAction()));
		boutons.add(new JButton(new RemoveAction()));
		 getContentPane().add(boutons, BorderLayout.SOUTH);
		 pack();
	}

	private class AddAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AddAction() {
			super("Ajouter");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Personnel personnel = null;
			connexionModel.addPersonnel(personnel);

		}
	}

	private class RemoveAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private RemoveAction() {
			super("Supprimer");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] selection = tableau.getSelectedRows();

			for (int i = selection.length - 1; i >= 0; i--) {
				connexionModel.removePersonnel(selection[i]);

			}
		}	
}

	
}