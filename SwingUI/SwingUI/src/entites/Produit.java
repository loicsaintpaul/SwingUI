package entites;

public class Produit {
	private int id;
	private String nom;
	private int idCategorie;
	private double prix;
	private String nomCat;
	
	public int getId() {
		return id;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
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
		return nom;
	}
}
