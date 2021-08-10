package vues.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.CategorieDAO;
import dao.ProduitDAO;
import entites.Categorie;
import entites.Produit;
import javax.swing.JComboBox;

public class UpdateProduit {

	private JFrame frame;
	private JFrame parent;
	private JTextField textFieldNom;
	private JTextField textFieldPrix;
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

		CategorieDAO categoriedao = new CategorieDAO();
		ArrayList<Categorie> listecategorie = categoriedao.getAll();
		
		JComboBox<Categorie> comboBox = new JComboBox<Categorie>();
		comboBox.setBounds(404, 302, 130, 21);
		frame.getContentPane().add(comboBox);
		
		for (Categorie c : listecategorie) {
			comboBox.addItem(c);
			
		}
		System.out.println(comboBox);
		System.out.println(categoriedao.getById(produit.getIdCategorie()));
		comboBox.getModel().setSelectedItem(categoriedao.getById(produit.getIdCategorie()));

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
				CategorieDAO categoriedao = new CategorieDAO();
				String nom = textFieldNom.getText();
				String prix = textFieldPrix.getText();
				String selectedCategorie = (String) comboBox.getSelectedItem();
				int idCategorie = categoriedao.getByKeyword(selectedCategorie).getId();

				try {
					double prixDouble = Double.parseDouble(prix);

					produit.setNom(nom);
					produit.setPrix(prixDouble);
					produit.setIdCategorie(idCategorie);

					ProduitDAO produitdao = new ProduitDAO();
					produitdao.save(produit);

					JOptionPane.showMessageDialog(frame, "Produit modifi�");
					frame.setVisible(false);
					parent.setVisible(true);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Mauvaise saisie de l'�ge");
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

		textFieldPrix = new JTextField(produit.getPrix() + "");
		textFieldPrix.setColumns(10);
		textFieldPrix.setBounds(404, 255, 130, 26);
		frame.getContentPane().add(textFieldPrix);

		JLabel lblIdCategorie = new JLabel("Cat�gorie");
		lblIdCategorie.setBounds(274, 304, 61, 16);
		frame.getContentPane().add(lblIdCategorie);

	}

	
	public void setParent(JFrame parent) {
		this.parent = parent;
	}
}
