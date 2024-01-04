package Liked;

public class node {
	
	private String name;
	public int index;
	private node next=null;
	
	public node() {}
	public node(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
	
}
