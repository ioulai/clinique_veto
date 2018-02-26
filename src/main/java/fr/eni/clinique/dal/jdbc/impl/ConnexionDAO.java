package fr.eni.clinique.dal.jdbc.impl;

import fr.eni.clinique.dal.exception.DaoException;

public interface ConnexionDAO<P, ID> {

	void connexion(P element,ID id) throws DaoException;

}
