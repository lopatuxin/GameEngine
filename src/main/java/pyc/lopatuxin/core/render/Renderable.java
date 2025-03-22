package pyc.lopatuxin.core.render;

import java.awt.*;

/**
 * Интерфейс для всех рендереров, которые знают, как отрисовать сущность.
 */
public interface Renderable {
    void render(Graphics g);
}
