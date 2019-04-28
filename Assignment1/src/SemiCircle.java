
public class SemiCircle extends PlanarShape{
	private Point centerPoint;
	private Point endPoint;
	
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
		//Check if endPoint is a shorter distance
		if(endPoint.getDistance() < centerPoint.getDistance()) {
			result = endPoint.getDistance();
		}
		return Math.abs(result);
	}
	
}
