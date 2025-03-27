import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    private final int screenWidth,screenHeight;
    Block player,block;

    GamePanel(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        setBackground(Color.BLACK);
        Timer timer = new Timer(100, e -> {
            player.x += 5;
            if(player.intersects(block)){System.out.println("Player is colliding!");}
            else{System.out.println("Player is not colliding!");}
            repaint();
        });
        timer.start();
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        player = new Block(50,this.screenHeight-100,50,50);
        block = new Block(200,this.screenHeight-100,50,50);
    }

    @Override
    public void update(Graphics g){
        super.update(g);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillRect((int) player.getX(), (int) player.getY(), (int) player.getWidth(), (int) player.getHeight());
        g2d.setColor(Color.RED);
        g2d.fillRect((int) block.getX(), (int) block.getY(), (int) block.getWidth(), (int) block.getHeight());
    }
}
