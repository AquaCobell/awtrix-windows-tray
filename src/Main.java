import java.awt.AWTException;


public class Main {
    public static void main(String[] args) 
    {
       

        //SpotifyController controller = new SpotifyController("http://192.168.188.74/api/custom?name=Spotify");
      
        //controller.register();


        

        Savecontroller save = new Savecontroller();
        //Config conf = new Config("http://192.168.188.74/api/custom?name=Spotify");
        //save.safesettings(conf);
 
        Config config = null;
        try 
        {
            config = save.loadsettings();
        }
        catch(Exception e)
        {
            System.out.println("No config found");
        }
        //Config config  = new Config("test");
        
        


        Tray tray = new Tray(save, config);
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