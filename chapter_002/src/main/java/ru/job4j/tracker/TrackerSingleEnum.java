package ru.job4j.tracker;

/**
 * Class Класс singleton типа enum
 * @athor Buryachenko
 * @since 30.01.19
 * @version 1
 */
public enum TrackerSingleEnum {
    INSTANCE;
    Tracker tracker = new Tracker();
    public Tracker getTracker() {
        return tracker;
    }
}

