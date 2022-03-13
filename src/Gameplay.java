import java.io.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


//https://www.javacodex.com/Java-IO/AudioInputStream

public class Gameplay extends JPanel implements KeyListener, ActionListener, MouseListener,MouseMotionListener
{ 

    public static boolean play=false;
    public static  int score = 0;

    private int totalBricks = 21;
	private boolean loaded;
    private Timer timer;
    private int delay = 4;
	private Image bg;
    static int sliderX=860;
    private int player1= 310;
    static  int ballposX = 940;
    static  int ballposY = 880;
    static  int ballXdir = -2;
    static  int ballYdir = -5;
	int levelNo;
	Level l;

    private MapGenerator map;

    public Gameplay(int levelNo)
	{	
		this.levelNo=levelNo;	
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addMouseListener(this);
        addMouseMotionListener(this);
        timer=new Timer(delay,this);
		timer.start();
	}

    public void paint(Graphics g)
	{    		
		if (g instanceof Graphics2D)
        {
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        super.paint(g);
        if (loaded)
        {
            g.drawImage(bg,0,0,null);
        }
        try 
        {
            //setBackground(g);
           l=new Level(g,sliderX,ballposX,ballposY,levelNo);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        loadpics();
        System.out.println("Final Score="+score);
        //playMusic("E:\\BrickBreaker\\src\\game\\end.wav");
        g.dispose();
	}
	
	
    private void loadpics() 
    {
        bg=new ImageIcon("~/Documents/Java-Projects/BrickBreakGame/src/bg1.jpg").getImage();
        loaded=true;
        repaint();
    }

	public static void playMusic(String filepath) {
        InputStream music;
        try
        {
            music=new FileInputStream(new File(filepath));
            AudioInputStream sound = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();


             // sleep to allow enough time for the clip to play
             Thread.sleep(500);
 
             sound.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) 
        {
            if (new Rectangle(ballposX,ballposY,40,40).intersects(new Rectangle(player1, 920,200,8)))//When the slider rectangle had a height of 8 when the ball was falling down and it touched the bottom part of the slider it used to slide and again reflect
            {
                playMusic("~/Documents/Java-Projects/BrickBreakGame/src");
                ballYdir=-ballYdir;
                
                ballXdir=ballXdir+((ballposX-player1-50)/10);
                if(ballXdir>7) ballXdir=7;
            }
            A:for (int i=0;i<map.map.length;i++)//first map is object of MapGenerator class and second map is instance member matrix map
            {
                for (int j=0;j<map.map[0].length;j++)
                {
                    if (map.map[i][j]>0) 
                    {
                        
                        int brickX=j*map.brickWidth+80;
                        int brickY=i*map.brickHeight+50;
                        int brickWidth=map.brickWidth;
                        int brickHeight=map.brickHeight;
                        Rectangle brickrect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballrect=new Rectangle(ballposX,ballposY,20,20);
                        if (ballrect.intersects(brickrect))
                        {
                            totalBricks--;
                            score+=5;
                                //Next if code is for the reflection of ball from the bricks
                                if ((ballposX+19<=brickrect.x) || ballposX +1>=brickrect.x+brickrect.width)
                            {
                                ballXdir=-ballXdir;
                                }
                            else
                            {
                                ballYdir=-ballYdir;
                            }
                            break A;
                            }
                        }
                    }
                }
            if (ballposX<0)
            {
                ballXdir=-ballXdir;
            }
            if (ballposY<0)
            {
                ballYdir=-ballYdir;
            }
            if (ballposX>1880)
            {
                ballXdir=-ballXdir;
            }
            l.ball.ballMotion(ballXdir,ballYdir);
            ballposX=l.ball.returnX();
            ballposY=l.ball.returnY();
        }
        if (ballposY>930)
        {
            System.exit(1);
        }
        
        repaint();
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
            System.out.println("Key was pressed");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                if (l.s.sliderX>=1690)
                {
                    l.s.sliderX=1720;
                }
                else
                {
                    sliderX=l.s.moveRight();
                    play=true;
                }
            }
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{          
			if(l.s.sliderX < 10)
			{
				l.s.sliderX = 10;
			}
			else
			{
                sliderX=l.s.moveLeft();
                play=true;
			}
        }		
	}
	
	public void moveRight()
	{
		play = true;
		player1+=20;	
	}
	
	public void moveLeft()
	{
		play = true;
		player1-=20;	 	
	}
	

    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
