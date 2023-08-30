import java.io.IOException;

import de.labystudio.spotifyapi.SpotifyAPI;
import de.labystudio.spotifyapi.SpotifyAPIFactory;
import de.labystudio.spotifyapi.SpotifyListener;
import de.labystudio.spotifyapi.model.Track;

public class SpotifyController 
{   


    private SpotifyAPI spotify;
    Httpcontroller httpcontroller;
    Thread t1;
    boolean active;
    Savecontroller save;

    SpotifyController(String url)
    {
        spotify = SpotifyAPIFactory.create();

        
      


        httpcontroller = new Httpcontroller("http://192.168.188.74/api/custom?name=Spotify");
        active = false;
    }

    public void register()
    {
        spotify.registerListener(new SpotifyListener() 
        {
        
            @Override
            public void onConnect() {
                System.out.println("Connected to Spotify!");
            }
            
            @Override
            public void onTrackChanged(Track track) {
                System.out.println("Track changed:" + track);
                try
                {
                    t1.interrupt();
                }
                catch (Exception e)
                {
                    System.out.println("Thread not running");
                }



                try 
                {

                    
                    httpcontroller.sendSong(track.getName(), track.getLength());
                    t1  = new Thread(httpcontroller);
                    t1.start();

                    System.out.println("lenght:" + track.getLength());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                
            }
            
            @Override
            public void onPositionChanged(int position) {
                if (!spotify.hasTrack()) {
                    return;
                }
              

                System.out.println("Position change: " + position);
            }
            
            @Override
            public void onPlayBackChanged(boolean isPlaying) 
            {

                System.out.println(isPlaying ? "Song started playing" : "Song stopped playing");
                if(isPlaying == true)
                {

                }
                else
                {

                }
            }
            
            @Override
            public void onSync() {
                
            }
            
            @Override
            public void onDisconnect(Exception exception) {
                System.out.println("Disconnected: " + exception.getMessage());
                
                spotify.stop();
            }

        });

        spotify.initialize();
        
    }

    public void stop()
    {
        try
        {
            t1.interrupt();
            
        }
        catch(Exception e)
        {
            System.out.println("Fehler: " + e);
        }    
        
        try 
        {
            spotify.stop();
        } 
        catch (Exception e) 
        {
            System.out.println("Fehler: " + e);
        }
    }
   

    public boolean getactive()
    {
        return this.active;
    }
     
    public void setactive(boolean active)
    {
        this.active = active;
    }


}
