package Spotify;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import utils.Timer;


public class Httpcontroller implements Runnable
{
    URI uri;
    private HttpClient httpClient; //,\"progress\":30 
    String json1 = "{\"icon\":\"18207\",\"text\":\"";
    String json2 = "\",\"rainbow\":true,\"duration\":15,\"scrollspeed\":20,\"progress\":0}";


    String json3="{\"icon\":\"18207\",\"text\":\"";
    String json4 ="\",\"rainbow\":true,\"progress\":";

    String json5 = ",\"scrollspeed\":20}";


    String currentSong;
    int duration;
    long time;
    Timer t1;
   
   
        Httpcontroller(String url) 
        {
            this.uri = URI.create(url);
            this.httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
        }



        //.setHeader("User-Agent", "Java 11 HttpClient Bot") 

        public void sendSong(String songname, int duration) throws IOException, InterruptedException
        {
            if(currentSong !=songname)
            {
                //time = System.currentTimeMillis();
                //this.duration = duration;
                currentSong = songname;
                t1 = new Timer();
                t1.start(duration);
            }

            System.out.println(this.json1 + songname + json2);
            HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(this.json1 + songname + json2))
            .uri(this.uri)
            
            .header("Content-Type", "application/json")
            .build();

            var respone = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(respone);
        }

        public void updateDuration(int duration) throws IOException, InterruptedException
        {
            


            HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(this.json3 + currentSong + json4 + duration + json5))
            .uri(this.uri)
            .header("Content-Type", "application/json")
            .build();
            System.out.println(this.json3 + currentSong + json4 + duration + json5);

            var respone = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
          

            
        }



        @Override
        public void run() 
        {
            while(t1.getProgress() != 100 && !Thread.interrupted() ) 
            try 
            {
                updateDuration((int) t1.getProgress());
                TimeUnit.SECONDS.sleep(1);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            } 
            catch (InterruptedException e) {
               
                e.printStackTrace();
                return;
            }
            
         
        }

        /*public void sendStatus(boolean isplaying)
        {
            
            HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(""))
            .uri(this.uri)
            
            .header("Content-Type", "application/json")
            .build();

            var respone = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(respone);

        }*/

        public Timer getT1() {
            return t1;
        }

}
