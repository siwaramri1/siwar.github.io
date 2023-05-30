package metier;

import java.util.List;
//interface crud qui va prendre un objet de type Produit
public interface Crud<Objet> {
	
		public List<Objet> getAll();
		public int add(Objet o);
		public int delete(Objet o);
		public int update(Objet o);
		
	}
