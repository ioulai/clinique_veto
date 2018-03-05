package fr.eni.clinique.ihm.model;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Animal;

import fr.eni.clinique.bll.exception.BLLException;


import fr.eni.clinique.bo.Personnel;

public class ConnexionModel extends Observable {
	private TableModelPerso tableModel;
	private TableModelAnimal tableModelAnimal;
	 public ConnexionModel() {
	        super();
	    }
//Personnel
	public void loadPersonnels(List<Personnel> personnels) {
		tableModel = new TableModelPerso(personnels);		
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

	public TableModelPerso getTableModel(){
		return tableModel;
	}
	
	
	///Animaux 
	public void loadAnimaux(List<Animal> animaux) {
	tableModelAnimal = new TableModelAnimal(animaux);		
	}
	
	public void addAnimal(Animal animal){
		tableModelAnimal.addAnimal(animal);
		setChanged();
        notifyObservers();
        clearChanged();
	}
	
	public void removeAnimal(int index){
		tableModelAnimal.removeAnimal(index);
	}

	public TableModelAnimal getTableModelAnimal(){
		return tableModelAnimal;
	}
}
