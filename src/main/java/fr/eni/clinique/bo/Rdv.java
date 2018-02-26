package fr.eni.clinique.bo;

import java.util.Date;

public class Rdv {
	
	protected Integer codeVeto;
	protected Date dateRDV;
	protected Integer codeAnimal;
	
	
	
	
	Rdv(Integer codeVeto, Date dateRDV, Integer codeAnimal) {
		super();
		setCodeVeto(codeVeto);
		setDateRDV(dateRDV);
		setCodeAnimal(codeAnimal);
	}
	
	
	public Integer getCodeVeto() {
		return codeVeto;
	}
	public void setCodeVeto(Integer codeVeto) {
		this.codeVeto = codeVeto;
	}
	public Date getDateRDV() {
		return dateRDV;
	}
	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}
	public Integer getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(Integer codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	
	
}
