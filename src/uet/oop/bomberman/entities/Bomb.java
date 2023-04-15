package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Objects;

public class Bomb extends Entity {

    public int time = 180;

    public boolean flameItem = false;

    public Explosion center = new Explosion(1, 1, Sprite.bomb_exploded.getFxImage());
    public Explosion left = new Explosion(1, 1, Sprite.explosion_horizontal.getFxImage());
    public Explosion right = new Explosion(1, 1, Sprite.explosion_horizontal.getFxImage());
    public Explosion top = new Explosion(1, 1, Sprite.explosion_vertical.getFxImage());
    public Explosion down = new Explosion(1, 1, Sprite.explosion_vertical.getFxImage());
    public Explosion top_last = new Explosion(1, 1, Sprite.explosion_vertical.getFxImage());
    public Explosion down_last = new Explosion(1, 1, Sprite.explosion_vertical.getFxImage());
    public Explosion left_last = new Explosion(1, 1, Sprite.explosion_horizontal.getFxImage());
    public Explosion right_last = new Explosion(1, 1, Sprite.explosion_horizontal.getFxImage());

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public void createExplosion(int x, int y) {
        center.setX(x);
        center.setY(y);
        left.setX(x - 32);
        left.setY(y);
        right.setX(x + 32);
        right.setY(y);
        top.setX(x);
        top.setY(y - 32);
        down.setX(x);
        down.setY(y + 32);
        left_last.setX(x - 64);
        left_last.setY(y);
        right_last.setX(x + 64);
        right_last.setY(y);
        top_last.setX(x);
        top_last.setY(y - 64);
        down_last.setX(x);
        down_last.setY(y + 64);

        BombermanGame.getExplosion().add(center);
        if (flameItem) {
            if (BombermanGame.getEntity(left.getX(), left.getY()) instanceof Grass
                    || BombermanGame.getEntity(left.getX(), left.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(left);
                if (BombermanGame.getEntity(left.getX(), left.getY()) instanceof Brick) {
                    ((Brick) Objects
                            .requireNonNull(BombermanGame.getEntity(left.getX(), left.getY()))).destroyed = true;
                }
            }
            if (BombermanGame.getEntity(right.getX(), right.getY()) instanceof Grass
                    || BombermanGame.getEntity(right.getX(), right.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(right);
                if (BombermanGame.getEntity(right.getX(), right.getY()) instanceof Brick) {
                    ((Brick) Objects
                            .requireNonNull(BombermanGame.getEntity(right.getX(), right.getY()))).destroyed = true;
                }
            }
            if (BombermanGame.getEntity(top.getX(), top.getY()) instanceof Grass
                    || BombermanGame.getEntity(top.getX(), top.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(top);
                if (BombermanGame.getEntity(top.getX(), top.getY()) instanceof Brick) {
                    ((Brick) Objects.requireNonNull(BombermanGame.getEntity(top.getX(), top.getY()))).destroyed = true;
                }
            }
            if (BombermanGame.getEntity(down.getX(), down.getY()) instanceof Grass
                    || BombermanGame.getEntity(down.getX(), down.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(down);
                if (BombermanGame.getEntity(down.getX(), down.getY()) instanceof Brick) {
                    ((Brick) Objects
                            .requireNonNull(BombermanGame.getEntity(down.getX(), down.getY()))).destroyed = true;
                }
            }
            if (BombermanGame.getEntity(left_last.getX(), left_last.getY()) instanceof Grass
                    || BombermanGame.getEntity(left_last.getX(), left_last.getY()) instanceof Brick) {
                if (BombermanGame.getEntity(left.getX(), left.getY()) instanceof Grass) {
                    BombermanGame.getExplosion().add(left_last);
                    if (BombermanGame.getEntity(left_last.getX(), left_last.getY()) instanceof Brick) {
                        ((Brick) Objects.requireNonNull(
                                BombermanGame.getEntity(left_last.getX(), left_last.getY()))).destroyed = true;
                    }
                }
            }
            if (BombermanGame.getEntity(right_last.getX(), right_last.getY()) instanceof Grass
                    || BombermanGame.getEntity(right_last.getX(), right_last.getY()) instanceof Brick) {
                if (BombermanGame.getEntity(right.getX(), right.getY()) instanceof Grass) {
                    BombermanGame.getExplosion().add(right_last);
                    if (BombermanGame.getEntity(right_last.getX(), right_last.getY()) instanceof Brick) {
                        ((Brick) Objects.requireNonNull(
                                BombermanGame.getEntity(right_last.getX(), right_last.getY()))).destroyed = true;
                    }
                }
            }
            if (BombermanGame.getEntity(top_last.getX(), top_last.getY()) instanceof Grass
                    || BombermanGame.getEntity(top_last.getX(), top_last.getY()) instanceof Brick) {
                if (BombermanGame.getEntity(top.getX(), top.getY()) instanceof Grass) {
                    BombermanGame.getExplosion().add(top_last);
                    if (BombermanGame.getEntity(top_last.getX(), top_last.getY()) instanceof Brick) {
                        ((Brick) Objects.requireNonNull(
                                BombermanGame.getEntity(top_last.getX(), top_last.getY()))).destroyed = true;
                    }
                }
            }
            if (BombermanGame.getEntity(down_last.getX(), down_last.getY()) instanceof Grass
                    || BombermanGame.getEntity(down_last.getX(), down_last.getY()) instanceof Brick) {
                if (BombermanGame.getEntity(down.getX(), down.getY()) instanceof Grass) {
                    BombermanGame.getExplosion().add(down_last);
                    if (BombermanGame.getEntity(down_last.getX(), down_last.getY()) instanceof Brick) {
                        ((Brick) Objects.requireNonNull(
                                BombermanGame.getEntity(down_last.getX(), down_last.getY()))).destroyed = true;
                    }
                }
            }
        } else {
            if (BombermanGame.getEntity(left.getX(), left.getY()) instanceof Grass
                    || BombermanGame.getEntity(left.getX(), left.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(left);
            }
            if (BombermanGame.getEntity(right.getX(), right.getY()) instanceof Grass
                    || BombermanGame.getEntity(right.getX(), right.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(right);
            }
            if (BombermanGame.getEntity(top.getX(), top.getY()) instanceof Grass
                    || BombermanGame.getEntity(top.getX(), top.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(top);
            }
            if (BombermanGame.getEntity(down.getX(), down.getY()) instanceof Grass
                    || BombermanGame.getEntity(down.getX(), down.getY()) instanceof Brick) {
                BombermanGame.getExplosion().add(down);
            }

            if (BombermanGame.getEntity(left.getX(), left.getY()) instanceof Brick) {
                ((Brick) Objects.requireNonNull(BombermanGame.getEntity(left.getX(), left.getY()))).destroyed = true;
            }
            if (BombermanGame.getEntity(right.getX(), right.getY()) instanceof Brick) {
                ((Brick) Objects.requireNonNull(BombermanGame.getEntity(right.getX(), right.getY()))).destroyed = true;
            }
            if (BombermanGame.getEntity(top.getX(), top.getY()) instanceof Brick) {
                ((Brick) Objects.requireNonNull(BombermanGame.getEntity(top.getX(), top.getY()))).destroyed = true;
            }
            if (BombermanGame.getEntity(down.getX(), down.getY()) instanceof Brick) {
                ((Brick) Objects.requireNonNull(BombermanGame.getEntity(down.getX(), down.getY()))).destroyed = true;
            }
        }
    }

    public void AnimationExplosion() {
        left.setImage1(Sprite.explosion_horizontal.getFxImage());
        left.setImage2(Sprite.explosion_horizontal1.getFxImage());
        left.setImage3(Sprite.explosion_horizontal2.getFxImage());
        right.setImage1(Sprite.explosion_horizontal.getFxImage());
        right.setImage2(Sprite.explosion_horizontal1.getFxImage());
        right.setImage3(Sprite.explosion_horizontal2.getFxImage());
        top.setImage1(Sprite.explosion_vertical.getFxImage());
        top.setImage2(Sprite.explosion_vertical1.getFxImage());
        top.setImage3(Sprite.explosion_vertical2.getFxImage());
        down.setImage1(Sprite.explosion_vertical.getFxImage());
        down.setImage2(Sprite.explosion_vertical1.getFxImage());
        down.setImage3(Sprite.explosion_vertical2.getFxImage());
        center.setImage1(Sprite.bomb_exploded.getFxImage());
        center.setImage2(Sprite.bomb_exploded1.getFxImage());
        center.setImage3(Sprite.bomb_exploded2.getFxImage());
        left_last.setImage1(Sprite.explosion_horizontal.getFxImage());
        left_last.setImage2(Sprite.explosion_horizontal1.getFxImage());
        left_last.setImage3(Sprite.explosion_horizontal2.getFxImage());
        right_last.setImage1(Sprite.explosion_horizontal.getFxImage());
        right_last.setImage2(Sprite.explosion_horizontal1.getFxImage());
        right_last.setImage3(Sprite.explosion_horizontal2.getFxImage());
        top_last.setImage1(Sprite.explosion_vertical.getFxImage());
        top_last.setImage2(Sprite.explosion_vertical1.getFxImage());
        top_last.setImage3(Sprite.explosion_vertical2.getFxImage());
        down_last.setImage1(Sprite.explosion_vertical.getFxImage());
        down_last.setImage2(Sprite.explosion_vertical1.getFxImage());
        down_last.setImage3(Sprite.explosion_vertical2.getFxImage());
    }

    @Override
    public void update() {
        if (time > 0) {
            time--;
        }
        if (time == 0) {
            createExplosion(this.x, this.y);
            AnimationExplosion();
            check = true;
        }
        if (time >= 30 && time <= 70) {
            this.img = Sprite.bomb_1.getFxImage();
        }
        if (time <= 30 && time >= 0) {
            this.img = Sprite.bomb_2.getFxImage();
        }
    }
}
