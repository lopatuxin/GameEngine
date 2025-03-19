package pyc.lopatuxin.core.system;

import pyc.lopatuxin.core.Entity;
import pyc.lopatuxin.core.components.movement.PositionComponent;
import pyc.lopatuxin.core.components.movement.VelocityComponent;

import java.util.List;

/**
 * Система движения, обновляющая координаты объектов на основе их скорости.
 * <p>
 * Эта система проходит по всем сущностям, у которых есть компоненты
 * {@link PositionComponent} и {@link VelocityComponent}, и обновляет их положение.
 * </p>
 */
public class MovementSystem implements System {

    @Override
    public void update(List<Entity> entities) {
        entities.forEach(entity -> {
            if (entity.hasComponent(PositionComponent.class) && entity.hasComponent(VelocityComponent.class)) {
                PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
                VelocityComponent velocityComponent = entity.getComponent(VelocityComponent.class);

                positionComponent.setX(positionComponent.getX() + velocityComponent.getVelocityX());
                positionComponent.setY(positionComponent.getY() + velocityComponent.getVelocityY());
            }
        });
    }
}
