
public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y)
    {
		this.x = x;
		this.y = y;
    }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getDistance(Point origin) {
		return Math.sqrt( Math.pow( origin.getX()-x , 2) + Math.pow( origin.getY()-y , 2));
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
