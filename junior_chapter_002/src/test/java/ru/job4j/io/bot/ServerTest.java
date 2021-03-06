package ru.job4j.io.bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.init();
        assertThat((out.toString()), is(expected));
    }

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit"
                ),
                String.format("Hello, dear friend, I'm a oracle.%s%s", LN, LN)
        );
    }

    @Test
    public void whenUnsupportedThenDontUnderstand() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "unsupported ask",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "I dont't understand",
                        "",
                        ""
                )

        );
    }
}