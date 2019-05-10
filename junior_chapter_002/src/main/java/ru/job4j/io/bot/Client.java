package ru.job4j.io.bot;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class Client {

    private final Socket socket;
    private boolean work = true;

    public Client(String ipDest, int portDest) throws IOException {
        this.socket = new Socket(InetAddress.getByName(ipDest), portDest);
    }

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void init() throws IOException {
	    PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        do {
            String msg = console.nextLine();
            out.println(msg);
            this.work = !"exit".equals(msg);
            String str;
            while (this.work && !(str = in.readLine()).isEmpty()) {
                System.out.println(str);
            }
        } while (this.work);
    }
    
    public static void main(String[] args) {
        try {
            Client client = new Client("127.0.0.1", 5000);
            client.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
