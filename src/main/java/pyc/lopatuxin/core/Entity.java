package pyc.lopatuxin.core;

import lombok.Getter;
import pyc.lopatuxin.core.components.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Класс `Entity` представляет игровую сущность, которая состоит из набора компонентов.
 *
 * <p>Сущность сама по себе не содержит логики, но может обладать различными
 * компонентами, определяющими её поведение и свойства.</p>
 */
@Getter
public class Entity {

    private final UUID id = UUID.randomUUID();
    private final Map<Class<? extends Component>, Component> components = new HashMap<>();

    public <T extends Component> void addComponent(T component) {
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }

    public <T extends Component> boolean hasComponent(Class<T> type) {
        return components.containsKey(type);
    }

    public <T extends Component> void removeComponent(Class<T> type) {
        components.remove(type);
    }
}
