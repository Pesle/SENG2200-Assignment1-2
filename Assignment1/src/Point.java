
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
	
	public double getDistance() {
		//Calculate the Distance from 0,0 to Point
		return Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public String toString() {
		return "("+String.format("%04.02f", x)+","+String.format("%04.02f", y)+")";
		//return "("+x+","+y+")";
	}
}
