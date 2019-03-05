package ru.job4j.phonebook;
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
}
