package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EcranMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7889761062932513110L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranMenu frame = new EcranMenu();
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
	public EcranMenu() {
		setTitle("Clinique V\u00E9t\u00E9rinaire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mnFichier.add(mntmDconnexion);
		
		JMenuItem mntmFermer = new JMenuItem("Fermer");
		mnFichier.add(mntmFermer);
		
		JMenu mnGestionDesRendezvous = new JMenu("Gestion des rendez-vous");
		menuBar.add(mnGestionDesRendezvous);
		
		JMenuItem mntmGestionDesClients = new JMenuItem("Gestion des clients");
		mnGestionDesRendezvous.add(mntmGestionDesClients);
		
		JMenuItem mntmPriseDeRendezvous = new JMenuItem("Prise de rendez-vous");
		mnGestionDesRendezvous.add(mntmPriseDeRendezvous);
		
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		
		JMenu mnGestionDuPersonnel = new JMenu("Gestion du personnel");
		menuBar.add(mnGestionDuPersonnel);
	}
}
