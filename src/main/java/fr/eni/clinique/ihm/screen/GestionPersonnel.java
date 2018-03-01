package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;
import fr.eni.clinique.ihm.controller.AdminController;
import fr.eni.clinique.ihm.model.AdminModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestionPersonnel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private AdminController controller;
	private AdminModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPersonnel frame = new GestionPersonnel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GestionPersonnel() {
		
		setTitle("Gestion du personnel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_bouton = new JPanel();
		panel_bouton.setBackground(Color.WHITE);
		panel_bouton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_bouton.setBounds(10, 11, 474, 64);
		contentPane.add(panel_bouton);
		panel_bouton.setLayout(null);
		
		JButton ajout = new JButton("");
		ajout.setIcon(new ImageIcon(GestionPersonnel.class.getResource("/images/New24.gif")));
		ajout.setFont(new Font("Tahoma", Font.BOLD, 11));
		ajout.setBounds(15, 11, 35, 33);
		panel_bouton.add(ajout);
		
		JButton reini = new JButton("");
		reini.setIcon(new ImageIcon(GestionPersonnel.class.getResource("/images/init.PNG")));
		reini.setFont(new Font("Tahoma", Font.BOLD, 11));
		reini.setBounds(182, 11, 35, 33);
		panel_bouton.add(reini);
		
		JButton supprimer = new JButton("");
		supprimer.setIcon(new ImageIcon(GestionPersonnel.class.getResource("/images/Delete24.gif")));
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		supprimer.setBounds(99, 11, 35, 33);
		panel_bouton.add(supprimer);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setBounds(15, 45, 41, 14);
		panel_bouton.add(lblAjouter);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setBounds(96, 45, 66, 14);
		panel_bouton.add(lblSupprimer);
		
		JLabel lblRinitialiser = new JLabel("R\u00E9initialiser");
		lblRinitialiser.setBounds(172, 45, 74, 14);
		panel_bouton.add(lblRinitialiser);
		
		JLabel lblPourTouteQuestion = new JLabel("Pour toute question technique, Contactez Isaac et Mariam. Merci");
		lblPourTouteQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPourTouteQuestion.setBounds(20, 431, 452, 24);
		contentPane.add(lblPourTouteQuestion);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(10, 86, 474, 334);
		contentPane.add(table);
	   // controller.init();
	    List<Personnel> personnels = new ArrayList<>();
		model.loadPersonnels(personnels);
		
		
	}
	
}
