package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Personnel;


public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5339658835698597380L;
	
	private List<Personnel> personnels = new ArrayList<>();
    private final String[] entetes = { "Nom", "R�le", "MotPasse"};
	 
    public void changeArticle(int index, Personnel personnel) {
        this.personnels.set(index, personnel);
    }
    
    public void addAllArticle(List<Personnel> personnel) {
        this.personnels.addAll(personnel);
    }
    
    public void addArticle(Personnel personnel) {
        this.personnels.add(personnel);
    }
    
    public void removeArticle(int index) {
        this.personnels.remove(index);
    }
    
    public Personnel article(int index) {
        return this.personnels.get(index);
    }
    

    public TableModel(List<Personnel> personnels) {
        super();
        this.personnels = personnels;
    }

    @Override
    public int getRowCount() {
        return personnels.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    /**
     * retourne l'entete
     * 
     * @param columnIndex
     */
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return personnels.get(rowIndex).getNom();
        case 1:
            return personnels.get(rowIndex).getMotPasse();
        case 2:
            return personnels.get(rowIndex).getRole();
        default:
            return null;
        }

    }
    public void loadArticle(){
    
    }

}
