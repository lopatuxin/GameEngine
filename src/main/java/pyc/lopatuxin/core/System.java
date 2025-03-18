package pyc.lopatuxin.core;

import java.util.List;

/**
 * Интерфейс `System` определяет базовую структуру всех игровых систем.
 *
 * <p>Системы обрабатывают сущности, у которых есть определённые компоненты,
 * и выполняют над ними логику (например, движение, рендеринг, столкновения).</p>
 */
public interface System {

    void update(List<Entity> entities);
}
