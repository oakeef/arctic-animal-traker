
public class SeaLion extends Animal{

	int numberOfSpots;
	
	public SeaLion(Sex sex, String weight, String gpsCoords, int numberOfSpots) {
		super("Sea Lion", sex, weight, gpsCoords);
		this.numberOfSpots = numberOfSpots;
	}
	
	public String toString(){
		return super.toString()+ " " + numberOfSpots + " spots";
	}

	
	
}
