package Database;

import java.util.ArrayList;
import java.util.List;

public class previousOrders {
	
	    ArrayList<itemInformation> previousOrder = new ArrayList<itemInformation>();

	    public void addOrder(itemInformation item) {
			previousOrder.add(item);
			// override the quality, price, and time that the item was bought when adding the order to the previous
			// orders arraylist
		}
		
	    // make it so the customer can see the last ten or see the previous orders by year, will require the time 
	    // class to decode the epoch time that is stored in the database
		public Object getLastItem() {
			return previousOrder.get(previousOrder.size() - 1);		
		}
	
	
	

}
