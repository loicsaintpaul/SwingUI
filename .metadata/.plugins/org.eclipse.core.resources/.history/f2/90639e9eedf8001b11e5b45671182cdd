package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Produit;

public class ProduitDAO {
	
	public void save(Produit produit) {
		
			try {
				
				if(produit.getId() != 0) {
					PreparedStatement ps  = Database.connexion.prepareStatement("UPDATE produit set nom_produit=?,prix=?,id_categorie=? WHERE id=?");
					ps.setString(1,produit.getNom());
					ps.setDouble(2,produit.getPrix());
					ps.setInt(3,produit.getIdCategorie());
					ps.setInt(4,produit.getId());
					ps.executeUpdate();
				}else {
					PreparedStatement ps  = Database.connexion.prepareStatement("INSERT INTO produit (nom_produit,prix,id_categorie) VALUES(?,?,?)");
					ps.setString(1,produit.getNom());
					ps.setDouble(2,produit.getPrix());
					ps.setInt(3,produit.getIdCategorie());
					ps.executeUpdate();
				}
				System.out.println("SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	
	public Produit getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				
				Produit u = new Produit();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom_produit" ));
					u.setPrix(resultat.getDouble( "prix" ));
					u.setIdCategorie(resultat.getInt( "id_categorie" ));
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Produit> getAll() {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM produit");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Produit u = new Produit();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom_produit" ));
					u.setPrix(resultat.getDouble( "prix" ));
					u.setIdCategorie(resultat.getInt( "id_categorie" ));
					produits.add(u);
				}
				
				
				return produits;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM produit WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
}
