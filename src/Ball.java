import java.awt.Graphics;
import java.awt.Color;

public class Ball {
    public int ballposX;
    public int ballposY;
    public int ballXdir=-5;
    public int ballYdir=-10;
    
    Ball(int ballposX, int ballposY)
    {
        this.ballposX=ballposX;
        this.ballposY=ballposY;
    }
    
    void makeBall(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(ballposX, ballposY, 40, 40);
    }

    void ballMotion(int ballXdir,int ballYdir)
    {
        ballposX=ballposX+ballXdir;
        ballposY+=ballYdir;
        if (ballposX<0)
        {
            System.out.println("Ball x<0");
            ballXdir=-ballXdir;
        }
        if (ballposY<0)
        {
            System.out.println("Ball y<0,ballYdir="+ballYdir);
            ballYdir=-ballYdir;
            System.out.println("Ball Ydir="+ballYdir);
        }
        if (ballposX>1720)
        {
            ballXdir=-ballXdir;
        }
    }
    int returnX()
    {
        return ballposX;
    }
    int returnY()
    {
        return ballposY;
    }

}
