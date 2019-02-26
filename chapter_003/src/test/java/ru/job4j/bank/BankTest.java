package ru.job4j.bank;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {
    
    @Test
    public void whenBankAddUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "passport 123456");
        bank.addUser(user);
        assertThat(bank.deposits.size(), is(1));
    }
    @Test
    public void whenBankDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "passport 123456");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.deposits.size(), is(0));
    }
    @Test
    public void whenBankAddAccountToUser() {
        Bank bank = new Bank();
        String passport = "passport 123456";
        User user = new User("Ivan", passport);
        Account acc1 = new Account(1000.0f, "1");
        Account acc2 = new Account(1000.0f, "2");
        bank.addUser(user);
        bank.addAccountToUser(passport, acc1);
        bank.addAccountToUser(passport, acc2);
        bank.deleteAccountFromUser(passport, acc2);
        assertThat(bank.deposits.get(user).size(), is(1));
    }
    @Test
    public void whenBankTransferMoney() {
        final double amount = 500.555;
        Bank bank = new Bank();
        User source = new User("Ivan", "passport 123456");
        User dest = new User("Sergey", "passport 111111");
        Account accountSrc = new Account(1000.0f, "123456");
        Account accountDest = new Account(0.0f, "111111");
        bank.addUser(source);
        bank.addUser(dest);
        bank.addAccountToUser(source.getPassport(), accountSrc);
        bank.addAccountToUser(dest.getPassport(), accountDest);
        boolean result = bank.transferMoney(source.getPassport(), accountSrc.getRequisites(), dest.getPassport(), accountDest.getRequisites(), amount);
        assertThat(result, is(true));
    }
}
