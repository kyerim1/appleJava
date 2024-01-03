package arraylist;

public class book implements Comparable<book>{
	
	private String title;
	private String writer;
	private int year;
	
	public book() {}
	public book(String title, String writer, int year) {
		this.title=title;
		this.writer=writer;
		this.year=year;
	}
	
	@Override
	public int compareTo(book b) {
		
		return this.title.compareTo(b.title) * -1;
		//return (this.year - b.year)*-1;
	}
	
	@Override
	public String toString() {
		return "제목 : "+title+" 저자 : "+writer+" 출간년도 : "+year+"년";
	}
	
	@Override
	public boolean equals(Object o) {
		String title = (String)o;
		
		return this.title.equals(title);
		
//		book tmp = (book)o; // 비교할 객체
//		
//		boolean same1 = this.title.equals(tmp.title);
//		boolean same2 = this.writer.equals(tmp.writer);
//		boolean same3 = this.year == tmp.year;
//		
//		return same1 && same2 && same3;
	}
	
	/*
	 *   String[] n = new String[]{"가","나","다","라","마"};
	 *   
	 *   for( int i=0; i<n.length(); i++){
	 *   	if(  n[i].equals("다") ){
	 *   		return i;
	 *   	}
	 *   }
	 * 
	 */
	
	
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




