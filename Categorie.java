package metier;

public class Categorie {
	private int id;
	private String nom;
	public Categorie(int id,String nom) {
		super();
		this.id=id;
		this.nom=nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int code) {
		this.id = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String toString() {
		return"catégorie [id="+id+",nom="+nom+"]";
	}

	}

