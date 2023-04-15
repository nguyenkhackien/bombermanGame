package uet.oop.bomberman.entities;

import java.util.List;

public class Collision {

    public Collision() {
    }

    public Entity checkCollision(Entity entity, List<Entity> list) {
        // kiểm tra va chạm nổ
        for (Entity e : list) {
            if (e.getX() - 16 <= entity.getX() && e.getX() + 16 >= entity.getX() && e.getY() - 24 <= entity.getY()
                    && e.getY() + 8 >= entity.getY()) {
                return e;
            }
        }
        return null;
    }
    public Entity checkItem(Entity entity, List<Entity> list) {
        // kiểm tra va chạm nổ
        for (Entity e : list) {
            if (e.getX() - 8 <= entity.getX() && e.getX() + 8 >= entity.getX() && e.getY() - 16 <= entity.getY()
                    && e.getY() + 8 >= entity.getY()) {
                return e;
            }
        }
        return null;
    }
}
