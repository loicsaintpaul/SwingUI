package vues.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ClientDAO;
import entites.Client;

public class UpdateClient {

	private JFrame frame;
	private JFrame parent;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAge;
	private JTextField textFieldVille;
	private Client client;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public UpdateClient(Client client) {
		this.client = client;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(204, 153, 255));
		panelMenu.setBounds(0, 140, 184, 330);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblCreer = new JLabel("Valider");
		lblCreer.setIcon(
				new ImageIcon(UpdateClient.class.getResource("/resources/images/outline_done_white_24dp.png")));
		lblCreer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblCreer.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblCreer.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom = textFieldNom.getText();
				String prenom = textFieldPrenom.getText();
				String age = textFieldAge.getText();
				try {
					int ageInt = Integer.parseInt(age);
					String ville = textFieldVille.getText();

					client.setNom(nom);
					client.setPrenom(prenom);
					client.setAge(ageInt);
					client.setVille(ville);
					
					ClientDAO clientdao = new ClientDAO();
					clientdao.save(client);

					JOptionPane.showMessageDialog(frame, "Client modifi??");
					frame.setVisible(false);
					parent.setVisible(true);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Mauvaise saisie de l'??ge");
				}
			}
		});
		lblCreer.setForeground(new Color(255, 255, 255));
		lblCreer.setBounds(33, 181, 130, 40);
		panelMenu.add(lblCreer);

		JLabel lblQuitter = new JLabel("Annuler");
		lblQuitter.setIcon(
				new ImageIcon(UpdateClient.class.getResource("/resources/images/outline_cancel_white_24dp.png")));
		lblQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblQuitter.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblQuitter.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				parent.setVisible(true);
			}
		});
		lblQuitter.setForeground(Color.WHITE);
		lblQuitter.setBounds(33, 263, 130, 40);
		panelMenu.add(lblQuitter);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(204, 153, 255));
		panelHeader.setBounds(0, 0, 700, 140);
		frame.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modifier un client");
		lblNewLabel.setBounds(200, 51, 301, 36);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panelHeader.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(274, 218, 61, 16);
		frame.getContentPane().add(lblNom);
		
		textFieldNom = new JTextField(client.getNom());
		textFieldNom.setBounds(404, 213, 130, 26);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr??nom");
		lblPrenom.setBounds(274, 260, 61, 16);
		frame.getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField(client.getPrenom());
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(404, 255, 130, 26);
		frame.getContentPane().add(textFieldPrenom);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(274, 304, 61, 16);
		frame.getContentPane().add(lblAge);
		
		textFieldAge = new JTextField(client.getAge()+"");
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(404, 299, 70, 26);
		frame.getContentPane().add(textFieldAge);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(274, 345, 61, 16);
		frame.getContentPane().add(lblVille);
		
		textFieldVille = new JTextField(client.getVille());
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(404, 340, 230, 26);
		frame.getContentPane().add(textFieldVille);

	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}
}
