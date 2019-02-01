package ru.job4j.chatconsole;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.Is.is;

public class ChatTest {

    private String fileBotText = "/home/kajuga/projects/job4j/chapter_005/src/test/resources/textForBot.txt";
    private String savedDialog = "/home/kajuga/projects/job4j/chapter_005/src/main/resources/savedDialog.txt";
    Chat chat = new Chat(){
        @Override
        public int getIndex(List<String> stringArrayList) {
            return super.getIndex(stringArrayList);
        }
    };
    String[] inputs = new String[] {"привет", "скажи что-нибудь", "стоп", "продолжить", "закончить"};

    @Test
    public void whenUseChatThenOutputNotEmpty() {
//            chat.start(fileBotText, savedDialog);
//            chat.botAnswersToArrayList(fileBotText);




//            List<String> allMessages = fileBotText.toString();
//            assertThat(allMessages.size(), is(7));
//            assertThat(allMessages.get(0), is("some"));
//            assertThat(allMessages.get(2), is("STOP"));
//            assertThat(allMessages.get(3), is("some"));
//            assertThat(allMessages.get(4), is(Logic.CONTINUE));
//            assertThat(allMessages.get(6), is(Logic.CLOSE));
        }

    }