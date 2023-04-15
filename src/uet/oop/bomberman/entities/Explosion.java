package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Explosion extends Entity{

    public int time=40;

    public Image image1,image2,image3;


    public Explosion(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public Image getImage3() {
        return image3;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    @Override
    public void update() {
        if (time > 0) {
            time--;
        } else {
            this.check=true;
        }

        if(time <=12 && time >=5){
            this.img=image2;
        }

        if(time <5 && time >=0){
            this.img=image3;
        }
    }
}
