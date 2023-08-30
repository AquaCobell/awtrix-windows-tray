import java.io.Serializable;

public class Config implements Serializable 
{

    String url;
    Config(String url)
    {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }




}
