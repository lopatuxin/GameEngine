package pyc.lopatuxin.core.loop;

import lombok.AllArgsConstructor;
import pyc.lopatuxin.core.ecs.EntityManager;
import pyc.lopatuxin.core.ecs.SystemManager;
import pyc.lopatuxin.core.input.ActionContext;
import pyc.lopatuxin.core.input.ActionRegistry;
import pyc.lopatuxin.core.input.InputSource;

@AllArgsConstructor
public class GameLoop implements Runnable {

    private final SystemManager systemManager;
    private final EntityManager entityManager;
    private final InputSource inputSource;
    private boolean running;
    private final int targetFps = 60;

    @Override
    public void run() {
        long frameTime = 1000 / targetFps;

        while (running) {
            long start = System.currentTimeMillis();

            processInput();
            updateLogic();

            long elapsed = System.currentTimeMillis() - start;
            long sleep = frameTime - elapsed;

            if (sleep > 0) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    private void processInput() {
        inputSource.getActiveActions().forEach(actionName -> {
            ActionContext context = new ActionContext();
            ActionRegistry.triggerAction(actionName, context);
        });
    }

    private void updateLogic() {
        systemManager.updateAll(entityManager);
    }

    public void stop() {
        running = false;
    }
}
