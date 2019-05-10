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
public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    private void testClient(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ByteArrayInputStream inputConsole = new ByteArrayInputStream(expected.getBytes());
        System.setIn(inputConsole);
        Client client = new Client(socket);
        client.init();
        System.setIn(System.in);
        assertThat((out.toString()), is(expected));
    }

    @Test
    public void whenClientSendHelloAndExit() throws IOException {
        this.testClient(
                String.format("Any message from the server.%s%s", LN, LN),
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit",
                        ""
                )
        );
    }
}