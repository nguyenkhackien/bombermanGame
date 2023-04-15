package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Enemy.Balloom;
import uet.oop.bomberman.entities.Enemy.Oneal;
import uet.oop.bomberman.entities.Item.FlameItem;
import uet.oop.bomberman.entities.Item.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends Entity {

    public List<Entity> map = new ArrayList<>();

    public List<Image> left = new ArrayList<>();

    public List<Image> right = new ArrayList<>();

    public List<Image> down = new ArrayList<>();

    public List<Image> up = new ArrayList<>();
    public List<Image> dead = new ArrayList<>();
    public ArrayList<String> bomberMove = new ArrayList<>();

    public void setMap(List<Entity> map) {
        this.map = map;
    }

    // thoi gian hieu luc tang toc
    public int speedUp = 0;

    // thoi gian hieu luc cua flame item
    public int flameItem = 0;
    // kiem tra xem co flame item k
    public static boolean isflame = false;
    public boolean checkdead = false;
    public int timedead = 100;

    // kiem tra co bomb item k
    public boolean BombItem = false;
    // thoi gian hieu luc bombitem
    public int timeBombItem = 0;

    public void setLEFT() {
        left.add(Sprite.player_left.getFxImage());
        left.add(Sprite.player_left_1.getFxImage());
        left.add(Sprite.player_left_2.getFxImage());
    }

    public void setRIGHT() {
        right.add(Sprite.player_right.getFxImage());
        right.add(Sprite.player_right_1.getFxImage());
        right.add(Sprite.player_right_2.getFxImage());
    }

    public void setDOWN() {
        down.add(Sprite.player_down.getFxImage());
        down.add(Sprite.player_down_1.getFxImage());
        down.add(Sprite.player_down_2.getFxImage());
    }

    public void setUP() {
        up.add(Sprite.player_up.getFxImage());
        up.add(Sprite.player_up_1.getFxImage());
        up.add(Sprite.player_up_2.getFxImage());
    }

    public void setDEAD() {
        dead.add(Sprite.player_dead1.getFxImage());
        dead.add(Sprite.player_dead2.getFxImage());
        dead.add(Sprite.player_dead3.getFxImage());
    }

    public List<Entity> getMap() {
        return this.map;
    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
        this.setUP();
        this.setDOWN();
        this.setLEFT();
        this.setRIGHT();
        speed = 1;
    }

    @Override
    public void update() {
        collision = new Collision();
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 0) {
                spriteNum = 1;
            } else if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
        if (bomberMove.contains("DOWN")
                && !(BombermanGame.getEntity(this.getX(), this.getY() + this.speed) instanceof Wall)
                && !(BombermanGame.getEntity(this.getX(), this.getY() + this.speed) instanceof Brick)) {
            DOWN = true;
        } else {
            DOWN = false;
        }
        if (bomberMove.contains("UP")
                && !(BombermanGame.getEntity(this.getX(), this.getY() - this.speed) instanceof Wall)
                && !(BombermanGame.getEntity(this.getX(), this.getY() - this.speed) instanceof Brick)) {
            UP = true;
        } else {
            UP = false;
        }
        if (bomberMove.contains("RIGHT")
                && !(BombermanGame.getEntity(this.getX() + this.speed, this.getY()) instanceof Wall)
                && !(BombermanGame.getEntity(this.getX() + this.speed, this.getY()) instanceof Brick)) {
            RIGHT = true;
        } else {
            RIGHT = false;
        }
        if (bomberMove.contains("LEFT")
                && !(BombermanGame.getEntity(this.getX() - this.speed, this.getY()) instanceof Wall)
                && !(BombermanGame.getEntity(this.getX() - this.speed, this.getY()) instanceof Brick)) {
            LEFT = true;
        } else {
            LEFT = false;
        }
        if (DOWN) {
            this.y += speed;
            this.img = down.get(spriteNum);
        }
        if (UP) {
            this.y -= speed;
            this.img = up.get(spriteNum);
        }
        if (RIGHT) {
            this.x += speed;
            this.img = right.get(spriteNum);
        }
        if (LEFT) {
            this.x -= speed;
            this.img = left.get(spriteNum);
        }
        if (collision.checkCollision(this, BombermanGame.getStillObjects()) instanceof Portal) {
            Portal temp = (Portal) collision.checkCollision(this, BombermanGame.getStillObjects());
            temp.check = true;
        }

        if (collision.checkItem(this, BombermanGame.getItemList()) instanceof SpeedItem) {
            speed += 1;
            speedUp = 1000;
            collision.checkItem(this, BombermanGame.getItemList()).check = true;
        }
        if (speedUp >= 0) {
            speedUp--;
        } else {
            speed = 1;
        }

        if (collision.checkItem(this, BombermanGame.getItemList()) instanceof FlameItem) {
            flameItem = 1000;
            isflame = true;
            collision.checkItem(this, BombermanGame.getItemList()).check = true;
        }
        if (flameItem >= 0) {
            flameItem--;
        } else {
            isflame = false;
        }

        if (collision.checkCollision(this, BombermanGame.getExplosion()) instanceof Explosion) {
            checkdead = true;
        }
        if (collision.checkCollision(this, BombermanGame.getEntities()) instanceof Balloom) {
            checkdead = true;
        }
        if (collision.checkCollision(this, BombermanGame.getEntities()) instanceof Oneal) {
            checkdead = true;
        }
        if (checkdead) {
            if (timedead > 0) {
                timedead--;
            } else {
                check = true;
            }

            if (timedead >= 60 && timedead <= 100) {
                this.img = Sprite.player_dead1.getFxImage();
            }

            if (timedead < 60 && timedead >= 20) {
                this.img = Sprite.player_dead2.getFxImage();
            }

            if (timedead >= 0 && timedead < 20) {
                this.img = Sprite.player_dead3.getFxImage();
            }
        }

        if (collision.checkItem(this,
                BombermanGame.getItemList()) instanceof uet.oop.bomberman.entities.Item.BombItem) {
            timeBombItem = 1000;
            BombItem = true;
            collision.checkItem(this, BombermanGame.getItemList()).check = true;
        }
        if (timeBombItem >= 0) {
            timeBombItem--;
        } else {
            BombItem = false;
        }
    }

}
