/*
 *  ----C3282137----
 *  Ryan Jobse
 *  SENG2200 S1 2019
 *  Assignment 2
 *  
 */

public abstract class PlanarShape implements Comparable<PlanarShape>{
	public abstract void addPoint(double x, double y);
	public abstract String toString();
	public abstract double area();
	public abstract double originDistance();


	public interface Comparable {
		public int compareTo(PlanarShape o);
	}
	
	public int compareTo(PlanarShape o) {	
		//Check if this is larger then O
		if(this.area() >= o.area()) {
			//Check if this is 0.005 within O
			if(Math.abs((o.area()/this.area())-1) < 0.005) {
				//Check if this has a smaller origin distance than O
				if(this.originDistance() >= o.originDistance()) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return 1;
			}
		}else {
			return -1;
		}
	}
		
}