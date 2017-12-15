import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Callable;

import model.*;

/**
 * Created by clara on 12/15/17.
 */
public class ISSTask implements Callable<LocationPassTimes> {
    
    private Location location;
    
    private static final String URL_TEMPLATE = "http://api.open-notify.org/iss-pass.json?lat=%f&lon=%f";
    
    
    ISSTask(Location l) {
        this.location = l;
    }
    
    
    public LocationPassTimes call() throws Exception {
        
        // The API URL to request
        String urlString = String.format(URL_TEMPLATE, location.lat, location.lon);
        
        // Create an URL object from the URL string
        URL url = new URL(urlString);
        
        // Make a web request. Response is returned as a stream of bytes
        InputStream stream = url.openStream();
        
        // Need something to read that stream
        InputStreamReader streamReader = new InputStreamReader(stream);
        
        //Now GSON gets involved. Can wrap the InputStreamReader in GSON's JsonReader
        JsonReader jsonReader = new JsonReader(streamReader);
        
        //Create a new GSON object... which can turn objects to JSON and JSON to objects
        Gson gson = new Gson();
        
        //... and give it the jsonReader (the JSON response from the server)
        // and the class it will use to make objects
        // If the structure of the ISSNow class matches the JSON response from the server,
        // GSON will be able to turn the response into ISSNow objects, containing the data
        
        ISSPassTimes passTimes = gson.fromJson(jsonReader, ISSPassTimes.class);
        
        // Reformat into a LocationPassTimes object
        
        return new LocationPassTimes(location, passTimes.getResponse());
    }
}
