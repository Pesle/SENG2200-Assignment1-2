
public class LinkedList<T> implements Iterator<T>{
	Node<T> head;
	int size;
	
	public LinkedList() {
		size = 0;
	}
	
	public void prepend(T data) {
		if(size == 0) {
			//If the list is empty, set new node as head
			head = new Node<T>(data, null, null);
			head.setNext(head);
			head.setPrevious(head);
			size = 1;
		}else {
			//Create the new Node with its Next as the head and the new previous as the heads previous
			Node<T> newNode = new Node<T>(data, head, head.getPrevious());
			//Set the heads previous next to the new Node
			head.getPrevious().setNext(newNode);
			//Set the heads previous to the new Node
			head.setPrevious(newNode);
			//Set the new Node as Head
			head = newNode;
			size++;
		}
	}
	
	public void append(T data) {
		if(size == 0) {
			//If the list is empty, set new node as head
			head = new Node<T>(data, null, null);
			head.setNext(head);
			head.setPrevious(head);
			size = 1;
		}else {
			//Create the new Node with its Next as the head and the new previous as the heads previous
			Node<T> newNode = new Node<T>(data, head, head.getPrevious());
			//Set the heads previous next to the new Node
			head.getPrevious().setNext(newNode);
			//Set the heads previous to the new Node
			head.setPrevious(newNode);
			size++;
		}
	}
	
	public void removeFromHead() {
		if(size > 0) {
			if(size == 1) {
				//If size is 1, remove the head
				head = null;
				size = 0;
			}else {
				//Create a temporary head
				Node<T> temp = head;
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
	
	public T getHead() {
		return head.getData();
	}
	
	public int getSize() {
		return size;
	}
}
