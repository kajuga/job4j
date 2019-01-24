package ru.job4j.chatconsole;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChatTest {

    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();
        Scanner scanner = new Scanner(System.in);

        String path = "/home/kajuga/projects/job4j/chapter_005/src/test/java/ru/job4j/chatconsole/textForBot.txt";
        String lineFromFiles = new String(Files.readAllBytes(Paths.get(path)));
        List<String> stringList = new ArrayList<>(Arrays.asList(lineFromFiles.split("\n")));

        assertThat(stringList.get(0), is("We just wanna party"));


        //и фиг его знает как корректно оттестить- "бот" рандомные фразы выдает; одну фразу оставить в тексте - тож не дело.




    }
}