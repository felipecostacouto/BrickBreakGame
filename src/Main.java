import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame obj=new JFrame();
		Gameplay gamePlay = new Gameplay(3);

        obj.setBounds(0, 0, 1920, 1080);
		obj.setTitle("Brick Breaker");		
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
        obj.setVisible(true);
    }
}
