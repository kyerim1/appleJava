package cafe;

public class menu {
	
	private String menu_name; //이름
	private int caffeine; //카페인
	private int calorie; //칼로리
	private int ml; // 용량
	private int cost1; //hot, basic
	private int cost2;// ice, soft
	private Category type; // 분류
	
	
	public menu() {}// 기본 생성자 메서드
	public menu(String menu_name, int cost1, int cost2, int caffeine,
			int calorie, int ml, Category type) { //매개변수가 있는 생성자 메서드
		this.menu_name=menu_name;
		this.cost1=cost1;
		this.cost2=cost2;
		this.caffeine=caffeine;
		this.calorie=calorie;
		this.ml=ml;
		this.type=type;
	}
	
	
	@Override
	public String toString() {
		
		return menu_name;
	}
	
	
	
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(int caffeine) {
		this.caffeine = caffeine;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getMl() {
		return ml;
	}
	public void setMl(int ml) {
		this.ml = ml;
	}
	public int getCost1() {
		return cost1;
	}
	public void setCost1(int cost1) {
		this.cost1 = cost1;
	}
	public int getCost2() {
		return cost2;
	}
	public void setCost2(int cost2) {
		this.cost2 = cost2;
	}
	public Category getType() {
		return type;
	}
	public void setType(Category type) {
		this.type = type;
	}
	
}
