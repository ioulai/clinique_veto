package fr.eni.clinique.dal;

//import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;

//import fr.eni.clinique.bll.manager.ihm.GestionPersonnel;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.dao.PersonnelDAO;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class AppliTestDAL {

	public static void main(String[] args) {
		System.out.println("b");
		List <Personnel> ps= new ArrayList<>();
		PersonnelDAO pers =DaoFactory.personnelDao();
		try {
			ps = pers.selectALL();
			for(Personnel p : ps)
			{
				System.out.println("a"+p);
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Personnel personnel = new Personnel("TestDal", "mdpDAL");

		try {
			pers.insert(personnel);
		} catch (DaoException e) {
			e.printStackTrace();
		} 

		try {
			ps = pers.selectALL();
			for(Personnel p : ps)
			{
				System.out.println(p);
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
//		 try {
//
//	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//	            
//	            SwingUtilities.invokeLater(new Runnable() {
//	                @Override
//	                public void run() {
//	                    
//	                    CliniqueModel cliniqueModel = new CliniqueModel();
//	                    
//	                    CliniqueController cliniqueController = new CliniqueController(cliniqueModel);
//	                   GestionPersonnel screen = new GestionPersonnel(cliniqueController, cliniqueModel);
//	       	         
////	                    ConnexionScreen screen = new ConnexionScreen(cliniqueController, cliniqueModel);
//	         
//	                }
//	            });
//	        } catch (Exception e) {
//	            throw new TechnicalException("Erreur Technique", e);
//	        }
		
	}

}
