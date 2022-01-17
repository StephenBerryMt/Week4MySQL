package Week4MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Week4Project {

			
			public static void main(String[] args) {
				String connectionString = "jdbc:mysql://localhost:3306/favoritefoods";
				final String SELECT_QUERY = "SELECT * FROM favoritefoods LIMIT 20";

				try {
				Connection conn = DriverManager.getConnection(connectionString, "root", "2580");
				System.out.println("Connection Successful!");
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(SELECT_QUERY);

				//while (rs.next()) {
				System.out.println();
				//}
				} catch (SQLException e) {
				System.out.println("Connection failed!");
				e.printStackTrace();
				   }
				}



	

	
}
