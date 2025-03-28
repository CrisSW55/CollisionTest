import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean escape = false;

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_W:
                System.out.println("Moving Up!");
                up = true;
                break;
            case KeyEvent.VK_S:
                System.out.println("Moving Down!");
                down = true;
                break;
            case KeyEvent.VK_A:
                System.out.println("Moving Left!");
                left = true;
                break;
            case KeyEvent.VK_D:
                System.out.println("Moving Right!");
                right = true;
                break;
            case KeyEvent.VK_ESCAPE:
                System.out.println("Pause game!");
                escape = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;

        }
    }
}
