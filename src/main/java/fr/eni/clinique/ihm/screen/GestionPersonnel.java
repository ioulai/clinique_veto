package fr.eni.clinique.ihm.screen;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;
import fr.eni.clinique.ihm.model.TableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionPersonnel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897602906008254998L;
	private JPanel contentPane;

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

	public class Panel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		public Panel( TableModel model )
		  {
		    table = new JTable( model );
		    setLayout( new BorderLayout() );
		    add( new JScrollPane( table ), BorderLayout.CENTER );
		  }
		  private JTable table;
		}
	/**
	 * Create the frame.
	 */
	public GestionPersonnel() {
		
		setTitle("Gestion du personnel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ajout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EcranAgenda frame = new EcranAgenda();
				frame.setVisible(true);
				
			}
		});
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
		
		 Connection connection;
			try {
				connection = MSSQLConnectionFactory.get(); 
				Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
			                								   ResultSet.CONCUR_READ_ONLY );
		   ResultSet rs = st.executeQuery( "SELECT * FROM Personnels" );	
		   TableModel rtm = new TableModel( rs );
	       
		    JPanel tablePanel = new JPanel( rtm );
		    tablePanel.setBounds(20, 86, 433, 324);
			contentPane.add(tablePanel);
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	
	
}
