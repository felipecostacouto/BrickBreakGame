import java.awt.Color;
import java.awt.Graphics;


public class Brick {
    static int height,width;
    int x,y;
    int noOfHitsTaken;
    boolean destroyed;
    char colour;
    int health;
    void makeBrick(Graphics g,char a,int x,int y)
    {
            this.x= x;
            this.y= y;
            colour=a;
            if (a=='a')
            {
                g.setColor(Color.BLACK);
                health=3;
            }
            else if (a=='b')
            {
                g.setColor(Color.PINK);
                health=2;
            }
            else 
            {
                g.setColor(Color.LIGHT_GRAY);
                health=1;
            }
            g.fillRect(x,y,70,60);
            g.setColor(Color.BLUE);
            g.drawRect(x,y,70,60);
    }
}
