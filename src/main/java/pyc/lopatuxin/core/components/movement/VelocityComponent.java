package pyc.lopatuxin.core.components.movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pyc.lopatuxin.core.ecs.Component;

/**
 * Компонент, представляющий скорость движения объекта.
 * <p>
 * Этот компонент хранит скорость по осям X и Y, которая используется в системах движения.
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
public class VelocityComponent implements Component {

    private float velocityX;
    private float velocityY;
}
