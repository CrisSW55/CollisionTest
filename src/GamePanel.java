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
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        player = new Block(50,this.screenHeight-100,50,50);
        block = new Block(200,this.screenHeight-100,50,50);
        timer = new Timer(50, e -> {
            if(kH.left || kH.right || kH.up || kH.down){
                if(kH.left){player.direction = "left";}
                if(kH.right){player.direction = "right";}
                if(kH.up){player.direction = "up";}
                if(kH.down){player.direction = "down";}

                //System.out.println("rightCollision? " + player.rightCollision);
                if((!player.leftCollision) && player.direction.equals("left")){player.x -= 10;}
                if((!player.rightCollision) && player.direction.equals("right")){player.x += 10;}
                if((!player.upCollision) && player.direction.equals("up")){player.y -= 10;}
                if((!player.downCollision) && player.direction.equals("down")){player.y += 10;}
            }
            player.leftCollision = false;
            player.rightCollision = false;
            player.upCollision = false;
            player.downCollision = false;

            if(player.intersects(block)){
                switch(player.direction){
                    case"left" : player.leftCollision = true;player.x += 10;break;
                    case"right" : player.rightCollision = true;player.x -= 10;break;
                    case"up" : player.upCollision = true;player.y += 10;break;
                    case"down" : player.downCollision = true;player.y -= 10;break;
                }
            }





            repaint();
        });
        timer.start();

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
