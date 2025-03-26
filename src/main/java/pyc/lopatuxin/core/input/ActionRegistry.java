package pyc.lopatuxin.core.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Реестр действий, позволяющий регистрировать и вызывать обработчики по имени действия.
 * Поддерживает несколько подписчиков на одно действие.
 */
public class ActionRegistry {
    private static final Map<String, List<Consumer<ActionContext>>> actionHandlers = new HashMap<>();

    public static void registerHandler(String actionName, Consumer<ActionContext> handler) {
        actionHandlers.computeIfAbsent(actionName, k -> new ArrayList<>()).add(handler);
    }

    public static void triggerAction(String actionName, ActionContext context) {
        List<Consumer<ActionContext>> handlers = actionHandlers.get(actionName);
        if (handlers != null) {
            handlers.forEach(handler -> handler.accept(context));
        }
    }

    public static void clearHandlers(String actionName) {
        actionHandlers.remove(actionName);
    }
}
