import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.IOException;

public class Level extends JPanel {
    Slider s;
    Ball ball;
    int levelNo;
    Level(Graphics g,int k,int ballposX,int ballposY,int levelNo) throws IOException{
        
        this.levelNo = levelNo;
        addSlider(g,k);
        addBall(g,ballposX,ballposY);
        Map m = new Map();
        if (levelNo ==1){
            m.makeMap1(g);
        }
        else if(levelNo ==2){
            m.makeMap2(g);
        }
        else{
            m.makeMap3(g);
        }
    }
    void addSlider(Graphics g,int k){
        s=new Slider();
        s.createSlider(g,k);
    }
    void addBall(Graphics g,int ballposX, int ballposY){
        ball = new Ball(ballposX,ballposY);
        ball.makeBall(g);
    }
}
