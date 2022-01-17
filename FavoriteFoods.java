package Week4MySQL;

public class FavoriteFoods {
	
	private String type;
	private String food;
	
	public FavoriteFoods (String type, String food) {
		this.setType(type);
		this.setFood(food);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	

}
