package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Categorie;

public class CategorieDAO {

	public void save(Categorie categorie) {

		try {

			if (categorie.getId() != 0) {
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE Categorie set nom_categorie=? WHERE id=?");
				ps.setString(1, categorie.getNom_categorie());
				ps.setInt(2, categorie.getId());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO Categorie (nom_categorie) VALUES(?)");
				ps.setString(1, categorie.getNom_categorie());
				ps.executeUpdate();
			}
			System.out.println("SAVED CATEGORIE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED CATEGORIE NO");
		}

	}

	public Categorie getById(int id) {
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Categorie WHERE id=?");
			ps.setInt(1, id);

			ResultSet resultat = ps.executeQuery();

			Categorie c = new Categorie();
			while (resultat.next()) {
				c.setId(resultat.getInt("id"));
				c.setNom_categorie(resultat.getString("nom_categorie"));
			}
			return c;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Categorie getByKeyword(String nom) {
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Categorie WHERE nom_categorie=?");
			ps.setString(1, nom);

			ResultSet resultat = ps.executeQuery();

			Categorie c = new Categorie();
			while (resultat.next()) {
				c.setId(resultat.getInt("id"));
				c.setNom_categorie(resultat.getString("nom_categorie"));
			}
			return c;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM Categorie");

			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {
				Categorie c = new Categorie();
				c.setId(resultat.getInt("id"));
				c.setNom_categorie(resultat.getString("nom_categorie"));
				categories.add(c);
			}

			return categories;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void deleteById(int id) {
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM Categorie WHERE id=?");
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("DELETED CATEGORIE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED CATEGORIE NO");
		}
	}
}
