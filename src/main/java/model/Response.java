package model;

/**
 * Created by http://pojo.sodhanalibrary.com/Convert on 12/15/17.
 */
public class Response
{
    private int duration;
    
    private long risetime;
    
    public int getDuration ()
    {
        return duration;
    }
    
    public void setDuration (int duration)
    {
        this.duration = duration;
    }
    
    public long getRisetime ()
    {
        return risetime;
    }
    
    public void setRisetime (long risetime)
    {
        this.risetime = risetime;
    }
    
    @Override
    public String toString()
    {
        return "Response [duration = "+duration+", risetime = "+risetime+"]";
    }
}
