
public class Polygon implements ComparePoly {
	private Point pointArray[];
	private int pointArraySize;
	
	public Polygon(int size)
    {
		//Add an extra to repeat the first entry
		pointArray = new Point[size+1];
		pointArraySize = 0;
    }

	public void addPoint(double x, double y) {
		//Add new point into array
		pointArray[pointArraySize] = new Point(x, y);
		
		//If it is the first Point, add it to the last element in the array as well
		if(pointArraySize == 0) {
			pointArray[pointArray.length-1] = new Point(x, y);
		}
		pointArraySize++;
	}
	
	public String toString() {
		String output = "[";
		//Get the result of every point
		for(int i = 0; i < pointArraySize+1; i++) {
			output += pointArray[i].toString();
		}
		return output +"]: "+String.format("%05.02f", getArea());
	}
	
	public double getArea() {
		double result = 0.00;
		//Get every point and sum it all together
		for(int i = 0; i < pointArraySize; i++) {
			result += ( pointArray[i+1].getX() + pointArray[i].getX() ) * ( pointArray[i+1].getY() - pointArray[i].getY() );
		}
		//Divide the result by 2 and make it absolute
		result = Math.abs(result / 2.00);
		return result;
	}
	
	public double getMinDistance() {
		//Set minimum distance to the first point
		double result = pointArray[0].getDistance();
		
		//Go through every point and compare it to the current minimum
		for(int i = 1; i < pointArraySize; i++) {
			
			//If current point is smaller, set as new minimum
			if(pointArray[i].getDistance() < result) {
				result = pointArray[i].getDistance();
			}
		}
		return result;
	}

	public boolean ComesBefore(Object o) {
		//Check if the current Polygon is behind o
		if(this.getArea() >= ((Polygon) o).getArea())
			return true;
		return false;
	}
}
