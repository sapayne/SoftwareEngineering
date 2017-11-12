package Database;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Time {
	//	converts the epoch time recorded at the time the item is bought and returns the time into human readable 
	//	time
	public String epochToHuman(long seconds){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return sdf.format(new Date(seconds*1000));
	}
	
	//	used when an item is bought to give the exact time at which the item was bought, then registered in the 
	// 	previousOrders database
	public long currentEpoch() {
		return Instant.now().getEpochSecond();
	}
}
