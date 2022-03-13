import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BackAndBorder {
    void addBackgrouColor(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,1920,1080);
    }

    void setBorders(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0, 0, 10, 1080);
        g.fillRect(0, 0, 1920, 10);
        g.fillRect(1910, 0, 10, 1080);
       
    }
}
