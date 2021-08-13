package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Client;

public class ClientDAO {
	
	public void save(Client user) {
		
			try {
				
				if(user.getId() != 0) {
					PreparedStatement ps  = Database.connexion.prepareStatement("UPDATE client set nom=?,prenom=?,age=?,ville=? WHERE id=?");
					ps.setString(1,user.getNom());
					ps.setString(2,user.getPrenom());
					ps.setInt(3,user.getAge());
					ps.setString(4,user.getVille());
					ps.setInt(5,user.getId());
					ps.executeUpdate();
				}else {
					PreparedStatement ps  = Database.connexion.prepareStatement("INSERT INTO client (nom,prenom,age,ville) VALUES(?,?,?,?)");
					ps.setString(1,user.getNom());
					ps.setString(2,user.getPrenom());
					ps.setInt(3,user.getAge());
					ps.setString(4,user.getVille());
					ps.executeUpdate();
				}
				System.out.println("SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	
	public Client getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM client WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				
				Client u = new Client();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setAge(resultat.getInt( "age" ));
					u.setVille(resultat.getString( "ville" ));
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Client> getAll() {
		ArrayList<Client> users = new ArrayList<Client>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM client");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Client u = new Client();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setAge(resultat.getInt( "age" ));
					u.setVille(resultat.getString( "ville" ));
					users.add(u);
				}
				
				
				return users;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM client WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}

	public ArrayList<Client> getByName(String filtre) {
		ArrayList<Client> users = new ArrayList<Client>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ?");
				ps.setString(1, "%"+filtre+"%");
				ps.setString(2, "%"+filtre+"%");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Client u = new Client();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setAge(resultat.getInt( "age" ));
					u.setVille(resultat.getString( "ville" ));
					users.add(u);
				}
				
				
				return users;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
}
