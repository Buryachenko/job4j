package ru.job4j.tracker;

/**
 * Class Класс singleton c энергичной загрузкой (eager) в jvm
 * @athor Buryachenko
 * @since 30.01.19
 * @version 1
 */
public class TrackerSingleEager extends Tracker {
    private static final TrackerSingleEager INSTANCE = new TrackerSingleEager();

    private TrackerSingleEager() {
    }

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }
}
