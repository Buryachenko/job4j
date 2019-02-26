package ru.job4j.bank;

/**
 *
 * Class Класс предоставляет действия со счетом User
 * @athor Buryachenko
 * @since 26.02.2019
 * @version 1
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }
    public boolean transferMoney(Account dest, double amount) {
        boolean result = false;
        if (amount > 0 && amount <= this.value && dest != null) {
            dest.value += amount;
            this.value -= amount;
            result = true;
        }
        return result;
    }
}
