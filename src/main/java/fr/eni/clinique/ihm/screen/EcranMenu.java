package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mnFichier.add(mntmDconnexion);
		
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
				EcranRDV frame = new EcranRDV();
				frame.setVisible(true);
				
			}
		});
		JMenuItem mntmPriseDeRendezvous = new JMenuItem("Prise de rendez-vous");
		mnGestionDesRendezvous.add(mntmPriseDeRendezvous);
		mntmPriseDeRendezvous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EcranRDV frame = new EcranRDV();
				frame.setVisible(true);
			}
		});
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		mnAgenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EcranAgenda frame = new EcranAgenda();
				frame.setVisible(true);
				
			}
		});
		
		JMenu mnGestionDuPersonnel = new JMenu("Gestion du personnel");
		menuBar.add(mnGestionDuPersonnel);
		mnGestionDuPersonnel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Gestion du personnel")){
				new GestionPersonnel().setVisible(true);
					
			}}
		});
	}
}
