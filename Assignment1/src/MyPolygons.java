
public class MyPolygons {
	Node head;
	Node current;
	int size;
	
	public MyPolygons() {
		size = 0;
	}
	
	public void prepend(Polygon data) {
		if(size == 0) {
			//If the list is empty, set new node as head
			head = new Node(data, null, null);
			current = head;
			size = 1;
		}else {
			//Create the new Node with its Next as the head and the new previous as the heads previous
			current = new Node(data, head, head.getPrevious());
			//Set the heads previous next to the new Node
			head.getPrevious().setNext(current);
			//Set the heads previous to the new Node
			head.setPrevious(current);
			//Set the new Node as Head
			head = current;
			size++;
		}
	}
	
	public void append(Polygon data) {
		if(size == 0) {
			//If the list is empty, set new node as head
			head = new Node(data, null, null);
			current = head;
			size = 1;
		}else {
			//Create the new Node with its Next as the head and the new previous as the heads previous
			current = new Node(data, head, head.getPrevious());
			//Set the heads previous next to the new Node
			head.getPrevious().setNext(current);
			//Set the heads previous to the new Node
			head.setPrevious(current);
			size++;
		}
	}
	
	public void insert(Polygon data) {
		if(size == 0) {
			//If the list is empty, set new node as head
			head = new Node(data, null, null);
			current = head;
			size = 1;
		}else {
			//Create the new Node with its Next as the current and the new previous as the currents previous
			Node newNode = new Node(data, current, current.getPrevious());
			//Set the currents previous next to the new Node
			current.getPrevious().setNext(newNode);
			//Set the currents previous to the new Node
			current.setPrevious(newNode);
			size++;
		}
	}
	
	public void step() {
		if(size == 0) {
			current = null;
		}else {
			//Set current to the previous currents next
			current = current.getNext();
		}
	}
	
	public void reset() {
		if(size == 0) {
			current = null;
		}else {
			//Reset current as head
			current = head;
		}
	}
	
	public void removeFromHead() {
		if(size > 0) {
			if(size == 1) {
				//If size is 1, remove the head and current
				head = null;
				size = 0;
				current = null;
			}else {
				//Create a temporary head
				Node temp = head;
				//Set the heads previous next to the heads next
				head.getPrevious().setNext(head.getNext());
				//Set the heads next previous to the heads previous
				head.getNext().setPrevious(head.getPrevious());
				//Set head as the heads next
				head = temp.getNext();
				//Remove temp
				temp = null;
				size--;
			}
		}
	}
	
	public Polygon getHead() {
		return head.getData();
	}
	
	public Polygon getCurrent() {
		return current.getData();
	}
	
	public int getSize() {
		return size;
	}
}
