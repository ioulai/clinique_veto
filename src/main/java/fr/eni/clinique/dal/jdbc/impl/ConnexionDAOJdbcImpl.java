package fr.eni.clinique.dal.jdbc.impl;


import java.util.List;

import fr.eni.clinique.dal.exception.DaoException;

public interface ConnexionDAOJdbcImpl<T, ID>{
  
	void insert(T element) throws DaoException;
	void update(T element) throws DaoException;
	void delete(ID id) throws DaoException;
	T selectById(ID id) throws DaoException;
	List<T> selectAll() throws DaoException;
	static ConnexionDAO getInstance() {
		return ConnexionDAOJdbcImpl.getInstance();
	}

}
