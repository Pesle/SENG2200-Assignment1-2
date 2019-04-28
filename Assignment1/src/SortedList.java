
public class SortedList<T extends Comparable<T>> extends LinkedList<T>{
	SortedList(){
		super();
	}
	
	public void insertInOrder(T data_){	
		Node<T> current = sentinel.getNext();
		if(size == 0) {
			//Add the first entry
			prepend(data_);
		}else {
			//Used to find the last value in the list
			boolean last = true;
			//Used to see if the loop ever progressed
			boolean looped = false;
			
			//Go through the list
			while(current != sentinel) {
				
				//Check if current is smaller than new data
				if(current.getData().compareTo(data_) == -1) {
					
					//Check if list has reached the end
					if(current.getNext() == sentinel) {
						last = true;
						break;
						
					//If it has not reached the end, keep progressing
					}else {
						current = current.getNext();
						last = false;
					}
					
				//If it is larger, then stop the loop and add it
				}else {
					last = false;
					break;
				}
				looped = true;
				
			}
			//If list reached the end, add data to the end of the list
			if(last) {
				append(data_);
			//If the list never progressed as data was smaller, add to the start of the list
			}else if(!looped) {
				prepend(data_);
			//All else, insert data before current
			}else {
				insertBefore(current, data_);
			}
		}
	}
	
	private void insertBefore(Node<T> current, T data_) {
		//Create the new node, set its next as current, and its previous as currents previous
		Node<T> newNode = new Node<T>(data_, current, current.getPrevious());
		//Set currents previous next to new node
		current.getPrevious().setNext(newNode);
		//Set currents previous to the new node
		current.setPrevious(newNode);
		size++;
	}
	
}
