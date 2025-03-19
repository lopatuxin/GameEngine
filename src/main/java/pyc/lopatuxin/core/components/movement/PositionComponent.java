package pyc.lopatuxin.core.components.movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pyc.lopatuxin.core.components.Component;

/**
 * Компонент, представляющий положение объекта в игровом мире.
 * <p>
 * Этот компонент хранит координаты (x, y) объекта и используется в системах движения.
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
public class PositionComponent implements Component {

    private float x;
    private float y;
}
