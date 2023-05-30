package metier;

public class Coffee {
	private int id;
	private String nom;
	private int prix;
	private String description;
	private int catégorie;
	public Coffee(int id, String nom,String description,int catégorie,int prix) {
		this.id=id;
		this.catégorie=catégorie;
		this.description=description;
		this.nom=nom;
		this.prix=prix;
	
	}
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
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCatégorie() {
		return catégorie;
	}
	public void setCatégorie(int categorie) {
		this.catégorie = categorie;
	}
	public String toString() {
		return"coffee [id="+id+",nom="+nom+",prix="+prix+",description="+description+",categ="+catégorie+"]";
	}
	

}
