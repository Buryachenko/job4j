package ru.job4j.department;
import java.util.*;
import java.util.stream.Collectors;
/**
*
* Class Класс сортирует департаменты по возрастанию/убыванию и удаляет дубликаты строк
* @version $Id$
* @since 21.03.19
*/
public class Department {
    private String[] departments;
    private String delim = "/";
    private enum Direct {
        rise, fall
    }
    
    public Department(String[] departments) {
        this.departments = departments;
    }

    private Comparator<String> compareString(Direct direct) {
        return (String o1, String o2) -> {
            int resStr = (direct == Direct.rise ? 1 : -1) * o1.compareTo(o2);
            int resLength = Integer.compare(o1.length(), o2.length());
            return resLength == 0 ? resStr : resLength;
        };
    }

    public String[] sortRising() {
        return this.convertArrayToMap(new TreeMap<>(String::compareTo))
                    .entrySet().stream().flatMap((entry) -> entry.getValue().stream().sorted(compareString(Direct.rise)))
                    .toArray(String[]::new);
    }

    public String[] sortFalling() {
        return this.convertArrayToMap(new TreeMap<>((String o1, String o2) -> (-1) * o1.compareTo(o2)))
                    .entrySet().stream().flatMap((entry) -> entry.getValue().stream().sorted(compareString(Direct.fall)))
                    .toArray(String[]::new);
    }

    public String[] removeDuplicate(String[] array) {
        List<String> list = Arrays.asList(array);
        return list.stream().distinct().toArray(String[]::new);
    }

    private TreeMap<String, Set<String>> convertArrayToMap(TreeMap<String, Set<String>> map) {
        for (String str : departments) {
            StringTokenizer token = new StringTokenizer(str, delim);
            String department = "";
            String service = "";
            String sub = "";
            if (token.hasMoreTokens()) {
                department = token.nextElement().toString();
                map.putIfAbsent(department, new TreeSet<>());
                map.get(department).add(department);
            }
            if (token.hasMoreTokens()) {
                service = token.nextElement().toString();
                map.get(department).add(department + delim + service);
            }
            if (token.hasMoreTokens()) {
                sub = token.nextElement().toString();
                map.get(department).add(department + delim + service + delim + sub);
            }
        }
        return map;
    }
}
