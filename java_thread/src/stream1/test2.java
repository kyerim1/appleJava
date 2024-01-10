package stream1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class member{
	private String name;
	private int age;
	private String tel;
	private String addr;
	
	public member(String name, int age, String tel, String addr) {
		this.name=name;
		this.age=age;
		this.tel=tel;
		this.addr=addr;
	}
	
	@Override
	public String toString() {
		return name+" : "+age+"세 : "+tel+" : "+addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}

public class test2 {

	public static void main(String[] args) {
		List<member> list = new LinkedList<member>();
		list.add( new member("이순신",34,"01012349999","아산시 초산동"));
		list.add( new member("김유신",29,"01088883434","경주시 충효동"));
		list.add( new member("장보고",45,"01077226453","진도군 진도읍"));
		list.add( new member("장영실",37,"01043437586","대전광역시 중구"));
		list.add( new member("이장대",25,"01000118844","대전광역시 서구"));

		Stream<member> 나이 = list.stream().filter( m -> m.getAge() >= 30);
		나이.forEach(System.out::println);
		
		Stream<member> 대전 = list.stream()
						.filter( mem -> mem.getAddr().contains("대전광역시") );
		대전.forEach(System.out::println);
		
		
		Stream<Integer> 연령대 = list.stream().map( m -> m.getAge()/10);
		System.out.println( 연령대.filter(n->n==3).count() );
		
		//member 클래스 객체에서 연락처의 010을 제외한 값으로 변환 된 객체들을 뽑아내고 싶다면
		// filter를 통해서는 member클래스 객체가 나왔는데  map도 가능한가?
		// map은 새로운 요소로 매핑 하는역할을 하기때문에 반환타입이 반드시 존재 해야한다.
		// member클래스 타입으로 반환 되려면 member클래스 갑시 나올수 있도록 작업해야 하는데
		// 스트림의 각요소의 객체 상태를 변경하려면 map 아니라 forEach를 사용해야한다.
		// 즉 map에서는 객체를 상태변화를 할 수 가 없다.
		
		list.stream()
				.forEach( m -> m.setTel(m.getTel().substring(3)));
		
		list.forEach( System.out::println);
		
		List<score> std = Arrays.asList( new score(56,45,78) , new score(23,87,99),
				new score(88,77,66) );
		
		std.stream().flatMapToInt( student -> 
				IntStream.of(student.getEng(), student.getKor(), student.getMat()))
		.average().ifPresent( avg->System.out.println( Math.round(avg*10)/10.0) );
	}

}


class score{
	private int kor;
	private int mat;
	private int eng;
	
	public score(int kor, int mat, int eng) {
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
}

