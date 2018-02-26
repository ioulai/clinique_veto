package fr.eni.clinique.bll.manager;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;

public interface LoginMger {

	//Personnel
	Personnel ajoutPersonnel(Personnel newPersonnel) throws BLLException;
	void updatePersonnel(Personnel personnel) throws BLLException;
	 void removeArticle(Personnel personnel) throws BLLException;
	 
	 
	 
	 
}
