package arraylist;

public class test {

	public static void main(String[] args) {
		box<orange> o = new box<orange>();
		o.createBox(new orange());
	}

}


class orange{
	@Override
	public String toString() {
		return "오렌지 박스";
	}
}
class toy{
	@Override
	public String toString() {
		return "장난감 박스";
	}
}
class apple{
	@Override
	public String toString() {
		return "사과 박스";
	}
}