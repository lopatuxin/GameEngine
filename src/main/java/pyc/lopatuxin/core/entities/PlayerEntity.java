package pyc.lopatuxin.core.entities;

import pyc.lopatuxin.core.components.movement.PlayerControlComponent;
import pyc.lopatuxin.core.components.movement.PositionComponent;
import pyc.lopatuxin.core.components.movement.VelocityComponent;
import pyc.lopatuxin.core.ecs.Entity;

public class PlayerEntity extends Entity {

    public PlayerEntity(float startX, float startY) {
        addComponent(new PositionComponent(startX, startY));
        addComponent(new VelocityComponent(0, 0));
        addComponent(new PlayerControlComponent());
    }

    public void setVelocity(float vx, float vy) {
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
