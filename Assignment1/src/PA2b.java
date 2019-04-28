
import java.util.*;
import java.io.*;

public class PA2b {
	
	static LinkedList<PlanarShape> list1 = new LinkedList<PlanarShape>();
	
	static SortedList<PlanarShape> list2 = new SortedList<PlanarShape>();
	
	static boolean importDebug = false;
    static boolean sortDebug = false;

	public static void main(String[] args) {
		run(args);
	}
	
	public static void run(String[] args) {
		if(args.length == 0) {
			System.out.println("Needs Arguments!");
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
	            PlanarShape newShape = shapeFactory(line);
	            if(newShape != null) {
	            	list.prepend(newShape);
	            }
	        }
	        inputStream.close ();
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
	
	public static PlanarShape shapeFactory(String line) {
		PlanarShape shape = null;
		String splited[] = line.split(" ");
		//Check the first line
		switch(splited[0]) {
			//If polygon
			case "P":
				shape = new Polygon(Integer.parseInt(splited[1]));
				//Go through splited data and add points to shape
				for(int i = 2; Integer.parseInt(splited[1])*2+2 > i; i+=2) {
					if(!splited[i].equals(" ") && !splited[i].equals("") && !splited[i+1].equals(" ") && !splited[i+1].equals("")) {
			    		shape.addPoint(Double.parseDouble(splited[i]),Double.parseDouble(splited[i+1]));
					}
		    	}
				break;
			//If circle
			case "C":
				shape = new Circle(Double.parseDouble(splited[3]));
				//Add centerPoint
		    	shape.addPoint(Double.parseDouble(splited[1]),Double.parseDouble(splited[2]));
				break;
			//If SemiCircle
			case "S":
				shape = new SemiCircle(Double.parseDouble(splited[3]),Double.parseDouble(splited[4]));
				//Add centerPoint
		    	shape.addPoint(Double.parseDouble(splited[1]),Double.parseDouble(splited[2]));
				break;
			default:
				System.out.println(splited[0] + ": Unknown Shape!");
		}
		return shape;
	}
}
