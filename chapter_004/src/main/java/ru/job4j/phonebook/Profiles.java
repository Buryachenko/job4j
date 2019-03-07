package ru.job4j.phonebook;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Class Класс предоставляет список клиентов
 * @author Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 05.03.19
 * @version 1
 */
public class Profiles {
   public List<Address> collect(List<Profile> profiles) {
      return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
   }

    public List<Address> sortAddress(List<Profile> profiles) {
        return collect(profiles).stream()
                                .sorted(Comparator.comparing(Address::getCity))
                                .distinct().collect(Collectors.toList());
    }
}
