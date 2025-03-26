package pyc.lopatuxin.core.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Источник пользовательского ввода с событийной моделью обработки.
 *
 * <p>Связывает клавиши с именами действий и вызывает соответствующие обработчики
 * через {@link ActionRegistry}, как только клавиша нажата.</p>
 *
 * <p>Также поддерживает отслеживание активных действий, основанных на удерживаемых клавишах.</p>
 */
public class DeclarativeKeyboardInput implements InputSource, KeyListener {
    private final Set<String> pressedActionKeys = new HashSet<>();
    private final Map<Integer, String> keyMappings = new HashMap<>();

    public void mapKeyToAction(int keyCode, String actionName) {
        keyMappings.put(keyCode, actionName);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String action = keyMappings.get(e.getKeyCode());
        if (action != null) {
            pressedActionKeys.add(action);

            ActionContext context = new ActionContext();
            context.set("keyEvent", e);
            ActionRegistry.triggerAction(action, context);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String action = keyMappings.get(e.getKeyCode());
        if (action != null) {
            pressedActionKeys.remove(action);
        }
    }

    @Override
    public Collection<String> getActiveActions() {
        return new HashSet<>(pressedActionKeys);
    }
}
