package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import exceptions.ConnessioneException;


public class SingletonConnection {
	
	private static Connection conn;
	private static ResourceBundle rb = ResourceBundle.getBundle("risorse/info");
	private static String stringConnection = rb.getString("jdbc.stringConnection");
	private static String idConnection=rb.getString("jdbc.username");
	private static String passConnection=rb.getString("jdbc.password");
	
	
	private SingletonConnection() throws ConnessioneException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(stringConnection,idConnection,passConnection);
		} catch (Exception e) {
			throw new ConnessioneException(e.getMessage());
		}
	}
	
	public static Connection getInstance()throws ConnessioneException{
		if(conn==null)
			new SingletonConnection();
		
		return conn; //commento per commit
	}

}
