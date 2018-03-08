package fr.eni.clinique.ihm.screen;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
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

	private  ConnexionModel connexionModel;
	private ConnexionController connexionController ;

	private LoginMger loginManager = ManagerFactory.loginMger();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranRDV frame = new EcranRDV();
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
	public EcranRDV() {

		 connexionModel = new ConnexionModel();
		 connexionController = new ConnexionController(connexionModel);
		 
		 
		setTitle("Prise de rendez-vous");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 23, 193, 102);
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
		
		JComboBox<String> cbx_Client = new JComboBox<String>();
		cbx_Client.setBounds(10, 31, 123, 20);
		panel.add(cbx_Client);
		try {
			List<Client> clients = loginManager.tousLesClients();
			for (Client client : clients) {
				cbx_Client.addItem(client.getNomClient()+" - "+client.getPrenomClient());		
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		JComboBox<String> cbx_Animal = new JComboBox<String>();
		cbx_Animal.setBounds(10, 71, 123, 20);
		panel.add(cbx_Animal);
		try {
			List<Animal> animaux = loginManager.tousLesAnimaux();
			for (Animal animal : animaux) {
				cbx_Animal.addItem(animal.getRace()+" - "+animal.getNomAnimal());		
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		JButton Bt_ajoutClient = new JButton("+");
		Bt_ajoutClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutClient.setBounds(143, 11, 40, 34);
		panel.add(Bt_ajoutClient);
		Bt_ajoutClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AjoutClient(connexionController, connexionModel).setVisible(true);
				
			}
		});
		
		JButton Bt_ajoutAnimal = new JButton("+");
		Bt_ajoutAnimal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutAnimal.setBounds(143, 57, 40, 34);
		panel.add(Bt_ajoutAnimal);
		Bt_ajoutAnimal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EcranAnimal(connexionController, connexionModel).setVisible(true);
				
			}
		});
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(248, 23, 154, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<?> cbx_veterinaire = new JComboBox<Object>();
		cbx_veterinaire.setBounds(32, 31, 100, 20);
		panel_1.add(cbx_veterinaire);
		
		JLabel lblVtrinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVtrinaire.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVtrinaire.setBounds(32, 11, 100, 14);
		panel_1.add(lblVtrinaire);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(446, 23, 154, 102);
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
		lblPar.setBounds(248, -2, 46, 29);
		contentPane.add(lblPar);
		
		JLabel lblQuand = new JLabel("Quand");
		lblQuand.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuand.setBounds(446, -2, 46, 29);
		contentPane.add(lblQuand);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(10, 148, 590, 208);
		contentPane.add(panel_3);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setBounds(416, 362, 101, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setBounds(527, 362, 73, 23);
		contentPane.add(btnValider);

	}
}
