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

import dao.ProduitDAO;
import entites.Produit;

public class UpdateProduit {

	private JFrame frame;
	private JFrame parent;
	private JTextField textFieldNom;
	private JTextField textFieldPrix;
	private JTextField textFieldIdCategorie;
	private Produit produit;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public UpdateProduit(Produit produit) {
		this.produit = produit;
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
		panelMenu.setBackground(new Color(102, 204, 102));
		panelMenu.setBounds(0, 140, 184, 330);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblCreer = new JLabel("Valider");
		lblCreer.setIcon(
				new ImageIcon(UpdateProduit.class.getResource("/resources/images/outline_done_white_24dp.png")));
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
				String prix = textFieldPrix.getText();
				String idCategorie = textFieldIdCategorie.getText();
				try {
					double prixDouble = Double.parseDouble(prix);
					int idCategorieInt = Integer.parseInt(idCategorie);

					produit.setNom(nom);
					produit.setPrix(prixDouble);
					produit.setIdCategorie(idCategorieInt);
					
					ProduitDAO produitdao = new ProduitDAO();
					produitdao.save(produit);

					JOptionPane.showMessageDialog(frame, "Produit modifié");
					frame.setVisible(false);
					parent.setVisible(true);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Mauvaise saisie de l'âge");
				}
			}
		});
		lblCreer.setForeground(new Color(255, 255, 255));
		lblCreer.setBounds(33, 181, 130, 40);
		panelMenu.add(lblCreer);

		JLabel lblQuitter = new JLabel("Annuler");
		lblQuitter.setIcon(
				new ImageIcon(UpdateProduit.class.getResource("/resources/images/outline_cancel_white_24dp.png")));
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
		panelHeader.setBackground(new Color(102, 204, 102));
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
		
		textFieldNom = new JTextField(produit.getNom());
		textFieldNom.setBounds(404, 213, 130, 26);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(274, 260, 61, 16);
		frame.getContentPane().add(lblPrix);
		
		textFieldPrix = new JTextField(produit.getPrix()+"");
		textFieldPrix.setColumns(10);
		textFieldPrix.setBounds(404, 255, 130, 26);
		frame.getContentPane().add(textFieldPrix);
		
		JLabel lblIdCategorie = new JLabel("Catégorie");
		lblIdCategorie.setBounds(274, 304, 61, 16);
		frame.getContentPane().add(lblIdCategorie);
		
		textFieldIdCategorie = new JTextField(produit.getIdCategorie()+"");
		textFieldIdCategorie.setColumns(10);
		textFieldIdCategorie.setBounds(404, 299, 130, 26);
		frame.getContentPane().add(textFieldIdCategorie);

	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}
}
