package Week4MySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Menu {
	
	private FavoriteFoodsDao favoriteFoodsDao = new FavoriteFoodsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display foods", 
			"Add food", 
			"Delete food");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayFoods();
			} else if (selection.equals("2")) {
				addFood();
			}else if (selection.equals("3")) {
				deleteFood();
			}
			
			System.out.println("press enter to continue");
			scanner.nextLine();
		} while (!selection.equals("-1"));	
	}

	private void printMenu() {
		System.out.println("Select an Option:\n-------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayFoods() throws SQLException {
		List<FavoriteFoods> foods = favoriteFoodsDao.getFavoriteFoods();
		for (FavoriteFoods : foods) {
			System.out.println(FavoriteFoods.getFavoriteFoodsType() + ": " + favoriteFoods.getFood());
		}
	}
	
	private void addFood() {
		System.out.println("enter new food type:");
		String type = scanner.nextLine();
		System.out.println("what is the name of the food:");
		String food = scanner.nextLine();
		FavoriteFoodsDao.createFood(type, food);
	}
	
	private void deleteFood() {
	PreparedStatement ps = connection.preparedStatement(DELETE_FOOD_QUERY);
	ps.setString(1, type);
	ps.executeUpdate();
	}
	
}
