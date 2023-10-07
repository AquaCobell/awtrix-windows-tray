package main;
import java.io.IOException;

import Discord.Discord;
import Spotify.SpotifyController;
import model.Config;
import utils.Savecontroller;
import utils.Sender;
import weather.Weather;

public class Controller 
{

     //APPCONTROLLLER
    SpotifyController spotify;
    Weather weather;
    Discord discord;

    //SAFEFILE
    Config conf;
    Savecontroller savecontroller;


    //AWTRIX APPS
    Sender spotifysender;
    Sender discordSender;
    Sender weatherSender;


    //SETTINGS
    String url;
    String token ;
    String UserID;

    //STATUS
    boolean discordapp = false;
    boolean spotifyapp = false;

    

   public Controller()
   {
     savecontroller = new Savecontroller();

     //DUMMY IP
     this.url = "192.168.188.74";

     //DUMMY USERID
     this.UserID= "252075498740514817";
                   
     

     //DUMMY TOKEN 
     this.token = "MTE1ODxODk4HFASTYj4ODENQGJeIAb.JwKL33e4XE1rS5iWxXrHLWKvDSFASTrYXrFSXYASR2odo";

     this.spotifysender = new Sender(this.url, "Spotify");
     this.discordSender = new Sender(this.url, "Discord");
     this.weatherSender = new Sender(this.url, "Wetter"); 

     this.discord = new Discord(discordSender, this.token, this.UserID);
      
        
   }  

   public Controller(String url, String token, String UserID)
   {
        savecontroller = new Savecontroller();
        this.url = url;
        this.token = token;
        this.UserID = UserID;
        this.spotifysender = new Sender(this.url, "Spotify");
        this.discordSender = new Sender(this.url, "Discord");
        this.weatherSender = new Sender(this.url, "Wetter");  

        this.discord = new Discord(discordSender, this.token,this.UserID);
       
   } 

   //Helper Konstruktor
   public void loadSettings()
   {
        try 
        {
            conf = this.savecontroller.loadsettings();
            if(conf!= null)
            {
                this.url = conf.getUrl();
                this.token = conf.getToken();
                this.UserID = conf.getUserID();
               reloadApps();
               System.out.println("Konfiguration geladen");

                
                
            }
            
        } 
        catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
            
        }
     }

     public void reloadApps()
     {
          
          this.spotifysender = new Sender(this.url, "Spotify");
          this.discordSender = new Sender(this.url, "Discord");
          this.weatherSender = new Sender(this.url, "Wetter"); 

          if(discordapp == true)
          {
               disableDiscord();
               discord = new Discord(discordSender, this.token, this.UserID );
               enableDiscord();
          }
          else
          {
               discord = new Discord(discordSender, this.token, this.UserID);
          }
          
     }


     public void safeSettings()
     {
          if(this.conf == null)
          {
               this.conf = new Config(this.url, this.token, this.UserID);
          }
          else
          {
               conf.setToken(this.token);
               conf.setUrl(this.url);
               conf.setUserID(this.UserID);
          }
          savecontroller.safesettings(this.conf);
     }

     public void enableDiscord()
     {
          if(discordapp == false)
          {
               discord.startJDA();
               discordapp = true;
          }
          
     }

     public void disableDiscord()
     {
          if(discordapp == true)
          {
               discord.shutdownJDA();
               discordapp = false;
          }
          
     }

     public boolean getDiscordStatus()
     {
          return this.discordapp;
     }

      public boolean getSpotifyStatus()
     {
          return this.spotifyapp;
     }

    public void setURL(String url) 
    {
          this.url = url;
    }

    public void setToken(String token) 
    {
          this.token = token;
    }

public void setUserID(String userID) 
{
     this.UserID = userID;
}
}
