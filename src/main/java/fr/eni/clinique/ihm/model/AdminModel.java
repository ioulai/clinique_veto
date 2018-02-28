package fr.eni.clinique.ihm.model;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public class AdminModel {
	
    private TableModel tableModel; 
   
	 public AdminModel() {
	        super();
	    }

	public void loadPersonnels(List<Personnel> personnels) {
		 tableModel = new TableModel(personnels);
	}

	public void pageAccueil() {
		
	}
	   public TableModel getTableModel() {
	        return tableModel;
	    }

}
