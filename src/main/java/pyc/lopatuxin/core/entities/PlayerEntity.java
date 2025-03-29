package pyc.lopatuxin.core.entities;

import pyc.lopatuxin.core.components.movement.PositionComponent;
import pyc.lopatuxin.core.components.movement.VelocityComponent;
import pyc.lopatuxin.core.ecs.Entity;

public class PlayerEntity extends Entity {

    public PlayerEntity(int startX, int startY) {
        addComponent(new PositionComponent(startX, startY));
        addComponent(new VelocityComponent(0, 0));
    }

    public void setVelocity(int vx, int vy) {
        VelocityComponent velocity = getComponent(VelocityComponent.class);
        if (velocity != null) {
            velocity.setVelocityX(vx);
            velocity.setVelocityY(vy);
        }
    }

    public PositionComponent getPosition() {
        return getComponent(PositionComponent.class);
    }
}
