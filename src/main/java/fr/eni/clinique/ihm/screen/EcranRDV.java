package fr.eni.clinique.ihm.screen;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;

import fr.eni.clinique.bo.Personnel;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;


import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class EcranRDV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3455097310174582783L;
	private JPanel contentPane;
	private JComboBox<String> cbx_veterinaire;


	private JComboBox<String> createComboBox(List<Personnel> personnels, String tooltip) {

        JComboBox<String> combo = new JComboBox<>();
        combo.setToolTipText(tooltip);

        for (Personnel personnel : personnels) {
            combo.addItem(personnel.getNom());
        }
        return combo;
    }



	private  ConnexionModel connexionModel;
	private ConnexionController connexionController ;

	private LoginMger loginManager = ManagerFactory.loginMger();
	

	/**
	 * Create the frame.
	 */
	public EcranRDV() {
		setTitle("Prise de rendez-vous");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 23, 154, 102);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClient.setBounds(10, 11, 84, 14);
		panel.add(lblClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnimal.setBounds(10, 52, 84, 14);
		panel.add(lblAnimal);
		
		JComboBox<?> cbx_nomClient = new JComboBox<Object>();
		cbx_nomClient.setBounds(10, 31, 89, 20);
		panel.add(cbx_nomClient);
		
		JComboBox<?> cbx_Animal = new JComboBox<Object>();
		cbx_Animal.setBounds(10, 71, 89, 20);
		panel.add(cbx_Animal);
		
		JButton Bt_ajoutClient = new JButton("+");
		Bt_ajoutClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutClient.setBounds(104, 23, 40, 30);
		panel.add(Bt_ajoutClient);
		
		JButton Bt_ajoutNom = new JButton("+");
		Bt_ajoutNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutNom.setBounds(104, 63, 40, 30);
		panel.add(Bt_ajoutNom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(178, 23, 154, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		List<Personnel> personnels;
		try {
			personnels = loginManager.toutLePersonnel();
			for (Personnel personnel : personnels) {
				if(personnel.getRole().equals("Vet")){
					cbx_veterinaire = createComboBox(personnels, "Selectionner un personnel");
				}
				
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cbx_veterinaire.setBounds(32, 31, 100, 20);
		panel_1.add(cbx_veterinaire);
		
		JLabel lblVtrinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVtrinaire.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVtrinaire.setBounds(32, 11, 100, 14);
		panel_1.add(lblVtrinaire);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(342, 23, 154, 102);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(10, 11, 46, 14);
		panel_2.add(lblDate);
 
	
		JLabel lblNewLabel = new JLabel("Heure");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 52, 46, 14);
		panel_2.add(lblNewLabel);
		
		JComboBox<?> cbx_heure = new JComboBox<Object>();
		cbx_heure.setBounds(10, 71, 33, 20);
		panel_2.add(cbx_heure);
		
		JComboBox<?> cbx_min = new JComboBox<Object>();
		cbx_min.setBounds(59, 71, 33, 20);
		panel_2.add(cbx_min);
		
		JLabel lblH = new JLabel("h");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblH.setBounds(48, 74, 46, 14);
		panel_2.add(lblH);
		
		JLabel lblPour = new JLabel("Pour");
		lblPour.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPour.setBounds(10, -2, 46, 29);
		contentPane.add(lblPour);
		
		JLabel lblPar = new JLabel("Par");
		lblPar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPar.setBounds(178, -2, 46, 29);
		contentPane.add(lblPar);
		
		JLabel lblQuand = new JLabel("Quand");
		lblQuand.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuand.setBounds(342, -2, 46, 29);
		contentPane.add(lblQuand);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(10, 148, 486, 208);
		contentPane.add(panel_3);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setBounds(312, 360, 101, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setBounds(423, 360, 73, 23);
		contentPane.add(btnValider);

	}
}
