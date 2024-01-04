package ArrayList_test;

public class food {
	
	private String foodName;
	private int cost;
	private String spicy;
	
	public food() {	}
	public food(String name, int cost, String spicy) {
		this.foodName=name;
		this.cost=cost;
		this.spicy=spicy;
	}
	
	@Override
	public String toString() {
		return "음식 : "+foodName+" 가격 : "+cost+"원  맵기 : "+spicy;
	}
	
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getSpicy() {
		return spicy;
	}
	public void setSpicy(String spicy) {
		this.spicy = spicy;
	}
	
	
}




