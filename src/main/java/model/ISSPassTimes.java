package model;

/** Created by http://pojo.sodhanalibrary.com/Convert*/
public class ISSPassTimes
{
    private Response[] response;
    
    private String message;
    
    private Request request;
    
    public Response[] getResponse ()
    {
        return response;
    }
    
    public void setResponse (Response[] response)
    {
        this.response = response;
    }
    
    public String getMessage ()
    {
        return message;
    }
    
    public void setMessage (String message)
    {
        this.message = message;
    }
    
    public Request getRequest ()
    {
        return request;
    }
    
    public void setRequest (Request request)
    {
        this.request = request;
    }
    
    @Override
    public String toString()
    {
        return "ISSPassTimes [response = "+response+", message = "+message+", request = "+request+"]";
    }
}