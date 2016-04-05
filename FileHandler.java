import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {

	public void writeAnimals(ArrayList<Animal> animalList){
		File file = new File("animalList.txt");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			for(Animal animal: animalList){
				
				printWriter.println(animal);
				
			}//end for
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}// end WriteAnimals
	
	public String readAnimals(){
	
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("animalList.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return String.join("\n", lines);
	}// end ReadAnimals
}
