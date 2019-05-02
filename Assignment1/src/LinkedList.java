/*
 *  ----C3282137----
 *  Ryan Jobse
 *  SENG2200 S1 2019
 *  Assignment 2
 *  
 */

import java.util.Iterator;

public class LinkedList<T> implements Iterator<T>{
	final Node<T> sentinel;
	int size;
	Node<T> curPos;
	
	public LinkedList() {
		sentinel = new Node<T>(null, null, null);
		sentinel.setNext(sentinel);
		sentinel.setPrevious(sentinel);
		curPos = sentinel;
		size = 0;
	}
	
	public void prepend(T data) {
		//Create the new Node with its Next as the sentinels next and the previous as the sentinel
		Node<T> newNode = new Node<T>(data, sentinel.getNext(), sentinel);
		//Set the sentinels next previous to the new node
		sentinel.getNext().setPrevious(newNode);
		//Set the sentinels next to the new Node
		sentinel.setNext(newNode);
		size++;
	}
	
	public void append(T data) {
		//Create the new Node with its Next as the head and the new previous as the heads previous
		Node<T> newNode = new Node<T>(data, sentinel, sentinel.getPrevious());
		//Set the sentinels previous next to the new Node
		sentinel.getPrevious().setNext(newNode);
		//Set the sentinels previous to the new Node
		sentinel.setPrevious(newNode);
		size++;
	}
	
	public void removeFromHead() {
		if(sentinel.getNext() != sentinel) {
			//Create a temporary head
			Node<T> temp = sentinel.getNext();
			//Set the heads next previous to the heads previous
			sentinel.getNext().setPrevious(sentinel);
			temp = null;
			size--;
		}
	}
	
	public int getSize() {
		return size;
	}

	public T getHead() {
		return sentinel.getNext().getData();
	}
	
	public T next() {
		if(size == 0) {
			try {
				throw new Exception("List is Empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		if(hasNext())
			curPos = curPos.getNext();
		else
			curPos = sentinel.getNext();
		return curPos.getData();
	}
	
	public boolean hasNext() {
		//Check if next is the sentinel node
		if(curPos.getNext() == sentinel)
			return false;
		return true;
	}
}
