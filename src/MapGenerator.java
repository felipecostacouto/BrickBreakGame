import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
//https://coderspacket.com/brick-breaker-game-using-java
//https://github.com/awaismirza/Java-Game-Brick-Breaker/blob/master/src/Gameplay.java
//https://github.com/purvag15/BrickBreaker/blob/master/src/game/Final.java

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col){
        map = new int[row][col];
        for(int i = 0; i <map.length;i++){
            for(int j = 0; j<map[0].length; j++){
                map[i][j] = 1; //the logic behind adding 1 inside each element of the 2D array is that it will notify us when the ball has not intersected with brick and it will show up in the panel. 
            }
        }

        brickWidth = 540/col;
        brickHeight = 150/row; //and now, we have set the width and height of the bricks that will appear on the screen with respect to the array elements.
    }

    public void draw(Graphics2D g){
        for(int i= 0;i < map.length; i++){ //Within the for loop, we will need to check if the particular value is greater than not. if it is greater than zero, it creates the bricks. 
            for(int j= 0; j< map[0].length; j++){
                if(map[i][j] > 0){
                    g.setColor(Color.red);
                    g.fillRect(j*brickHeight + 80, i*brickHeight + 50, brickWidth, brickHeight); //fillRect method to fill the rectangle at the particular positions.

                    //map border of bricks
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth +80, i*brickHeight +50, brickWidth,brickHeight);
                }
            }
        }

    }

    public void setBrickval(int val, int row, int col){ //we need to create a function that will give us a value when the ball intersects the brick. We know that the total number of bricks is 21. When the function value attains zero, the game will terminate
        map[row][col] = val;
    }


}
