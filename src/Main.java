import java.awt.AWTException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) 
    {
       

        //SpotifyController controller = new SpotifyController("http://192.168.188.74/api/custom?name=Spotify");
      
        //controller.register();


        Tray tray = new Tray();

        try 
        {
            tray.loadTray();
        } 
        catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       


    }
}