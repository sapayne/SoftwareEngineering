package softwareEngineering;

import java.util.*;


public class previousOrders {
	
	    ArrayList<Object> previousOrder = new ArrayList<Object>();
	    Order order = new Order();
	    
	    public void addOrder(Order order) {
			previousOrder.add(order);
		}
					
		public Object getLastItem() {
			for(int i = 10; i <= 10; i++) {
				if(previousOrder.isEmpty()){
					System.out.println("No previous orders");
				}
				else {
					return previousOrder.get(previousOrder.size() - 1);		
				}
			}
			return null;
		}
}
