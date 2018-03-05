package fr.eni.clinique.ihm.model;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Personnel;


public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5339658835698597380L;
	
	private List<Personnel> personnels = new ArrayList<>();
    private final String[] entetes = { "Nom", "Rôle", "MotPasse"};
 

    public TableModel(List<Personnel> personnels) {
        super();
        this.personnels = personnels;
    }
    public void addPersonnel(Personnel personnel) {
        this.personnels.add(personnel);
    }
    
    public void removePersonnel(int index) {
        this.personnels.remove(index);
        fireTableRowsDeleted(index, index);
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

	
}
