package metier;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.SingletonConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategorieCrud implements Crud<Categorie>{
	 
	public  ObservableList<Categorie> getAll() {
		PreparedStatement ps;
		Categorie c;
		ObservableList<Categorie> cc= FXCollections.observableArrayList();
		try {   
			ps=SingletonConnection.getCon().prepareStatement("SELECT * FROM `catégorie`;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Categorie(rs.getInt("id"),rs.getString("nom"));
			    cc.add(c);
			}
		          
		       rs.close();
	       }catch(SQLException e) {
		e.printStackTrace();}
		return cc;
	}
	public int add (Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try{
			ps=SingletonConnection.getCon().prepareStatement("insert into`catégorie`(`nom`)values(?);");
		
		ps.setString(1,o.getNom());
		
		ps.executeUpdate();
		
		System.out.println("insertion effectue avec succes");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try{
			ps=SingletonConnection.getCon().prepareStatement("delete from catégorie where id=?");
			 ps.setInt(1, o.getId());
			ps.executeUpdate();
			System.out.println("suppression effectue avec succes");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public  int update(Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try{
			ps=SingletonConnection.getCon().prepareStatement("UPDATE `catégorie` SET nom=? WHERE  id=?");
			 ps.setString(1, o.getNom());
			 ps.setInt(2, o.getId());
		ps.executeUpdate();
		System.out.println("update effectue avec succes");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	

}
