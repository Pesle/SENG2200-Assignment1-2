
public class Node {
	Node next;
	Node previous;
	
	Polygon data;
	
	public Node(Polygon data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public Node getNext() {
		return next;
	}
	public Node getPrevious() {
		return previous;
	}
	public Polygon getData() {
		return data;
	}
}
