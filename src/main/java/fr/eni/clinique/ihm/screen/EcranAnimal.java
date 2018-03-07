package fr.eni.clinique.ihm.screen;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Race;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EcranAnimal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8248264425509804877L;
	private LoginMger loginManager = ManagerFactory.loginMger();
	private JPanel contentPane;
	private JTextField txt_codeAnimal;
	private JTextField txt_nomAnimal;
	private JTextField txt_Couleur;
	private JTextField cbx_tatouage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranAnimal frame = new EcranAnimal();
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
	public EcranAnimal() {
		setTitle("Animaux");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 365, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(225, 11, 57, 33);
		btnNewButton.setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/Save24.gif")));
		panel.add(btnNewButton);
		
		JLabel lblValider = new JLabel("Valider");
		lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValider.setBounds(235, 41, 46, 14);
		panel.add(lblValider);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(EcranAnimal.class.getResource("/images/aim.png")));
		button.setBounds(302, 11, 57, 33);
		panel.add(button);
		
		JLabel lblAnnuler = new JLabel("Annuler");
		lblAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnnuler.setBounds(312, 41, 46, 14);
		panel.add(lblAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 87, 354, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBoxClient = new JComboBox<String>();
		comboBoxClient.setBounds(10, 11, 334, 20);
		panel_1.add(comboBoxClient);
		
		try {
			List<Client> clients = loginManager.tousLesClients();
			for (Client client : clients) {
				comboBoxClient.addItem(client.getNomClient()+" - "+client.getPrenomClient());		
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		 
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(10, 143, 46, 14);
		contentPane.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 168, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(10, 193, 46, 14);
		contentPane.add(lblCouleur);
		
		JLabel lblEspce = new JLabel("Esp\u00E8ce");
		lblEspce.setBounds(10, 218, 46, 14);
		contentPane.add(lblEspce);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(10, 243, 46, 14);
		contentPane.add(lblTatouage);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(160, 218, 32, 14);
		contentPane.add(lblRace);
		
		JComboBox<String> cbx_espèce = new JComboBox<String>();
		cbx_espèce.setBounds(65, 215, 86, 20);
		contentPane.add(cbx_espèce);
		try {
			List<Race> races = loginManager.toutesLesRaces();
			for (Race race : races) {
				cbx_espèce.addItem(race.getEspece());		
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		JComboBox<String> cbx_Race = new JComboBox<String>();
		cbx_Race.setBounds(188, 215, 88, 20);
		contentPane.add(cbx_Race);
		try {
			List<Race> races = loginManager.toutesLesRaces();
			for (Race race : races) {
				cbx_Race.addItem(race.getRace());		
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		 
		JComboBox<String> cbx_Sexe = new JComboBox<String>();
		cbx_Sexe.setBounds(274, 165, 74, 20);
		cbx_Sexe.addItem("Femelle");
		cbx_Sexe.addItem("Mâle");
		contentPane.add(cbx_Sexe);
		
		txt_codeAnimal = new JTextField();
		txt_codeAnimal.setEditable(false);
		txt_codeAnimal.setBounds(65, 143, 86, 20);
		contentPane.add(txt_codeAnimal);
		txt_codeAnimal.setColumns(10);
		
		txt_nomAnimal = new JTextField();
		txt_nomAnimal.setBounds(65, 165, 199, 20);
		contentPane.add(txt_nomAnimal);
		txt_nomAnimal.setColumns(10);
		
		txt_Couleur = new JTextField();
		txt_Couleur.setBounds(65, 190, 199, 20);
		contentPane.add(txt_Couleur);
		txt_Couleur.setColumns(10);
		
		cbx_tatouage = new JTextField();
		cbx_tatouage.setBounds(66, 240, 198, 20);
		contentPane.add(cbx_tatouage);
		cbx_tatouage.setColumns(10);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setBounds(10, 67, 46, 21);
		contentPane.add(lblClient);
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
