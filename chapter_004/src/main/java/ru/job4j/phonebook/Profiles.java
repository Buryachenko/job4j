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
      List<Address> addr = profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
      return addr;
   }

    public List<Address> sortAddress(List<Profile> profiles) {
        List<Address> addr = collect(profiles);
        List<Address> result = addr.stream().distinct().collect(Collectors.toList());
        result.sort(new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        });
        return result;
    }
}
