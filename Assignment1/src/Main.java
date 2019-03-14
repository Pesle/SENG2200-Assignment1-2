
import java.util.*;
import java.io.*;

public class Main {
	
	static MyPolygons list1 = new MyPolygons();
	
	static MyPolygons list2 = new MyPolygons();

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
        
        String name = "";
        
        //Request name
        System.out.println("CD: "+ System.getProperty("user.dir"));
        System.out.println("\nFile Name: ");
        //Repeat request if left empty
        while(name.equals("")){
            name = console.next();
            System.out.println("");
        }
        
        
        importFile(name, list1);
        
        System.out.println("Unordered List");
        displayList(list1);
        
        list2 = sortList(list1);
        
        System.out.println("Ordered List");
        displayList(list2);
        
        console.close();

	}
	
	public static void importFile(String name, MyPolygons list) {
		try{
			File file = new File(name);
			Scanner inputStream = new Scanner (file);
	        
	        while (inputStream.hasNextLine ()){
	            String line = inputStream.nextLine ();
	            String splited[] = line.split(" ");
	            //Subtract the P and count the number of points
	            if(splited.length > 1){
	            	if(splited[0].equals("P")) {
	            		list.prepend(new Polygon(Integer.parseInt(splited[1])));
	            		for(int i = 2; Integer.parseInt(splited[1])*2+2 > i; i+=2) {
	                		list.getHead().addPoint(Double.parseDouble(splited[i]),Double.parseDouble(splited[i+1]));
	                	}
	                } 
	            }
	        }
	        inputStream.close ();
		}
		catch(IOException e){
            System.out.println("File Does Not Exist");
        }
	}
	
	public static void displayList(MyPolygons list) {
		if(list.getSize() > 0) {
			list.reset();
			for(int i = 0; list.getSize() > i; i++) {
				System.out.println(i+": "+list.getCurrent().toString());
				list.step();
			}
		}else {
			System.out.println("List is Empty");
		}
	}
	
	public static MyPolygons sortList(MyPolygons list) {
		MyPolygons newList = new MyPolygons();
		//Check if list is empty
		if(list.getSize() > 0) {
			//Add head to new list
			newList.append(list.getHead());
			//Progress main list
			list.step();
			
			//Go through main list
			for(int i = 1; list.getSize() > i; i++) {
				//Used for checking if it reached the end of the new list
				boolean last = true;
				
				//Reset the newList to Head
				newList.reset();
				
				//Go through new list
				for(int j = 0; newList.getSize() > j; j++) {
					
					//Check if current main list value is larger then current new list value
					if(list.getCurrent().getArea() >= newList.getCurrent().getArea()) {
						
						//Check if the values are 0.05% within each other
						if(Math.abs((newList.getCurrent().getArea()/list.getCurrent().getArea())-1) < (0.05 / 100.0)) {
							
							System.out.println(Math.abs((newList.getCurrent().getArea()/list.getCurrent().getArea())-1) + " - " + newList.getCurrent().getArea() + " - "+ list.getCurrent().getArea());
							//Check if the new values minimum is smaller then the current main
							if(newList.getCurrent().getMinDistance() > list.getCurrent().getMinDistance()) {
								last = false;
								break;
							
							}
						}
						
						//Check if the new list has reached the end of the list
						if(newList.getSize()- 1 > j) {
							//Has not reached end of list, so progress through list
							newList.step();
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
					newList.append(list.getCurrent());
					
				//If list never moved, prepend the new data
				}else if(newList.getCurrent() == newList.getHead()) {
					newList.prepend(list.getCurrent());
					
				//If list moved in the middle, insert the new data
				}else {
					newList.insert(list.getCurrent());
				}
				
				//Progress the main list
				list.step();
			}
		}else {
			System.out.println("List is Empty");
		}
		return newList;
	}
}
