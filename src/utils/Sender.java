package utils;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Command;


public class Sender 
{

    String appname;
    private URI uri;

    private HttpClient httpClient;
    
    ObjectMapper objectmapper;


    public Sender(String url, String appname)
    {
        this.uri = URI.create("http://"+ url + "/api/custom?name=" + appname);

        this.httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .build();

        this.appname = appname;

        objectmapper = new ObjectMapper();
        objectmapper.setSerializationInclusion(Include.NON_NULL);
    }




    public void sendText(String text)
    {

        String json = "";
        Command cmd = new Command().setText(text);
        try 
        {
            json = objectmapper.writeValueAsString(cmd);
        } 
        catch (JsonProcessingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        request(json);
        System.out.println(json);
        
    }

    public void sendText(String text, int icon)
    {

        String json = "";
        Command cmd = new Command().setText(text);
        try 
        {
            json = objectmapper.writeValueAsString(cmd);
        } 
        catch (JsonProcessingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        request(json);
        System.out.println(json);
        
    }

    public void sendCommand(Command cmd)
    {
        String json = "";
       
        try 
        {
            json = objectmapper.writeValueAsString(cmd);
        } 
        catch (JsonProcessingException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        request(json);
        System.out.println(json);
    }


    
    private void request(String json)
    {
        HttpRequest request = HttpRequest.newBuilder()
        .POST(HttpRequest.BodyPublishers.ofString(json))
            .uri(this.uri)
            
            .header("Content-Type", "application/json")
            .build();

            try 
            {
                var respone = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(respone);
            } 
            catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            catch (InterruptedException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
    }


}
