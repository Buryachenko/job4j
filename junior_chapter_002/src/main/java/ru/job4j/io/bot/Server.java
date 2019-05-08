package ru.job4j.io.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class Server {
    private Socket socket;

    public  Server(int port) throws IOException {
        this.socket = new ServerSocket(port).accept();
    }
    public Server(Socket socket) {
        this.socket = socket;
    }

    public void init() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello oracle".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!("exit".equals(ask))) {
                out.println("I dont't understand");
                out.println();
            }
        } while (!("exit".equals(ask)));
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(5000);
            server.init();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}