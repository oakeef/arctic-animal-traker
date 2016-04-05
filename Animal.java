
public abstract class Animal {

	String species;
	Sex sex;
	String weight;
	String gpsCoords;
	
	public Animal(String species, Sex sex, String weight, String gpsCoords){
		this.species = species;
		this.sex = sex;
		this.weight = weight;
		this.gpsCoords = gpsCoords;
		
	}
	
	public String toString(){
		return species + " " + sex + " " + weight + " kg " + " GPS: " + gpsCoords;
	}
}
