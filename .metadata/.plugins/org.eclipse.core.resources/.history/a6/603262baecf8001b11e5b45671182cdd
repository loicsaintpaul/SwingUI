// Les images viennent de : https://fonts.google.com/icons?icon.query=cancel

package vues;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entites.Database;
import vues.client.GestionClient;

public class Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Database.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 649, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGestionClients = new JButton("Gestion Clients");
		btnGestionClients.setForeground(Color.WHITE);
		btnGestionClients.setBackground(new Color(153, 204, 255));
		btnGestionClients.setOpaque(true);
		btnGestionClients.setBorderPainted(false);
		btnGestionClients.setBounds(20, 179, 180, 104);
		frame.getContentPane().add(btnGestionClients);
		btnGestionClients.setIcon(new ImageIcon(Application.class.getResource("/resources/images/outline_people_white_24dp.png")));
		
		JButton btnGestionProduits = new JButton("Gestion Produits");
		btnGestionProduits.setForeground(Color.WHITE);
		btnGestionProduits.setBackground(new Color(153, 204, 255));
		btnGestionProduits.setOpaque(true);
		btnGestionProduits.setBorderPainted(false);
		btnGestionProduits.setBounds(234, 179, 180, 104);
		frame.getContentPane().add(btnGestionProduits);
		btnGestionProduits.setIcon(new ImageIcon(Application.class.getResource("/resources/images/outline_inventory_2_white_24dp.png")));
		btnGestionProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnGestionCategories = new JButton("Gestion Categories");
		btnGestionCategories.setForeground(Color.WHITE);
		btnGestionCategories.setBackground(new Color(153, 204, 255));
		btnGestionCategories.setOpaque(true);
		btnGestionCategories.setBorderPainted(false);
		btnGestionCategories.setBounds(448, 179, 180, 104);
		frame.getContentPane().add(btnGestionCategories);
		btnGestionCategories.setIcon(new ImageIcon(Application.class.getResource("/resources/images/outline_sell_white_24dp.png")));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(null);
		panelHeader.setBackground(new Color(100, 149, 237));
		panelHeader.setBounds(0, 0, 649, 140);
		frame.getContentPane().add(panelHeader);
		
		JLabel lblTableauDeBord = new JLabel("Tableau de bord");
		lblTableauDeBord.setForeground(Color.WHITE);
		lblTableauDeBord.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblTableauDeBord.setBounds(184, 53, 268, 36);
		panelHeader.add(lblTableauDeBord);
		btnGestionClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionClient winGestionClient = new GestionClient();
				winGestionClient.setParent(frame);
				winGestionClient.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
	}

}
