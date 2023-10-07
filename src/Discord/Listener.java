package Discord;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMuteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter
{
    Discord discord;
    //private final String targetUserId = "252075498740514817";
    

    Listener(Discord discord)
    {
        this.discord = discord;
    }

    @Override
    public void onGuildVoiceMute(GuildVoiceMuteEvent event) 
    {
        if (event.getMember() != null && event.getMember().getId().equals(discord.getUserID())) 
        {
            
            if(event.getMember().getVoiceState().isMuted())
            {
                System.out.println("muted");
                discord.onMute();
                

            }
            else
            {
                System.out.println("unmuted");
                discord.onUnMute();
            }

        }
    }
}
