package entites;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String ville;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client() {

	}

	public Client(String nom, String prenom, int age, String ville) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.ville = ville;
	}

	public String toString() {
		return "id:" + id + "\t\tnom:" + nom + "\t\tprenom:" + prenom + "\t\tage:" + age + "\t\tville:" + ville + "\n";
	}
}
