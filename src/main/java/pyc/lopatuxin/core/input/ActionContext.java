package pyc.lopatuxin.core.input;

import java.util.HashMap;
import java.util.Map;

/**
 * Контекст действия, используемый для передачи параметров обработчикам действий.
 * Позволяет обогащать действие дополнительной информацией (например, сущностью, событием и т.п.).
 */
public class ActionContext {
    private final Map<String, Object> properties = new HashMap<>();

    public void set(String key, Object value) {
        properties.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) properties.get(key);
    }
}
