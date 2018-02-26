package fr.eni.clinique.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.Rdv;

public class Agenda {
	
	private Integer codeVeto;
	private Date dateRDV;
	private Integer codeAnimal;
	private List<Rdv> lesRdv = new ArrayList<Rdv>();
	
	
	public final List<Rdv> getRdvAgenda() {
		return lesRdv;
	}
	
	public void ajoutRdv(int codeVeto, Date dateRDV, int codeAnimal){
		lesRdv.add(new Rdv(codeVeto,dateRDV, codeAnimal));
	}
	
	public final Rdv getRdv(int index) {
		return lesRdv.get(index);
	}
	
	public void removeRdv(int index) {
		lesRdv.remove(index);
	}
	
	public void updateRdv(int CodeVeto, Date newDateRDV, int newCodeAnimal) {
		getRdv(CodeVeto).setDateRDV(newDateRDV);
		getRdv(CodeVeto).setCodeAnimal(newCodeAnimal);
	}
	
	public Agenda() {
		super();
	}

	public Agenda(Integer codeVeto, Date dateRDV, Integer codeAnimal) {
		super();
		this.codeVeto = codeVeto;
		this.dateRDV = dateRDV;
		this.codeAnimal = codeAnimal;
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

	@Override
	public String toString() {
        return new StringBuilder()
		.append("Agenda [codeVeto=")
		.append(codeVeto)
		.append(", dateRDV=")
		.append(dateRDV)
		.toString();
	}

	
	
}
