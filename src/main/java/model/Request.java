package model;

/**
 * Created by http://pojo.sodhanalibrary.com/Convert on 12/15/17.
 */
public class Request
{
    private String altitude;
    
    private String longitude;
    
    private String passes;
    
    private String latitude;
    
    private String datetime;
    
    public String getAltitude ()
    {
        return altitude;
    }
    
    public void setAltitude (String altitude)
    {
        this.altitude = altitude;
    }
    
    public String getLongitude ()
    {
        return longitude;
    }
    
    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }
    
    public String getPasses ()
    {
        return passes;
    }
    
    public void setPasses (String passes)
    {
        this.passes = passes;
    }
    
    public String getLatitude ()
    {
        return latitude;
    }
    
    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }
    
    public String getDatetime ()
    {
        return datetime;
    }
    
    public void setDatetime (String datetime)
    {
        this.datetime = datetime;
    }
    
    @Override
    public String toString()
    {
        return "Request [altitude = "+altitude+", longitude = "+longitude+", passes = "+passes+", latitude = "+latitude+", datetime = "+datetime+"]";
    }
}
