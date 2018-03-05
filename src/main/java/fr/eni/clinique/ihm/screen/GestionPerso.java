package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class GestionPerso extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private ConnexionModel connexionModel;
	private ConnexionController connexionController;

	public GestionPerso(ConnexionModel connexionModel, ConnexionController connexionController) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setResizable(true);
		tableau = new JTable(connexionModel.getTableModel());
		setTitle("Gestion du personnel");
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		((AbstractTableModel)tableau.getModel()).fireTableDataChanged();

	}

}
