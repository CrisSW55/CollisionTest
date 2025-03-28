import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    private final int screenWidth,screenHeight;
    Block player,block;
    KeyHandler kH;
    Timer timer;

    GamePanel(int screenWidth, int screenHeight,KeyHandler kH) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.kH = kH;
        setBackground(Color.BLACK);
        timer = new Timer(50, e -> {
            if(kH.right && !(player.getX()+player.getWidth() == block.getX())
                        && !(player.getY()+ player.getHeight() == block.getY())
            ){
                player.x+= 10;
            }
            else if(kH.left && !( player.getX() == block.getX()+block.getWidth()) ){player.x -= 10;}
            else if(kH.up) {player.y -= 10;}
            else if(kH.down){player.y += 10;}
            repaint();
        });
        timer.start();
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        player = new Block(50,this.screenHeight-100,50,50);
        block = new Block(200,this.screenHeight-100,50,50);
    }

    @Override
    public void update(Graphics g) {
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
