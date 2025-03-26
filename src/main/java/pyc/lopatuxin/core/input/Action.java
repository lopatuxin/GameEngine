package pyc.lopatuxin.core.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Абстрактный класс, представляющий действие пользователя.
 * Используется для именованной идентификации действий в системе ввода.
 */
@Getter
@AllArgsConstructor
public abstract class Action {
    private final String name;
}
