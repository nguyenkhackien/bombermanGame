package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {

    public int time = 20;
    public boolean hasItem = false;

    public Brick(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        this.score = 5;
    }

    @Override
    public void update() {
        if (destroyed) {
            if (time > 0) {
                time--;
            } else {
                check = true;
            }
            if (time <= 20 && time > 12) {
                this.img = Sprite.brick_exploded.getFxImage();
            }
            if (time <= 12 && time >= 5) {
                this.img = Sprite.brick_exploded1.getFxImage();
            }
            if (time < 5 && time >= 0) {
                this.img = Sprite.brick_exploded2.getFxImage();
            }
        }
    }
}
