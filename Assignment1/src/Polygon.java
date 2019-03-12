
public class Polygon implements ComparePoly {
	private Point pointArray[];
	private int pointArraySize;
	private int listPosition;
	
	public Polygon(int size)
    {
		//Add an extra to repeat the first entry
		pointArray = new Point[size+1];
		pointArraySize = 0;
    }
	public Polygon(int size, int listPosition)
    {
		//Add an extra to repeat the first entry
		pointArray = new Point[size+1];
		pointArraySize = 0;
		//The position in an ordered list of the Polygon
		this.listPosition = listPosition;
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
	
	public int getPosition() {
		return listPosition;
	}
	
	public void setPosition(int position) {
		listPosition = position;
	}
	
	public String toString() {
		String output = "[";
		//Get the result of every point
		for(int i = 0; i < pointArraySize+1; i++) {
			output += pointArray[i].toString();
		}
		return output +"]: "+getArea();
	}
	
	public double getArea() {
		double result = 0.0;
		//Get every point and sum it all together
		for(int i = 0; i < pointArraySize; i++) {
			result += ( pointArray[i+1].getX() + pointArray[i].getX() ) * ( pointArray[i+1].getY() - pointArray[i].getY() );
		}
		//Divide the result by 2
		return result / 2;
	}

	public boolean ComesBefore(Polygon o) {
		//Check if the current Polygon is behind o
		if(o.getPosition() > listPosition) {
			return true;
		}
		return false;
	}
}
