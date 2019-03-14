package ru.job4j.chatconsole;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.List;

public class ChatTest {

    @Test
    public void testChat() throws IOException {
        Chat chat = new Chat() {
            int index = 0;
            @Override
            public int getIndex(List<String> stringArrayList) {
                return index++;
            }
        };
        String fileIn = chat.getClass().getClassLoader().getResource("textForBot.txt").getPath();
        String fileOut = chat.getClass().getClassLoader().getResource("savedDialog.txt").getPath();
        InputStream inputStream = new FileInputStream(chat.getClass().getClassLoader().getResource("textScannerEmulator.txt").getPath());
        chat.start(fileIn, fileOut, inputStream);

        String expected = "hi, chatbot!\n"
                + "We just wanna party\n"
                + "tell me why?\n"
                + "Party just for you\n"
                + "stop\n"
                + "continue\n"
                + "We just want the money\n"
                + "finish";

        String actual = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileOut));
        String temp;
        int index = 0;
        while ((temp = reader.readLine())  != null) {
            if (index != 0) {
                actual = actual.concat("\n");
            }
            actual = actual.concat(temp);
            index++;
        }
        Assert.assertEquals(expected, actual);
    }
}