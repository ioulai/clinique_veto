package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.dao.AnimalDAO;
import fr.eni.clinique.dal.dao.ClientDAO;
import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class LoginMgerImpl implements LoginMger{
	
	private static LoginMgerImpl SINGLETON;
	private PersonnelDAO personnelDAO = DaoFactory.personnelDao();
	private AnimalDAO animalDAO = DaoFactory.animalDao();
	private ClientDAO clientDAO= DaoFactory.clientDAO();
	
    private LoginMgerImpl() {
        
    }
 
    public static LoginMgerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LoginMgerImpl();
        }
        return SINGLETON;
    }
   
	@Override
	public void ajoutPersonnel(Personnel newPersonnel) throws BLLException {

		ObjectUtil.checkNotNull(newPersonnel);
			try{
				validerPersonnel(newPersonnel);
				personnelDAO.insert(newPersonnel);
			}
			catch(DaoException e){
				throw new BLLException("Error inserting", e);
			}
		
	}
	public boolean  tryConnect(String nom, String motDePasse) throws BLLException 	{
		boolean retour = false;
		Personnel personnel = new Personnel(nom, motDePasse);
		
	try {
		retour =	personnelDAO.authenticate(personnel);
	} catch (DaoException e) {
	
		throw new BLLException("erreur de connexion",e);		
	}		
		return retour;
	}
	
	public Personnel selectById(Integer id) throws BLLException {
	
	    Personnel personnel = null;
	
	    return personnel;
	}

	private void validerPersonnel(Personnel newPersonnel) throws BLLException {
		try{
			ObjectUtil.checkNotNull(newPersonnel);
			ObjectUtil.checkNotBlank(newPersonnel.getNom());
			ObjectUtil.checkNotBlank(newPersonnel.getMotPasse());
			ObjectUtil.checkNotBlank(newPersonnel.getRole());
			ObjectUtil.checkNotNull(newPersonnel.isArchive());
			}
		catch(IllegalArgumentException e){
				throw new BLLException("Champs Manquants : ", e);
			} catch (Exception e1) {
				throw new TechnicalException("Erreur Technique", e1);
			}
	}
	private void validerClient(Client c) throws BLLException {
		try{
			
			ObjectUtil.checkNotBlank(c.getNomClient());
			ObjectUtil.checkNotBlank(c.getPrenomClient());
			ObjectUtil.checkNotBlank(c.getCodePostal());
			ObjectUtil.checkNotBlank(c.getVille());
			ObjectUtil.checkNotBlank(c.getAssurance());
			ObjectUtil.checkNotBlank(c.getAdresse1());
			ObjectUtil.checkNotBlank(c.getAdresse2());
			
			}
		catch(IllegalArgumentException e){
				throw new BLLException("Champs Manquants : ", e);
			} catch (Exception e1) {
				throw new TechnicalException("Erreur Technique", e1);
			}
	}
	@Override
	public void updatePersonnel(Personnel personnel) throws BLLException {
		
	}

	@Override
	public void removePersonnel(Personnel personnel) throws BLLException {
		try {
			personnelDAO.delete(personnel);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Personnel> toutLePersonnel() throws BLLException {
		List<Personnel> personnels = null;
		try {
			personnels = personnelDAO.selectALL();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return personnels;
	}

	@Override
	public void reinitialiserMDP(Personnel personnel) throws BLLException {
		
	}

	@Override
	public List<Animal> tousLesAnimaux() throws BLLException {
		List<Animal> animaux = null;
		try {
			animaux = animalDAO.selectALL();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return animaux;
	}

	@Override
	public List<Client> tousLesClients() throws BLLException {
		List<Client> clients = null;
		try {
			clients = clientDAO.selectALL();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public void ajoutClient(Client c) throws BLLException {
		ObjectUtil.checkNotNull(c);
		try{
			validerClient(c);
			clientDAO.insert(c);
		}
		catch(DaoException e){
			throw new BLLException("Error inserting", e);
		}
		
	}
    
    
}
