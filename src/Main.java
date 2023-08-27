import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SpotifyController controller = new SpotifyController("http://192.168.188.74/api/custom?name=Spotify");
      
        controller.register();

       


    }
}