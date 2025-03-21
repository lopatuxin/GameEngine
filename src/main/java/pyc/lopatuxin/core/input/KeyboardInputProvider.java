package pyc.lopatuxin.core.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyboardInputProvider implements InputProvider, KeyListener {
    private final Map<String, Integer> actionKeyMap = new HashMap<>();
    private final Set<Integer> pressedKeys = new HashSet<>();

    public void mapAction(String action, int keyCode) {
        actionKeyMap.put(action, keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public boolean isActionActive(String action) {
        Integer keyCode = actionKeyMap.get(action);

        return keyCode != null && pressedKeys.contains(keyCode);
    }

    public void setupDefaultMovementControls() {
        mapAction("moveLeft", KeyEvent.VK_LEFT);
        mapAction("moveRight", KeyEvent.VK_RIGHT);
        mapAction("moveUp", KeyEvent.VK_UP);
        mapAction("moveDown", KeyEvent.VK_DOWN);
    }
}
