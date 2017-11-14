package Database;

import java.util.ArrayList;

public class database {	
	private itemInformation item;
	ArrayList<itemInformation> itemDatabase = new ArrayList<itemInformation>();
	
	protected int add(itemInformation item) {
		/* the size is retrieved before the add function, because the add function also increases the size, 
		 * so instead of subtracting 1 from the size to get the correct index, we can save on one operation 
		 * by just assigning the value. 
		 */
		int size = itemDatabase.size();
		itemDatabase.add(item);
		return size;
	}
	
	protected void subtract(String index, int amountToSubtract) {
		if(index.substring(0, 3).equals("itm")) {
			int itemIndex = Integer.parseInt(index.substring(3, index.length()));
			item = itemDatabase.get(itemIndex);
			if(amountToSubtract < item.getStock()) {
				item.setStock(item.getStock() - amountToSubtract);
				item.setNumberSold(item.getNumberSold() + amountToSubtract);
			} else {
				
			}
		} else {
			
		}
	}
	
	protected void delete(int index) {
		itemDatabase.remove(index);
	}

	protected itemInformation getInfo(int index) {
		return itemDatabase.get(index);
	}
	
	protected double getPrice(int index) {
		return itemDatabase.get(index).getPrice();
	}
	
	protected double getPopularity(int index) {
		return itemDatabase.get(index).getPopularity();
	}
	
	protected int getStock(int index) {
		return itemDatabase.get(index).getStock();
	}
}
