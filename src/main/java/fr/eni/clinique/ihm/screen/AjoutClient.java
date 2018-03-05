package fr.eni.clinique.ihm.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AjoutClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodeClient;
	private JTextField txtNomCli;
	private JTextField txtPrenomCli;
	private JTextField txtAdress1;
	private JTextField txtAdress2;
	private JTextField txtCodePost;
	private JTextField txtVille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutClient frame = new AjoutClient();
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
	public AjoutClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 414, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnValider = new JButton("");
		btnValider.setIcon(new ImageIcon(AjoutClient.class.getResource("/images/Save24.gif")));
		btnValider.setBounds(288, 11, 46, 36);
		panel.add(btnValider);
		
		JLabel lblValider = new JLabel("Valider");
		lblValider.setBounds(288, 45, 46, 14);
		panel.add(lblValider);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.setIcon(new ImageIcon(AjoutClient.class.getResource("/images/aim.png")));
		btnAnnuler.setBounds(344, 11, 46, 36);
		panel.add(btnAnnuler);
		
		JLabel lblAnnuler = new JLabel("Annuler");
		lblAnnuler.setBounds(344, 45, 46, 14);
		panel.add(lblAnnuler);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(72, 92, 46, 14);
		contentPane.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(72, 117, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(72, 142, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(72, 167, 46, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(72, 229, 69, 14);
		contentPane.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(72, 254, 46, 14);
		contentPane.add(lblVille);
		
		txtCodeClient = new JTextField();
		txtCodeClient.setBounds(142, 89, 150, 20);
		contentPane.add(txtCodeClient);
		txtCodeClient.setColumns(10);
		
		txtNomCli = new JTextField();
		txtNomCli.setBounds(142, 114, 150, 20);
		contentPane.add(txtNomCli);
		txtNomCli.setColumns(10);
		
		txtPrenomCli = new JTextField();
		txtPrenomCli.setBounds(142, 139, 150, 20);
		contentPane.add(txtPrenomCli);
		txtPrenomCli.setColumns(10);
		
		txtAdress1 = new JTextField();
		txtAdress1.setBounds(142, 164, 150, 20);
		contentPane.add(txtAdress1);
		txtAdress1.setColumns(10);
		
		txtAdress2 = new JTextField();
		txtAdress2.setBounds(142, 195, 150, 20);
		contentPane.add(txtAdress2);
		txtAdress2.setColumns(10);
		
		txtCodePost = new JTextField();
		txtCodePost.setBounds(142, 226, 150, 20);
		contentPane.add(txtCodePost);
		txtCodePost.setColumns(10);
		
		txtVille = new JTextField();
		txtVille.setBounds(142, 254, 150, 20);
		contentPane.add(txtVille);
		txtVille.setColumns(10);
	}
}
