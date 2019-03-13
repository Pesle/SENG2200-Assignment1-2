
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
        
        displayList(list1);
        
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
	            int size = (splited.length-1)/2;
	            if(splited.length > 1){
	            	if(splited[0].equals("P")) {
	            		list.prepend(new Polygon(size));
	            		for(int i = 1; i > size; i+=2) {
	                		list.getHead().addPoint(Integer.parseInt(splited[i]),Integer.parseInt(splited[i+1]));
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
}
