package fr.eni.clinique.dal.dao;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelDAO{
	List<Personnel> selectAll();
	
}
