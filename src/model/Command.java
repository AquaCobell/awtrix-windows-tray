package model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Command 
{
   

    @JsonProperty("text")
      @JsonInclude(JsonInclude.Include.NON_NULL)
    String text;

    @JsonProperty("color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String color;

    @JsonProperty("rainbow")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    boolean rainbow;
    
    @JsonProperty("icon")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    int icon;

    public Command()
    {

    }

   
    public Command setColor(String color) {
        this.color = color;
        return this;
    }

    public Command setRainbow(boolean rainbow) {
        this.rainbow = rainbow;
        return this;
    }

    public Command setText(String text) {
        this.text = text;
        return this;
    }

    public Command setIcon(int icon) {
        this.icon = icon;
        return this;
    }


    public String getColor() {
        return color;
    }
    public String getText() {
        return text;
    }
    public boolean getRainbow()
    {
        return rainbow;
    }

    public int getIcon() {
        return icon;
    }


}
