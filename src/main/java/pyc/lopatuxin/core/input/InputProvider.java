package pyc.lopatuxin.core.input;

/**
 * Интерфейс провайдера ввода, который определяет абстракцию для различных устройств ввода.
 */
public interface InputProvider {
    boolean isActionActive(String action);
}
