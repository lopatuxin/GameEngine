package pyc.lopatuxin.core.components.movement;

import lombok.Getter;
import pyc.lopatuxin.core.components.Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
public class PlayerControlComponent implements Component, KeyListener {

    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> moveLeft = true;
            case KeyEvent.VK_RIGHT -> moveRight = true;
            case KeyEvent.VK_UP -> moveUp = true;
            case KeyEvent.VK_DOWN -> moveDown = true;
            default -> throw new IllegalStateException("Не допустимое значение KeyEvent: " + e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> moveLeft = false;
            case KeyEvent.VK_RIGHT -> moveRight = false;
            case KeyEvent.VK_UP -> moveUp = false;
            case KeyEvent.VK_DOWN -> moveDown = false;
            default -> throw new IllegalStateException("Не допустимое значение KeyEvent: " + e.getKeyCode());
        }
    }
}
