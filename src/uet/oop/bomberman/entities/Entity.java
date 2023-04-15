package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    // Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;
    public boolean destroyed = false;

    public boolean UP = false, DOWN = false, LEFT = false, RIGHT = false;
    public int speed = 8;
    public int count = 0;
    public int score = 0;
    public Collision collision;
    // Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    protected Image img;

    public boolean check = false;

    // Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return this.img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
