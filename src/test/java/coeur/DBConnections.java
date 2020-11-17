package coeur;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.*;


public class DBConnections {
	public static Connection mysqlconnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/flight?";
		String usernamepassword = "user=root&password=root";
		Connection conn = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + usernamepassword);
			System.out.println("Connected to database successfully");

		} catch (Exception e) {
			System.out.println("Could not connect to database");
		}
		return conn;

	}
	
	
	
	public static Node jcrConnection() throws RepositoryException {
		
		Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
		javax.jcr.Session session = repository.login( new SimpleCredentials("admin", "admin".toCharArray()));
		Node root = session.getRootNode();
		Node node = root.getNode("content/we-retail/us/en/men");
		return node;
		
	
	}
	
	
	public static void addComponent(Node node) {}
		

	
	
	
	
	
}
