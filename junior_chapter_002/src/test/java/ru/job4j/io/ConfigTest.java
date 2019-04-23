package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class ConfigTest {
    @Test
    public void whenLoadProperties() {
        Config config = new Config("app.properties");
        config.load();
        assertThat(config.value("hibernate.dialect"),                   is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"),            is("jdbcpostgresql127.0.0.15432trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"),   is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"),       is("postgres"));
        assertThat(config.value("hibernate.connection.password"),       is("password"));
    }
}