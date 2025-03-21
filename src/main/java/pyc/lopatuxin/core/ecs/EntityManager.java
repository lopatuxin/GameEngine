package pyc.lopatuxin.core.ecs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Менеджер сущностей, который отвечает за хранение и управление всеми сущностями в игре.
 */
public class EntityManager {
    private final List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Entity getEntityById(UUID id) {
        return entities.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @SafeVarargs
    public final List<Entity> getEntitiesWithComponents(Class<? extends Component>... componentTypes) {
        return entities.stream()
                .filter(entity -> {
                    for (Class<? extends Component> type : componentTypes) {
                        if (!entity.hasComponent(type)) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList();
    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entities);
    }
}
