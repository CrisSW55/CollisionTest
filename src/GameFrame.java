import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension monitorSize = toolkit.getScreenSize();
    final int screenWidth = 800;
    final int screenHeight = 600;
    final int centerX = (int)monitorSize.getWidth()/2-(screenWidth/2);
    final int centerY = (int)monitorSize.getHeight()/2-(screenHeight/2);

    GameFrame(){
        //Rectangle player = new Rectangle(5,10,20,40);
        setTitle("Collision Test");
        setLocation(centerX,centerY);
        setSize(screenWidth,screenHeight);
        GamePanel gamePanel = new GamePanel(screenWidth,screenHeight);
        add(gamePanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

