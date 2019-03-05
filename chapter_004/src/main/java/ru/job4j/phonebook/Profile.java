package ru.job4j.phonebook;
/**
 * Class Класс предоставляет данные о клиенте
 * @author Oleg Buryachenko (ovburyachenko@yandex.ru)
 * @since 05.03.19
 * @version 1
 */
class Profile {
    private Address address;
    public Profile(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
}
