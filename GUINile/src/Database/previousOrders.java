package softwareEngineering;

import java.util.ArrayList;
import java.util.List;

public class previousOrders {
	
	    ArrayList<Object> previousOrder = new ArrayList<Object>();

	    public void addOrder(itemInformation item) {
			previousOrder.add(item);
			
		}
					
		public Object getLastItem() {
			return previousOrder.get(previousOrder.size() - 1);		
		}
	
	
	

}
