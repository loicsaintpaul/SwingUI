package entites;

public class Produit {
	private int id;
	private String nom;
	private int idCategorie;
	private double prix;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public Produit() {

	}

	public Produit(String nom, int idCategorie, double prix) {
		this.nom = nom;
		this.idCategorie = idCategorie;
		this.prix = prix;
	}

	public String toString() {
		return "id:" + id + "\t\tnom:" + nom + "\t\tidCategorie:" + idCategorie + "\t\tprix:" + prix + "\n";
	}
}
