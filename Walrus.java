
public class Walrus extends Animal{

	DentalHealth dentalHealth;
	
	public Walrus(Sex sex, String weight, String gpsCoords, DentalHealth dentalHealth) {
		super("Walrus", sex, weight, gpsCoords);
		this.dentalHealth = dentalHealth;
		
	}

	public String toString(){
		return super.toString() + " Dental Health: "+ dentalHealth;
	}
	
	
}
