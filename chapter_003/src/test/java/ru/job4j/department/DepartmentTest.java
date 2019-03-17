package ru.job4j.department;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Test. Отсортировать департаменты.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentTest {

    public String[] sort(String[] departments, int signed) {
        Map<String, List<String>> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return signed * o1.compareTo(o2);
            }
        });
        for (String str : departments) {
            StringTokenizer token = new StringTokenizer(str, "/");
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
                map.get(department).add(department + "/" + service);
            }
            if (token.hasMoreTokens()) {
                sub = token.nextElement().toString();
                map.get(department).add(department + "/" + service + "/" + sub);
            }
        }
        return map.entrySet().stream().flatMap((entry) -> {
                        entry.getValue().sort(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            int resStr = signed * o1.compareTo(o2);
                            int resLength = Integer.compare(o1.length(), o2.length());
                            return resLength == 0 ? resStr : resLength;
                        }
                    });
                    return entry.getValue().stream();
        }).distinct().collect(Collectors.toList()).toArray(String[]::new);
    }

    @Test
    public void whenSortUpDepartment() {
        String[] departments = {
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};

        String[] expected = {
                                    "K1",
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2/SK1",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};
        String[] result = sort(departments, 1);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortDownDepartment() {
        String[] departments = {
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};

        String[] expected = {
                                    "K2",
                                    "K2/SK1",
                                    "K2/SK1/SSK2",
                                    "K2/SK1/SSK1",
                                    "K1",
                                    "K1/SK2",
                                    "K1/SK1",
                                    "K1/SK1/SSK2",
                                    "K1/SK1/SSK1"};
        String[] result = sort(departments, -1);
        assertThat(result, is(expected));
    }
}