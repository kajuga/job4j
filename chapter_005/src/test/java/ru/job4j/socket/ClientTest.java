package ru.job4j.socket;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void givenGreetingClientwhenServerRespondsWhenStartedthenCorrect() throws IOException {
//        new Thread(() -> {
//            Server server = new Server();
//            try {
//                server.start(6666);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        Thread.sleep(2000);
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello, Oracle");
        assertEquals("Hello, dear friend, I'm a Oracle.", response);
        client.sendMessage("exit");
    }
}