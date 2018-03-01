package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Point;
import javax.swing.JSpinner;
import java.awt.Panel;
import javax.swing.JList;

public class EcranRDV extends JFrame {

	private JPanel contentPane;

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
		setTitle("Prise de rendez-vous");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblClient.setBounds(10, 11, 46, 14);
		panel.add(lblClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnimal.setBounds(10, 52, 46, 14);
		panel.add(lblAnimal);
		
		JComboBox cbx_nomClient = new JComboBox();
		cbx_nomClient.setBounds(10, 31, 89, 20);
		panel.add(cbx_nomClient);
		
		JComboBox cbx_Animal = new JComboBox();
		cbx_Animal.setBounds(10, 71, 89, 20);
		panel.add(cbx_Animal);
		
		JButton Bt_ajoutClient = new JButton("+");
		Bt_ajoutClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutClient.setBounds(104, 30, 40, 23);
		panel.add(Bt_ajoutClient);
		
		JButton Bt_ajoutNom = new JButton("+");
		Bt_ajoutNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Bt_ajoutNom.setBounds(104, 70, 40, 23);
		panel.add(Bt_ajoutNom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(178, 23, 154, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbx_veterinaire = new JComboBox();
		cbx_veterinaire.setBounds(32, 31, 100, 20);
		panel_1.add(cbx_veterinaire);
		
		JLabel lblVtrinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVtrinaire.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVtrinaire.setBounds(32, 11, 78, 14);
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
		
		JComboBox cbx_heure = new JComboBox();
		cbx_heure.setBounds(10, 71, 33, 20);
		panel_2.add(cbx_heure);
		
		JComboBox cbx_min = new JComboBox();
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
