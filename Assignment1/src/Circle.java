
public class Circle extends PlanarShape{
	private Point centerPoint;
	private double radius;
	
	public Circle(double radius_){
		radius = radius_;
    }
	
	public void addPoint(double x, double y) {
		//Add new point
		centerPoint = new Point(x, y);
	}
	
	public String toString() {
		String output = "CIRC=[";
		//Add centerpoint and radius
		output += centerPoint.toString();
		output += " "+ radius;
		return output +"]: "+String.format("%05.02f", area());
		//return output +"]: "+area();
	}
	
	public double area() {
		//Calculate area of circle
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double originDistance() {
		//Get distance from origin
		return centerPoint.getDistance();
	}
	
}
