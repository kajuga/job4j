package ru.job4j.chatconsole;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ChatTest {
    private String fileBotText = "textForBot.txt";
    private String savedDialog = "chapter_005/src/test/java/ru/job4j/chatconsole/savedDialog.txt";

    @Test
    public void whenThen() {
        Chat chat = new Chat();
        chat.start(fileBotText, savedDialog);

    }







    }



/*
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello, Oracle");
        assertEquals("Hello, dear friend, I'm a Oracle.", response);
        client.sendMessage("exit");
 */