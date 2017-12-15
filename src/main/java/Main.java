import javafx.concurrent.Task;
import model.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by clara on 12/4/17.
 *
 * Where is the International Space Station right now?
 * In space, obviously, but above what part of the world?
 * Open Notify provides an API to return the current location of the ISS.
 *
 * Uses GSON to deserialize the response from
 * http://open-notify.org/Open-Notify-API/ISS-Pass-Times/
 * into a Java object.
 *
 * Uses threading to fetch locations for 4 locations at once:
 * Minneapolis, [ 44.54 lat, -93.16 lon ]
 * Nairobi,  [ -1.28 lat , 36.81 lon ]
 * Tokyo,    [ 35.41 lat, 139.41 lon ]
 * Rio de Janeiro [ -22.45 lat, -43.11 lon ]
 *
 * This is an open API, no key or auth needed.
 *
 * Exception handling is omitted for clarity BUT it should absolutely be added
 * in a real application. Many things that can go wrong, for example
 * URL not valid format, no internet connection, not authorized to access the API server,
 * API server down, response is not in the format expected....
 *
 */
public class Main {
    
    public static void main(String[] args) throws Exception  {
        
        Location[] locations = {
                new Location("Minneapolis", 44.45, -93.16),
                new Location("Nairobi", -1.28, 36.81),
                new Location("Tokyo", 35.41, 139.41),
                new Location("Rio de Janeiro", -22.45, -43.11)
        };
    
        
        ExecutorService executorService = Executors.newCachedThreadPool();
    
        List<ISSTask> tasks = new ArrayList<ISSTask>();
        
        for (Location l : locations) {
            ISSTask t = new ISSTask(l);
            tasks.add(t);
        }
    
        System.out.println("Sending Requests.");
    
        // Start all tasks, wait for all to complete before proceeding.
        List<Future<LocationPassTimes>> passTimesFutures = executorService.invokeAll(tasks);
        
        // The requests have all completed. Print results.
        for (Future<LocationPassTimes> res : passTimesFutures) {
            
            LocationPassTimes locationPassTimes = res.get();
            System.out.println(locationPassTimes);
        }
        
        // Close the executor service, or it will hang around and the program won't close.
        executorService.shutdown();
        
    }
    
}