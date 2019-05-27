package ru.job4j.tracker;
/**
 *  Interface Интерфейс добавления действий пользователя.
 *  @author Buryachenko
 *  @since 14.01.2019
 *  @version 1
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     * @return ключ
     */
    int key();
    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, ITracker tracker);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
