
import java.util.*;
import java.io.*;

public class PA1 {
	
	static MyPolygons list1 = new MyPolygons();
	
	static MyPolygons list2 = new MyPolygons();
	
	static boolean importDebug = false;
    static boolean sortDebug = false;

	public static void main(String[] args) {
     
        String name = args[0];
        
        //Request name
        System.out.println("File: "+ System.getProperty("user.dir") + "\\" + name + "\n");
        
        importFile(name, list1);
        
        list2 = sortList(list1);
        
        System.out.println("Unordered List");
        displayList(list1);
        
        System.out.println(" ");
        
        System.out.println("Ordered List");
        displayList(list2);

	}
	
	public static void importFile(String name, MyPolygons list) {
		try{
			if(importDebug) System.out.println("Importing...");
			File file = new File(name);
			Scanner inputStream = new Scanner (file);
	        
	        while (inputStream.hasNextLine ()){
	            String line = inputStream.nextLine ();
	            String splited[] = line.split(" ");
	            //Subtract the P and count the number of points
	            if(splited.length > 1){
	            	if(splited[0].equals("P")) {
	            		
	            		if(importDebug) System.out.print("Adding Row: "+list.getSize());
	            		
	            		list.prepend(new Polygon(Integer.parseInt(splited[1])));
	            		for(int i = 2; Integer.parseInt(splited[1])*2+2 > i; i+=2) {
	                		list.getHead().addPoint(Double.parseDouble(splited[i]),Double.parseDouble(splited[i+1]));
	                	}
	            		if(importDebug) System.out.println(" "+list.getCurrent().toString());
	                } 
	            }
	        }
	        inputStream.close ();
	        if(importDebug) System.out.println("DONE Import\n");
		}
		catch(IOException e){
            System.out.println("File Does Not Exist");
        }
	}
	
	public static void displayList(MyPolygons list) {
		if(list.getSize() > 0) {
			list.reset();
			for(int i = 0; list.getSize() > i; i++) {
				System.out.println(i+":	"+list.getCurrent().toString());
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
			if(sortDebug) System.out.println("Sorting...\n"+"Pos	Insert Type	Area");
			//Add head to new list
			newList.append(list.getHead());
			
			if(sortDebug) System.out.println(" 0	 Appended	 "+String.format("%05.06f", list.getCurrent().getArea()));
			
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
					
					//Check if current main list value comes before current new list value
					if(list.getCurrent().ComesBefore(newList.getCurrent())) {
						
						//Check if the values are 0.05% within each other
						if(Math.abs((newList.getCurrent().getArea()/list.getCurrent().getArea())-1) < (0.05 / 100.0)) {
							
							if(sortDebug) System.out.println(" "+i+ "	 0.05% Diff	 "+String.format("%05.06f", newList.getCurrent().getArea())+" - "+ String.format("%05.06f", list.getCurrent().getArea()));
							
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
					if(sortDebug) System.out.println(" "+i+ "	 Appended	 "+String.format("%05.06f", list.getCurrent().getArea()));
					
				//If list never moved, prepend the new data
				}else if(newList.getCurrent() == newList.getHead()) {
					newList.prepend(list.getCurrent());
					if(sortDebug) System.out.println(" "+i+ "	 Prepended	 "+String.format("%05.06f", list.getCurrent().getArea()));
					
				//If list moved in the middle, insert the new data
				}else {
					newList.insert(list.getCurrent());
					if(sortDebug) System.out.println(" "+i+ "	 Inserted	 "+String.format("%05.06f", list.getCurrent().getArea()));
				}
				
				//Progress the main list
				list.step();
			}
			if(sortDebug) System.out.println("DONE Sort\n");
		}else {
			System.out.println("List is Empty");
		}
		return newList;
	}
}
