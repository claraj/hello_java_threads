import model.Response;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by clara on 12/15/17.
 */
public class LocationPassTimes {
    
    Location location;
    Response[] passTimes;
    
    LocationPassTimes(Location location, Response[] passTimes) {
        this.location = location;
        this.passTimes = passTimes;
    }
    
    public String toString() {
        
        StringBuilder timesBuilder = new StringBuilder();
        
        for (Response r : passTimes) {
    
            timesBuilder.append('\n');
            
            // Convert timestamps to date. The timestamps are in seconds, Date() expects a
            // timestamp in millisecond so multiply by 1000
            
            Date riseTime = new Date(r.getRisetime() * 1000);
            
            timesBuilder.append("Rise time: ");
            timesBuilder.append(riseTime);
            timesBuilder.append(", ");
            timesBuilder.append("time visible: ");
            timesBuilder.append(r.getDuration());
            timesBuilder.append(" seconds.");
            
        }
        
        String times = timesBuilder.toString();
        
        return "Location: " + location.name + times;
        
    }
    
}
