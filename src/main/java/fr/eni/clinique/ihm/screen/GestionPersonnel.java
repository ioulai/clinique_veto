package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class GestionPersonnel extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 510, 496);
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
		
		JButton ajout = new JButton("+");
		ajout.setFont(new Font("Tahoma", Font.BOLD, 11));
		ajout.setBounds(15, 11, 41, 23);
		panel_bouton.add(ajout);
		
		JButton reini = new JButton("§");
		reini.setFont(new Font("Tahoma", Font.BOLD, 11));
		reini.setBounds(190, 11, 41, 23);
		panel_bouton.add(reini);
		
		JButton supprimer = new JButton("-");
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		supprimer.setBounds(99, 11, 41, 23);
		panel_bouton.add(supprimer);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setBounds(15, 39, 41, 14);
		panel_bouton.add(lblAjouter);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setBounds(99, 39, 58, 14);
		panel_bouton.add(lblSupprimer);
		
		JLabel lblRinitialiser = new JLabel("R\u00E9initialiser");
		lblRinitialiser.setBounds(190, 39, 58, 14);
		panel_bouton.add(lblRinitialiser);
		
		JLabel lblPourTouteQuestion = new JLabel("Pour toute question technique, Contactez Isaac et Mariam. Merci");
		lblPourTouteQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPourTouteQuestion.setBounds(20, 431, 452, 14);
		contentPane.add(lblPourTouteQuestion);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(10, 86, 474, 334);
		contentPane.add(table);
	}
}
