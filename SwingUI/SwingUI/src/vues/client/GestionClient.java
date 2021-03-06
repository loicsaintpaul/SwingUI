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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ClientDAO;
import entites.Client;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionClient {

	private JFrame frame;
	private JFrame parent;
	private DefaultTableModel model;
	private JTable tableau;
	private JTextField textFieldFiltre;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public GestionClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				populateClient();
			}
		});

		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tableau = new JTable();
		frame.getContentPane().add(tableau);
		tableau.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		tableau.getTableHeader().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		tableau.setBounds(182, 140, 518, 22);

		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(184, 168, 492, 285);
		frame.getContentPane().add(scrollPane);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(204, 153, 255));
		panelMenu.setBounds(0, 140, 184, 330);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblModifier.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblModifier.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableau.getSelectedRow() != -1) {

					int rowIndex = tableau.getSelectedRow();
					int selectedId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
					ClientDAO userdao = new ClientDAO();
					Client client = userdao.getById(selectedId);

					UpdateClient winUpdateClient = new UpdateClient(client);
					winUpdateClient.setParent(frame);
					winUpdateClient.getFrame().setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Veuillez choisir une ligne ");
				}
			}
		});
		lblModifier.setIcon(
				new ImageIcon(GestionClient.class.getResource("/resources/images/outline_edit_white_24dp.png")));
		lblModifier.setForeground(new Color(255, 255, 255));
		lblModifier.setBounds(33, 17, 130, 40);
		panelMenu.add(lblModifier);

		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblSupprimer.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblSupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableau.getSelectedRow() != -1) {
					
					int dialogResult = JOptionPane.showConfirmDialog(frame, "Voulez-vous supprimer ce client ?","Choix",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						int rowIndex = tableau.getSelectedRow();
						int selectedId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
						ClientDAO userdao = new ClientDAO();
						userdao.deleteById(selectedId);
						populateClient();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Veuillez choisir une ligne ");
				}
			}
		});
		lblSupprimer.setIcon(
				new ImageIcon(GestionClient.class.getResource("/resources/images/outline_delete_white_24dp.png")));
		lblSupprimer.setForeground(new Color(255, 255, 255));
		lblSupprimer.setBounds(33, 99, 130, 40);
		panelMenu.add(lblSupprimer);

		JLabel lblCreer = new JLabel("Cr\u00E9er");
		lblCreer.setIcon(
				new ImageIcon(GestionClient.class.getResource("/resources/images/outline_add_white_24dp.png")));
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
				AddClient winAddClient = new AddClient();
				winAddClient.setParent(frame);
				winAddClient.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		lblCreer.setForeground(new Color(255, 255, 255));
		lblCreer.setBounds(33, 181, 130, 40);
		panelMenu.add(lblCreer);

		JLabel lblQuitter = new JLabel("Quitter");
		lblQuitter.setIcon(
				new ImageIcon(GestionClient.class.getResource("/resources/images/outline_arrow_back_white_24dp.png")));
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

		JLabel lblNewLabel = new JLabel("Gestion des Clients");
		lblNewLabel.setBounds(200, 51, 301, 36);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		panelHeader.add(lblNewLabel);
		
		textFieldFiltre = new JTextField();
		textFieldFiltre.setBounds(184, 140, 386, 31);
		frame.getContentPane().add(textFieldFiltre);
		textFieldFiltre.setColumns(10);
		
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateClient();
			}
		});
		btnFiltrer.setBounds(571, 140, 105, 29);
		frame.getContentPane().add(btnFiltrer);
	}

	public void populateClient() {
		ClientDAO clientdao = new ClientDAO();
		
		String filtre = textFieldFiltre.getText();
		
		ArrayList<Client> clients;

		if(filtre.isBlank()) {
			clients = clientdao.getAll();
		}else {
			clients = clientdao.getByName(filtre);
		}

		String columns[] = { "Id", "Prenom", "Nom", "Age", "Ville" };
		String data[][] = null;
		if(clients.size() != 0) {
			data = new String[clients.size()][columns.length];

			int i = 0;
			for (Client u : clients) {
				data[i][0] = u.getId() + "";
				data[i][1] = u.getNom();
				data[i][2] = u.getPrenom();
				data[i][3] = u.getAge() + "";
				data[i][4] = u.getVille();
				i++;
			}
		}

		model = new DefaultTableModel(data, columns);
		
		// mets ? jour le model
		
		tableau.setModel(model);
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}
}
