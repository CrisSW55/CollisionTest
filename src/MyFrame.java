import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension monitorSize = toolkit.getScreenSize();
    final int screenWidth = 800;
    final int screenHeight = 600;
    final int centerX = (int)monitorSize.getWidth()/2-(screenWidth/2);
    final int centerY = (int)monitorSize.getHeight()/2-(screenHeight/2);
    KeyHandler kH;
    MyFrame(){
        //Rectangle player = new Rectangle(5,10,20,40);
        setTitle("Collision Test");
        setLocation(centerX,centerY);
        setSize(screenWidth,screenHeight);
        kH = new KeyHandler();
        addKeyListener(kH);
        GamePanel gamePanel = new GamePanel(screenWidth,screenHeight,kH);
        add(gamePanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

