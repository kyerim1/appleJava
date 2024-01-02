package data_class;

public class book {
	
	private String title;
	private String writer;
	private int year;
	
	public book() {}
	public book(String title, String writer, int year) {
		this.title=title;
		this.writer=writer;
		this.year=year;
	}
	public book(String title, String writer, String year) {
		this.title=title;
		this.writer=writer;
		this.year=Integer.parseInt(year);
	}
	
	
	@Override
	public String toString() {
		return "제목 : "+title+"  저자 : "+writer+"  출간년도 : "+year+"년";
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}



