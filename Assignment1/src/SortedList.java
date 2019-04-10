
public class SortedList<T> extends LinkedList<T>{
	SortedList(){
		super();
	}
	
	public void insertInOrder(LinkedList<T> list){	
		//Check if list is empty
		if(list.getSize() > 0) {
			//Add head to new list
			this.append(list.getHead());
			
			System.out.println(" 0	 Appended	 "+String.format("%05.06f", list.getCurrent().getArea()));
			
			//Progress main list
			list.step();
			
			//Go through main list
			for(int i = 1; list.getSize() > i; i++) {
				//Used for checking if it reached the end of the new list
				boolean last = true;
				
				//Reset the this to Head
				this.reset();
				
				//Go through new list
				for(int j = 0; this.getSize() > j; j++) {
					
					//Check if current main list value comes before current new list value
					if(list.getCurrent().ComesBefore(this.getCurrent())) {
						
						//Check if the values are 0.05% within each other
						if(Math.abs((this.getCurrent().getArea()/list.getCurrent().getArea())-1) < (0.05 / 100.0)) {
							
							System.out.println(" "+i+ "	 0.05% Diff	 "+String.format("%05.06f", this.getCurrent().getArea())+" - "+ String.format("%05.06f", list.getCurrent().getArea()));
							
							//Check if the new values minimum is smaller then the current main
							if(this.getCurrent().getMinDistance() > list.getCurrent().getMinDistance()) {
								last = false;
								break;
							
							}
						}
						
						//Check if the new list has reached the end of the list
						if(this.getSize()- 1 > j) {
							//Has not reached end of list, so progress through list
							this.step();
							last = false;
						}else {
							//Has reached the end of the list
							last = true;
						}
						
					}else {
						//Has not reached the end of the list, but is smaller then the new list value
						last = false;
						break;
					}
				}
				//If list reached the end, append the new data
				if(last == true) {
					this.append(list.getCurrent());
					System.out.println(" "+i+ "	 Appended	 "+String.format("%05.06f", list.getCurrent().getArea()));
					
				//If list never moved, prepend the new data
				}else if(this.getCurrent() == this.getHead()) {
					this.prepend(list.getCurrent());
					System.out.println(" "+i+ "	 Prepended	 "+String.format("%05.06f", list.getCurrent().getArea()));
					
				//If list moved in the middle, insert the new data
				}else {
					this.insert(list.getCurrent());
					System.out.println(" "+i+ "	 Inserted	 "+String.format("%05.06f", list.getCurrent().getArea()));
				}
				
				//Progress the main list
				list.step();
			}
			System.out.println("DONE Sort\n");
		}else {
			System.out.println("List is Empty");
		}
	}
}
