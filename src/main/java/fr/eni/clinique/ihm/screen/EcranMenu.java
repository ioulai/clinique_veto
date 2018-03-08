package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.eni.clinique.CliniqueVeto;
import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.impl.LoginMgerImpl;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EcranMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7889761062932513110L;
	private ConnexionModel connexionModel;
	private ConnexionController connexionController;
//	private ConnexionScreen connexionScreen = null;
	private String personnelNom ;
	 private LoginMgerImpl managerBll = LoginMgerImpl.getInstance();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EcranMenu frame = new EcranMenu();
//					frame.setVisible(true);
//					frame.setLocation(400, 300);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EcranMenu(ConnexionScreen connexionScreen) {
		setTitle("Clinique V\u00E9t\u00E9rinaire");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/fond_frame.jpg")));
		add(background);
		background.setLayout(new FlowLayout());

		setBounds(100, 100, 501, 378);
		connexionModel = new ConnexionModel();
		connexionController = new ConnexionController(connexionModel);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		personnelNom = connexionScreen.getNomTxt().getText();
		try {
			Personnel personnelConnecter =managerBll.connexion(personnelNom);
			
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JMenu mnFichier = new JMenu("Menu");
		menuBar.add(mnFichier);

		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mnFichier.add(mntmDconnexion);
		mntmDconnexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CliniqueVeto.ecranConnexion();
			}
		});

		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mnFichier.add(mntmFermer);
		mntmFermer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		
		JMenu mnGestionDesRendezvous = new JMenu("Gestion des rendez-vous");
		menuBar.add(mnGestionDesRendezvous);

		JMenuItem mntmGestionDesClients = new JMenuItem("Gestion des clients");
		mnGestionDesRendezvous.add(mntmGestionDesClients);
		mntmGestionDesClients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EcranPrincipalClient().setVisible(true);

			}
		});

		JMenuItem mntmPriseDeRendezvous = new JMenuItem("Prise de rendez-vous");
		mnGestionDesRendezvous.add(mntmPriseDeRendezvous);
		mntmPriseDeRendezvous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EcranRDV().setVisible(true);
			}
		});

		JMenuItem mnAgenda = new JMenuItem("Agenda");

		menuBar.add(mnAgenda);
		mnAgenda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EcranAgenda().setVisible(true);

			}
		});

		JMenuItem mnGestionDuPersonnel = new JMenuItem("Gestion du personnel");
		menuBar.add(mnGestionDuPersonnel);
		mnGestionDuPersonnel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionPerso gestionPerso = new GestionPerso();
				gestionPerso.setVisible(true);
				gestionPerso.setLocation(420, 300);

			}
		});
	}
}
