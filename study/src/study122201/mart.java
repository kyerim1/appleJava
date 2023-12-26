package study122201;

import java.text.DecimalFormat;

public class mart {
	String product_name; //제품명
	int price;  // 제품가격
	String category; //제품 분류
	int quan;  // 수량
	
	mart(){}
	mart(String name, int price, String category, int quan){
		this.product_name=name;
		this.price=price;
		this.category=category;
		this.quan=quan;
	}
	
	@Override
	public String toString() {
		String price_ = Integer.toString( price).replaceAll("\\B(?=(\\d{3})+(?!\\d))", "," );
		DecimalFormat df = new DecimalFormat("###,###");
		String quan_ = df.format(quan);
		
		return product_name+" - "+price_+"원 ("+quan_+"개)";
	}
}



