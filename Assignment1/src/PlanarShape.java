
public abstract class PlanarShape implements Comparable<PlanarShape>{
	abstract String toString();
	abstract double area();
	abstract double originDistance();


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
				}
				return -1;
			}
			return 1;
		}
		return -1;
	}
		
}