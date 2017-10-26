package softwareEngineering;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class item {
  
	public static void main (String [] args) {
		List<itemInformation> items = readItemsFromCSV("itemDatabase.csv");
		for (itemInformation item: items) {
			System.out.println(item);
		}
	}
	
	private static List<itemInformation> readItemsFromCSV(String fileName) {
		System.out.println(fileName);
		List<itemInformation> items = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();

			while (line != null) {
				
				String [] information = line.split(",");
				
				itemInformation item = createItem(information);
				
				items.add(item);
				
				line = br.readLine();
			}
			
		}   catch (IOException ioe) {
			    ioe.printStackTrace();
		}
		
		return items;
	}
	
	private static itemInformation createItem(String[] metadata) {
		String name = metadata[0];
		String brand = metadata[1];
		double price = Double.parseDouble(metadata[2]);
		int stock = Integer.parseInt(metadata[3]);
		String category = metadata[4];
		int weight = Integer.parseInt(metadata[5]);
		int popularity = Integer.parseInt(metadata[6]);
		String image = metadata[7];
		int numberSold = Integer.parseInt(metadata[8]);
		String description = metadata[9];
		
	    return new itemInformation(name, brand, price, 
				stock, category, weight, popularity, image, 
				numberSold, description);
	}
}
