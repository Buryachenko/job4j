package ru.job4j.tracker;

/**
 * Class Класс singleton c ленивой загрузкой (lazy) в jvm
 * @athor Buryachenko
 * @since 30.01.19
 * @version 1
 */
public class TrackerSingleLazy extends Tracker {
    private static TrackerSingleLazy instance;

    private TrackerSingleLazy() {
    }

    public static TrackerSingleLazy getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazy();
        }
        return instance;
    }
}
