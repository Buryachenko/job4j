package ru.job4j.email;

import org.junit.Test;

public class EmailNotificationTest {
    @Test
    public void whenToEmailUser() throws InterruptedException {
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.emailTo(new User("Ivan", "ivan@mail.ru"));
        emailNotification.emailTo(new User("Fedor", "fedor@mail.ru"));
        emailNotification.emailTo(new User("Roma", "roma@mail.ru"));
        emailNotification.close();
    }
}