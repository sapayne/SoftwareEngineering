package Database;

import java.util.ArrayList;

public class database {	

	ArrayList<itemInformation> itemDatabase = new ArrayList<itemInformation>();
	
	protected void add(itemInformation item) {
		itemDatabase.add(item);
	}
	
	protected void subtract(itemInformation item, int amountToSubtract) {
		if(amountToSubtract < item.getStock()) {
			item.setStock(item.getStock() - amountToSubtract);
			item.setNumberSold(item.getNumberSold() + amountToSubtract);
		}
	}
	
	protected void delete(int index) {
		itemDatabase.remove(index);
	}

	protected itemInformation getInfo(int index) {
		return itemDatabase.get(index);
	}
	
	protected int size() {
		return itemDatabase.size();
	}
}
