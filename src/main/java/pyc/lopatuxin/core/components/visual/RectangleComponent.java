package pyc.lopatuxin.core.components.visual;

import lombok.AllArgsConstructor;
import pyc.lopatuxin.core.components.movement.PositionComponent;
import pyc.lopatuxin.core.ecs.Component;
import pyc.lopatuxin.core.render.Renderable;

import java.awt.*;

/**
 * Компонент {@code RectangleComponent} представляет собой визуальный элемент,
 * который отрисовывает прямоугольник заданного размера и цвета на экране.
 *
 * <p>Компонент использует {@link PositionComponent} для определения координат
 * левого верхнего угла прямоугольника и реализует интерфейс {@link Renderable}
 * для участия в процессе отрисовки.</p>
 *
 * <p>Этот компонент подходит для отладки, UI-элементов, примитивных объектов
 * и других целей, где не требуется изображение или спрайт.</p>
 */
@AllArgsConstructor
public class RectangleComponent implements Component, Renderable {
    private final PositionComponent position;
    private final Color color;
    private final int width;
    private final int height;

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(position.getX(), position.getY(), width, height);
    }
}
