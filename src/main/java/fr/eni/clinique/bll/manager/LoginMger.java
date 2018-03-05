package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Personnel;

public interface LoginMger {

	//Personnel
	void ajoutPersonnel(Personnel newPersonnel) throws BLLException;
	
	void updatePersonnel(Personnel personnel) throws BLLException;
	
	void removePersonnel(Personnel personnel) throws BLLException;
	
	List<Personnel> toutLePersonnel() throws  BLLException;
	
	void reinitialiserMDP(Personnel personnel)throws BLLException;

	List<Animal> tousLesAnimaux() throws  BLLException;
	 
}
