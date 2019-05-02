
public class SemiCircle extends PlanarShape{
	private Point centerPoint;	//0
	private Point endPoint;		//1
	
	public SemiCircle(double x, double y){
		endPoint = new Point(x, y);
		
    }
	
	public void addPoint(double x, double y) {
		//Add new point
		centerPoint = new Point(x, y);
	}
	
	public String toString() {
		String output = "SEMI=[";
		//Add centerpoint and radius
		output += centerPoint.toString() + endPoint.toString();
		return output +"]: "+String.format("%05.02f", area());
		//return output +"]: "+area();
	}
	
	public double area() {
		//Calculate distance between centerpoint and endpoint as radius
		double radius = Math.sqrt(Math.pow(endPoint.getX()-centerPoint.getX(), 2) + Math.pow(endPoint.getY()-centerPoint.getY(), 2));
		//Calculate area of circle
		return (Math.PI * Math.pow(radius, 2))/2;
	}
	
	public double originDistance() {
		//Set minimum distance to the first point
		double result = centerPoint.getDistance();
		
		//Get normal vectors from points
		Point normalA = new Point(
				-(endPoint.getY()-centerPoint.getY()),
				endPoint.getX()-centerPoint.getX());
		Point normalB = new Point(
				endPoint.getY()-centerPoint.getY(),
				-(endPoint.getX()-centerPoint.getX()));
		
		//Get extreme points
		Point extremeA = getExtreme(normalA);
		Point extremeB = getExtreme(normalB);
		
		//Check for the shortest distance to origin
		if(endPoint.getDistance() < centerPoint.getDistance()) {
			result = endPoint.getDistance();
		}
		if(extremeA.getDistance() < result) {
			result = extremeA.getDistance();
		}
		if(extremeB.getDistance() < result) {
			result = extremeB.getDistance();
		}
		return Math.abs(result);
	}
	
	private Point getExtreme(Point NormalVector) {
		return new Point(centerPoint.getX() + NormalVector.getX(), centerPoint.getY() + NormalVector.getY());
	}
	
}
