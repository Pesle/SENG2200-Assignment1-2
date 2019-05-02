/*
 *  ----C3282137----
 *  Ryan Jobse
 *  SENG2200 S1 2019
 *  Assignment 2
 *  
 */

public class Node<T> {
	Node<T> next;
	Node<T> previous;
	
	T data;
	
	public Node(T data, Node<T> next, Node<T> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	
	public Node<T> getNext() {
		return next;
	}
	public Node<T> getPrevious() {
		return previous;
	}
	public T getData() {
		return data;
	}
}
