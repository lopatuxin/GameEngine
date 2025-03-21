package pyc.lopatuxin.core.ecs;

import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер систем, который отвечает за хранение и выполнение всех игровых систем.
 */
public class SystemManager {
    private final List<System> systems = new ArrayList<>();

    public void addSystem(System system) {
        if (!systems.contains(system)) {
            systems.add(system);
        }
    }

    public void removeSystem(System system) {
        systems.remove(system);
    }

    public void updateAll(EntityManager entityManager) {
        for (System system : systems) {
            system.update(entityManager);
        }
    }

    public List<System> getAllSystems() {
        return new ArrayList<>(systems);
    }
}
