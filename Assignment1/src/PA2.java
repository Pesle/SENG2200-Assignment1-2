
import java.util.*;
import java.io.*;

public class PA2 {
	
	static LinkedList<PlanarShape> list1 = new LinkedList<PlanarShape>();
	
	static SortedList<PlanarShape> list2 = new SortedList<PlanarShape>();
	
	static boolean importDebug = false;
    static boolean sortDebug = false;

	public static void main(String[] args) {
     
		if(args.length == 0) {
			System.out.println("Needs Arguments");
		}else {
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

	}
	
	public static void importFile(String name, LinkedList<PlanarShape> list) {
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
	
	public static void displayList(LinkedList<PlanarShape> list) {
		if(list.getSize() > 0) {
			while(list.hasNext())
				list.next();
			for(int i = 0; list.getSize() > i; i++) {
				System.out.println(i+":	"+list.next().toString());
			}
		}else {
			System.out.println("List is Empty");
		}
	}
	
	public static SortedList<PlanarShape> sortList(LinkedList<PlanarShape> list){
		SortedList<PlanarShape> newList = new SortedList<PlanarShape>();
		if(list.getSize() > 0) {
			for(int i = 0; list.getSize() > i; i++) {
				newList.insertInOrder(list.next());
			}
		}else {
			System.out.println("List is Empty");
		}
		return newList;
	}
	
}
