package Week4MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteFoodsDao {

	private Connection connection;
	private final String GET_FAVORITEFOODS_QUERY = "SELECT * FROM favoritefoods";
	private final String GET_FAVORITEFOODS_BY_TYPE_QUERY = "SELECT * FROM favoritefoods";
	private final String CREATE_NEW_FAVORITEFOODS_QUERY = "INSERT INTO favoritefoods(type) VALUES(?)";
	
	public FavoriteFoodsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<FavoriteFoods> getFavoriteFoods() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_FAVORITEFOODS_QUERY).executeQuery();
		List<FavoriteFoods> foods = new ArrayList<FavoriteFoods>();
		
		while (rs.next()) {
			foods.add(populateFavoriteFoods(rs.getString(1), rs.getString(2)));
		}
		
		return foods;
		
	}
	
	public FavoriteFoods getFoodsByType(String type) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_FAVORITEFOODS_BY_TYPE_QUERY);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateFavoriteFoods(rs.getString(1), rs.getString(2));
	}
	
	public void createNewTeam(String food) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FAVORITEFOODS_QUERY);
		ps.setString(1, food);
		ps.executeUpdate();
	}
	
	private FavoriteFoods populateFavoriteFoods( String type, String food) {
		return new FavoriteFoods(type, food);
	}
	
}
