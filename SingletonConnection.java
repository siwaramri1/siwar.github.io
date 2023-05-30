 package dao;

import java.sql.Connection;

import java.sql.DriverManager;

public class SingletonConnection{
	
	
	private static Connection con;
	static {
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			System.out.println("driver done");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?zeroDateTimebehavior=CONVERT8TO8NULL&serverTimezone=UTC","root","");
			System.out.println("connexion etablie avec succee");
		     } catch (Exception e) {
	e.printStackTrace();
     }
	}
	public static Connection getCon() {
		return con;
	}
}