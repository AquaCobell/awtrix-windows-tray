package weather;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Weather 
{
    URI uri;
    private HttpClient httpClient; //,\"progress\":30 


        public Weather(String url) 
        {
            this.uri = URI.create(url);
            this.httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
        }

    


        public void updateWeather(String Wetter, int Grad) throws IOException, InterruptedException
        {
           
            HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(""))
            .uri(this.uri)
            
            .header("Content-Type", "application/json")
            .build();

            var respone = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(respone);
        }


}
