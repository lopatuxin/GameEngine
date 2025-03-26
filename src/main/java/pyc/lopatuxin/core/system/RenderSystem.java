package pyc.lopatuxin.core.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pyc.lopatuxin.core.ecs.EntityManager;
import pyc.lopatuxin.core.ecs.System;
import pyc.lopatuxin.core.render.Renderable;

import java.awt.*;

/**
 * Система рендера, отвечающая за отрисовку визуальных компонентов.
 *
 * <p>Эта система перебирает все сущности, и вызывает метод {@code render()}
 * у всех компонентов, реализующих интерфейс {@link Renderable}.
 * Компоненты сами отвечают за логику отрисовки с помощью переданного
 * {@link Graphics} объекта.</p>
 *
 * <p>Это позволяет создать гибкую и расширяемую архитектуру, в которой
 * любой компонент может участвовать в отрисовке, реализуя {@code Renderable}.</p>
 */
@Getter
@AllArgsConstructor
public class RenderSystem implements System {
    private final Graphics graphics;

    @Override
    public void update(EntityManager entityManager) {
        entityManager.getAllEntities().stream()
                .flatMap(entity -> entity.getComponents().values().stream())
                .filter(Renderable.class::isInstance)
                .map(Renderable.class::cast)
                .forEach(renderable -> renderable.render(graphics));
    }
}
