package model;
import java.io.Serializable;

public class Config implements Serializable 
{

    String url;
    String token;
    String UserID;
    public Config(String url, String token, String UserID)
    {
        this.url = url;
        this.token = token;
        this.UserID = UserID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID2) 
    {
        this.UserID = userID2;
    }




}
