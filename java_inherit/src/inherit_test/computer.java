package inherit_test;

public abstract class computer extends house{

	float cpu; // cpu 성능
	int ram; // 램 용량
	
	computer(){}
	computer(String brand, float cpu, int ram){
		super(brand);
		this.cpu=cpu;
		this.ram=ram;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return super.brand+" , cpu : "+cpu+"Gh  ram : "+ram+"Gb";
	}
}





