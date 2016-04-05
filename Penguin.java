
public class Penguin extends Animal {

	double bloodPressure;
	
	public Penguin(Sex sex, String weight, String gpsCoords, double bloodPressure) {
		super("Penguin", sex, weight, gpsCoords);
		this.bloodPressure = bloodPressure;
	}

	public String toString(){
		return super.toString() + " Blood Pressure: "+ bloodPressure;
	}
	
	
}
