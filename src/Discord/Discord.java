package Discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import utils.Sender;
import model.Command;

public class Discord 
{
    JDABuilder builder;
    JDA main;
    Sender sender;
    int icon;
    String token;
    String UserID;
   

    public Discord(Sender sender, String token, String userid)
    {
        this.token = token;
        builder = JDABuilder.createDefault(this.token);
        this.UserID = userid;
       
        this.sender = sender; 
    }


    public void shutdownJDA()
    {
        main.shutdownNow();
    }

    public void startJDA()
    {
        this.main = builder.build();
        main.addEventListener(new Listener(this));
    }
    

    public void onMute()
    {
        sender.sendCommand(new Command().setText("muted").setColor("#ff0004").setIcon(31722));
    }

    public void onUnMute()
    {   
        sender.sendCommand(new Command().setText("unmuted").setColor("#00ff00"));
    }

    public String getUserID() {
        return UserID;
    }
    

}



