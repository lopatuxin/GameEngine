package pyc.lopatuxin.graphics;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class GameWindow {
    private final JFrame frame;
    private final Canvas canvas;

    public GameWindow(int width, int height, String title) {
        this.frame = createFrame(width, height, title);
        this.canvas = new Canvas();

        frame.add(canvas);
        frame.setVisible(true);
    }

    private JFrame createFrame(int width, int height, String title) {
        JFrame window = new JFrame(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        return window;
    }

    public void setBackgroundColor(Color color) {
        canvas.setBackground(color);
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    public void hideWindow() {
        frame.setVisible(false);
    }

    public void closeWindow() {
        frame.dispose();
    }
}
