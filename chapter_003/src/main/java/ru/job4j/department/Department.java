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

    private Comparator<String> CompareString(Direct direct) {
        return (String o1, String o2) -> {
            int resStr = (direct == Direct.rise ? 1 : -1) * o1.compareTo(o2);
            int resLength = Integer.compare(o1.length(), o2.length());
            return resLength == 0 ? resStr : resLength;
        };
    }

    public String[] sortRising() {
        String[] array = this.convertArrayToMap(new TreeMap<>(String::compareTo))
                .entrySet().stream().flatMap((entry) -> {
                    entry.getValue().sort(CompareString(Direct.rise));
                    return entry.getValue().stream();
                }).collect(Collectors.toList()).toArray(new String[0]);
       return removeDuplicate(array);
    }

    public String[] sortFalling() {
        String[] array = this.convertArrayToMap(new TreeMap<>((String o1, String o2) -> (-1) * o1.compareTo(o2)))
                .entrySet().stream().flatMap((entry) -> {
                    entry.getValue().sort(CompareString(Direct.fall));
                    return entry.getValue().stream();
                }).collect(Collectors.toList()).toArray(new String[0]);
       return removeDuplicate(array);
    }

    public String[] removeDuplicate(String[] array) {
        List<String> list = Arrays.asList(array);
        return list.stream().distinct().collect(Collectors.toList()).toArray(new String[0]);
    }

    private TreeMap<String, List<String>> convertArrayToMap(TreeMap<String, List<String>> map) {
        for (String str : departments) {
            StringTokenizer token = new StringTokenizer(str, delim);
            String department = "";
            String service = "";
            String sub = "";
            if (token.hasMoreTokens()) {
                department = token.nextElement().toString();
                map.putIfAbsent(department, new ArrayList<>());
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
