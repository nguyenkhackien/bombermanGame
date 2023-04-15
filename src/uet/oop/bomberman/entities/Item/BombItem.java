package uet.oop.bomberman.entities.Item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class BombItem extends Entity {

    public boolean appear = false;

    public BombItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        this.score = 15;
    }

    @Override
    public void update() {

    }
}
