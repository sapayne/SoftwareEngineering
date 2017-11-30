package Database;

import java.util.ArrayList;


public class previousOrders {
	
	    ArrayList<Order> previousOrder = new ArrayList<Order>();
	    
	    public void addOrder(Order order) {
			previousOrder.add(order);
		}
					
		public Order[] getPreviousOrders(int index, int range) {
			Order[] orders = null;
			if(previousOrder.isEmpty()) {
				return orders;
			} 
			//reverses the order at which the previousOrders are added to the orders array, so the last
			//order is the first order in the orders array, same idea as a stack
			if (index + range <= previousOrder.size()){
				orders = new Order[range];
				for(int i = range - 1; i >= 0; i--) {
					orders[i] = previousOrder.get(previousOrder.size() - i - 1);
				}
			} else {
				int remainingOrders = previousOrder.size() - index;
				if(remainingOrders != 0) {
					orders = new Order[remainingOrders];
					for(int i = remainingOrders - 1; i >= 0; i--) {
						orders[i] = previousOrder.get(remainingOrders - i - 1);
					}
				}
			}
			return orders;
		}
}
