package pyc.lopatuxin.core.system;

import pyc.lopatuxin.core.components.movement.PositionComponent;
import pyc.lopatuxin.core.components.movement.VelocityComponent;
import pyc.lopatuxin.core.ecs.EntityManager;
import pyc.lopatuxin.core.ecs.System;

/**
 * Система движения, обновляющая координаты объектов на основе их скорости.
 * <p>
 * Эта система проходит по всем сущностям, у которых есть компоненты
 * {@link PositionComponent} и {@link VelocityComponent}, и обновляет их положение.
 * </p>
 */
public class MovementSystem implements System {

    @Override
    public void update(EntityManager entityManager) {
        entityManager.getEntitiesWithComponents(PositionComponent.class, VelocityComponent.class)
                .forEach(entity -> {
                    PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
                    VelocityComponent velocityComponent = entity.getComponent(VelocityComponent.class);

                    // Обновляем позицию на основе скорости
                    positionComponent.setX(positionComponent.getX() + velocityComponent.getVelocityX());
                    positionComponent.setY(positionComponent.getY() + velocityComponent.getVelocityY());
                });
    }
}
