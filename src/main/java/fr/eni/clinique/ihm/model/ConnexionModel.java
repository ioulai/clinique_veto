package fr.eni.clinique.ihm.model;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bll.exception.BLLException;


import fr.eni.clinique.bo.Personnel;

public class ConnexionModel extends Observable {
	private TableModelPerso tableModelPerso;
	private TableModelAnimal tableModelAnimal;
	private TableModelClient tableModelClient;
	
	 public ConnexionModel() {
	        super();
	    }
//Personnel
	public void loadPersonnels(List<Personnel> personnels) {
		tableModelPerso = new TableModelPerso(personnels);		
	}
	
	public void addPersonnel(Personnel personnel){
		tableModelPerso.addPersonnel(personnel);
		setChanged();
        notifyObservers();
        clearChanged();
	}
	
	public void removePersonnel(int index) throws BLLException{		
		tableModelPerso.removePersonnel(index);				
	}

	public TableModelPerso getTableModel(){
		return tableModelPerso;
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
	
	///Clients
	public TableModelClient getTableModelClient(){
		return tableModelClient;
	}
	
	public void loadClients(List<Client> clients) {
		tableModelClient = new TableModelClient(clients);		
	}
	public void addClient(Client c){
		tableModelClient.addClient(c);
		setChanged();
        notifyObservers();
        clearChanged();
	}
}
