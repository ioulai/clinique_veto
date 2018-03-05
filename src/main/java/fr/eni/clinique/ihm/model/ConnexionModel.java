package fr.eni.clinique.ihm.model;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.controller.ConnexionController;

public class ConnexionModel extends Observable {
	private TableModel tableModel;
	private int currentIndex;
	 public ConnexionModel() {
	        super();
	    }

	public void loadPersonnels(List<Personnel> personnels) {
		tableModel = new TableModel(personnels);		
	}
	
	public void addPersonnel(Personnel personnel){
		tableModel.addPersonnel(personnel);
		setChanged();
        notifyObservers();
        clearChanged();
	}
	
	public void removePersonnel(int index) throws BLLException{		
		tableModel.removePersonnel(index);				
	}

	public TableModel getTableModel(){
		return tableModel;
	}
	 
	 
}
