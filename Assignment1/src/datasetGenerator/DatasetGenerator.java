package datasetGenerator;
import java.io.*;

public class DatasetGenerator {

	public static void main(String[] args) {
        //Initiate variables and scanner
        
		boolean integers = false;
		
        String fileName = "superTest.dat";
        int polygons = 100;
        int maxValue = 10;
        int minValue = 0;
        int maxSides = 10;
        int minSides = 3;
        
        System.out.println("CD: "+ System.getProperty("user.dir"));
        File file = new File(fileName);
        
        if(file.exists() && !file.isDirectory()){
        	System.out.print("File Already Exists!, Overwriting");
        	file.delete();
        }
		String path = file.getAbsolutePath();
        try{
            PrintWriter outFile = new PrintWriter(new File(path));
    
            for(int i=0; i<polygons; i++){
            	int randomSides = (int )(Math.random() * maxSides + minSides);
            	String result = "P "+randomSides+" ";
            	for(int j=0; j<randomSides*2; j++){
            		if(integers) {
            			int randomValue = (int )(Math.random() * maxValue + minValue);
            			result += randomValue+" ";
            		}else {
            			double randomValue = (double )(Math.random() * maxValue + minValue);
            			result += randomValue+" ";
            		}
            	}
                outFile.print(result+"\r\n");
            }
            outFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
