package ru.job4j.bank;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * Class Класс предоставляет действия со счетами User
 * @athor Buryachenko
 * @since 26.02.2019
 * @version 1
 */
public class Bank {
    public HashMap<User, List<Account>> deposits = new HashMap<>();

    public Bank() {

    }

    public Bank(HashMap<User, List<Account>> balance) {
        this.deposits = balance;
    }

    public void addUser(User user) {
        this.deposits.putIfAbsent(user, new ArrayList<>());
    }
    
    private List<Account> defaultUserAccount() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(0.0f, UUID.randomUUID().toString()));
        return accounts;
    }

    public void deleteUser(User user) {
        this.deposits.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        Set<User> users = this.deposits.keySet();
        this.deposits.get(users.stream()
                                .filter(u -> u.getPassport().equals(passport))
                                .findFirst().orElse(null))
                                .add(account);
    }

    public  void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) != -1) {
            accounts.remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        Set<User> users = this.deposits.keySet();
        return  this.deposits.get(users.stream()
                                .filter(u -> u.getPassport().equals(passport))
                                .findFirst().orElse(null));
    }
    
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account source = getActualAccount(srcPassport, srcRequisite);
        Account dest = getActualAccount(destPassport, destRequisite);
        return source != null && dest != null && source.transferMoney(dest, amount);
    }
    
    private Account getActualAccount(String passport, String requisite) {
        return getUserAccounts(passport).stream()
                                .filter(acc -> acc.getRequisites()
                                .equals(requisite))
                                .findFirst().orElse(null);
    }
}
