package datasetGenerator;
import java.io.*;

public class DatasetGenerator {

	public static void main(String[] args) {
        
		boolean integers = false;
		
        String fileName = "superTest.dat";
        int polygons = 30;
        int maxValue = 100;
        int minValue = -100;
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
            	int randomSides = 0;
            	randomSides = (int )((Math.random() *(maxSides - minSides))+minSides);
            	String result = "P "+randomSides+" ";
            	for(int j=0; j<randomSides*2; j++){
            		if(integers) {
            			int randomValue = (int )((Math.random() *(maxValue - minValue))+minValue);
            			result += randomValue+" ";
            		}else {
            			double randomValue = (double )((Math.random() *(maxValue - minValue))+minValue);
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
