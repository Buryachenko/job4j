package ru.job4j.list;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class  Класс преобразует List в Map
 * @author Buryachenko
 * @since 11.02.2019
 * @version 1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
