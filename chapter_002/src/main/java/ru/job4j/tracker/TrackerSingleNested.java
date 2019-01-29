package ru.job4j.tracker;
/**
 * Class Класс singleton c ленивой загрузкой в jvm, объект класса создается при создании объекта внутреннего класса
 * @athor Buryachenko
 * @since 30.01.19
 * @version 1
 */
public class TrackerSingleNested extends Tracker {
    private TrackerSingleNested() {
    }

    public static TrackerSingleNested getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleNested INSTANCE = new TrackerSingleNested();
    }
}
