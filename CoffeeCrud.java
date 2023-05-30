package metier;
import java.sql.PreparedStatement;
 


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.SingletonConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoffeeCrud implements Crud<Coffee>{
	
public ObservableList<Coffee> getAll() {
	PreparedStatement ps;
	Coffee c;
	ObservableList<Coffee> cc= FXCollections.observableArrayList();
	try {   
		ps=SingletonConnection.getCon().prepareStatement("SELECT * FROM coffee;");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			c=new Coffee(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getInt("catégorie"),rs.getInt("prix"));
		    cc.add(c);
		}
	          
	       rs.close();
       }catch(SQLException e) {
	e.printStackTrace();}
	return cc;
}

@Override
public int add(Coffee o) {
	PreparedStatement ps;
	try{
		ps=SingletonConnection.getCon().prepareStatement("insert into`coffee`(`nom`,`description`,`catégorie`,`prix`)values(?,?,?,?);");
	
	ps.setString(1,o.getNom());
	ps.setString(2,o.getDescription());
	ps.setInt(3,o.getCatégorie());
	ps.setInt(4,o.getPrix());
	ps.executeUpdate();
	
	System.out.println("insertion effectue avec succes");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
}

@Override
public int delete(Coffee o) {
	// TODO Auto-generated method stub
	PreparedStatement ps;
	try{
		ps=SingletonConnection.getCon().prepareStatement("delete from coffee where id=?");
		 ps.setInt(1, o.getId());
		ps.executeUpdate();
		System.out.println("suppression effectue avec succes");
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}

@Override
public int update(Coffee o) {
	PreparedStatement ps;
	try{
		ps = SingletonConnection.getCon().prepareStatement("UPDATE `coffee` SET `nom`=?, `description`=?, `catégorie`=?, `prix`=? WHERE `id`=?");
        ps.setString(1, o.getNom());
        ps.setString(2, o.getDescription());
        ps.setInt(3, o.getCatégorie());
        ps.setDouble(4, o.getPrix());
        ps.setInt(5, o.getId());
        ps.executeUpdate();
	System.out.println("update effectue avec succes");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
}
}
