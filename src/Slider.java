
import java.awt.Color;
import java.awt.Graphics;


public class Slider {

    final int sliderY=920;
    public int sliderX;
    void createSlider(Graphics g,int sliderX)
    {
        this.sliderX=sliderX;
        g.setColor(Color.BLACK);
        g.fillRect(sliderX, sliderY, 200, 16);
    }

    public int moveRight()
    {
        Gameplay.play=true;
        sliderX+=50;
        return sliderX;
    }
     public int moveLeft()
    {
        Gameplay.play=true;
        sliderX-=50;
        return sliderX;
    }
}
