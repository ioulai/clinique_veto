package fr.eni.clinique.ihm.model;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Personnel;


public class TableModel extends AbstractTableModel implements LayoutManager {

	private static final long serialVersionUID = 5339658835698597380L;
	
	private List<Personnel> personnels = new ArrayList<>();
    private final String[] entetes = { "Nom", "Rôle", "MotPasse"};

	private ResultSetMetaData resultSetMetaData;

	private ResultSet resultSet;


   
    public TableModel( ResultSet resultSet )
    {
      this.resultSet = resultSet;
      
      try 
      {
        this.resultSetMetaData = resultSet.getMetaData();
      } 
      catch (SQLException e) 
      {
        e.printStackTrace();
      }
    }
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
	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void layoutContainer(Container arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Dimension minimumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dimension preferredLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}

}
