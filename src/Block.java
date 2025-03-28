import java.awt.*;

public class Block extends Rectangle {
    String direction = "right";
    boolean leftCollision = false;
    boolean rightCollision = false;
    boolean upCollision = false;
    boolean downCollision = false;
    Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean intersects(Rectangle block) {
        int playerWidth = this.width;
        int playerHeight = this.height;
        int blockWidth = block.width;
        int blockHeight = block.height;
        if (blockWidth <= 0 || blockHeight <= 0 || playerWidth <= 0 || playerHeight <= 0) {
            return false;
        }
        int playerX = this.x;
        int playerY = this.y;
        int blockX = block.x;
        int blockY = block.y;
        blockWidth += blockX;
        blockHeight += blockY;
        playerWidth += playerX;
        playerHeight += playerY;
        //      overflow || intersect
        return ((blockWidth < blockX || blockWidth > playerX) &&
                (blockHeight < blockY || blockHeight > playerY) &&
                (playerWidth < playerX || playerWidth > blockX) &&
                (playerHeight < playerY || playerHeight > blockY));
    }
}
