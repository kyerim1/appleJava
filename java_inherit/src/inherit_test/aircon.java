package inherit_test;

public class aircon extends house{

	int temp=22; //온도
	int speed=1; // 풍속
	
	aircon(){}
	aircon(String brand){
		super(brand);
	}
	
	public void power() {
		onoff = !onoff;
		System.out.println( "에어컨 전원 : " + onoff);
	}
	
	
	
	
	@Override
	public String toString() {
		return super.brand+" , 전원 : "+super.onoff+" 온도:"+temp+"℃  바람:"+speed;
	}
}



