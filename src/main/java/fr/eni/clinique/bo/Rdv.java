package fr.eni.clinique.bo;

import java.util.Date;

public class Rdv {
	
	
	private String dateRDV;	
	private Personnel veterinaire;
	private Animal animal;
	/**
	 * @param dateRDV
	 * @param veterinaire
	 * @param animal
	 */
	public Rdv(String dateRDV, Personnel veterinaire, Animal animal) {
		super();
		this.dateRDV = dateRDV;
		this.veterinaire = veterinaire;
		this.animal = animal;
	}
	/**
	 * @return the dateRDV
	 */
	public String getDateRDV() {
		return dateRDV;
	}
	/**
	 * @param dateRDV the dateRDV to set
	 */
	public void setDateRDV(String dateRDV) {
		this.dateRDV = dateRDV;
	}
	/**
	 * @return the veterinaire
	 */
	public Personnel getVeterinaire() {
		return veterinaire;
	}
	/**
	 * @param veterinaire the veterinaire to set
	 */
	public void setVeterinaire(Personnel veterinaire) {
		this.veterinaire = veterinaire;
	}
	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}
	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
}
