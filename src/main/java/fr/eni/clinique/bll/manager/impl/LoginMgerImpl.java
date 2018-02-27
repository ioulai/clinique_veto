package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class LoginMgerImpl implements LoginMger{
	private static LoginMgerImpl SINGLETON;
	private PersonnelDAO personnelDAO = DaoFactory.personnelDao();
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

	@Override
	public void updatePersonnel(Personnel personnel) throws BLLException {
		
	}

	@Override
	public void removePersonnel(Personnel personnel) throws BLLException {
		
	}

	@Override
	public List<Personnel> toutLePersonnel() throws DaoException {
		List<Personnel> personnels = null;
		personnels = personnelDAO.selectALL();
		return personnels;
	}

	@Override
	public void reinitialiserMDP(Personnel personnel) throws BLLException {
		
	}
    
    
}
