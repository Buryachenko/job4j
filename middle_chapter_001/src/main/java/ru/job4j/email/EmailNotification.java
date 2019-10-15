package ru.job4j.email;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class EmailNotification sends user email
 * @athor Burychenko
 * @since 15.10.19
 * @version 1
 */
public class EmailNotification {
    /**
     * @param pool created to send user data to e-mail
     */
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final Pattern KEYS = Pattern.compile("\\{.+?}");

    public void emailTo(User user) {
        this.pool.submit(() -> work(user));
    }

    private void work(User user) {
        final String username = user.getName();
        final String email = user.getEmail();
        String subject = generate(
                "Notification {username} to email {email}",
                Map.of("username", username, "email", email)
        );
        String body = generate(
                "Add a new event to {username}",
                Map.of("username", username)
        );
        send(subject, body, email);
    }

    public void send(String subject, String body, String email) {
        /**
         * todo
         */
        System.out.println(String.format(
                "{subject = %s, body = %s, email = %s}, [%s]", subject, body, email, Thread.currentThread().getName())
        );
    }

    public String generate(String template, Map<String, String> map) {
        Matcher matcher = this.KEYS.matcher(template);
        Set<String> set = new TreeSet<>();
        while (matcher.find()) {
            set.add(matcher.group());
        }
        if (set.size() < map.size()) {
            throw new NoSuchElementException("Extra key in map.");
        }
        return matcher.replaceAll(m -> map.get(template.substring(m.start() + 1, m.end() - 1)));
    }

    public void close() throws InterruptedException {
        this.pool.shutdown();
        while (!this.pool.isTerminated()) {
            Thread.sleep(1000);
        }
        System.out.println("Execute " + Thread.currentThread().getName());
    }
}
