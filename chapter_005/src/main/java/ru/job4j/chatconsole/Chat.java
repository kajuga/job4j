package ru.job4j.chatconsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {

    public static void main(String[] args) throws IOException {
        new Chat().chatter();
    }

    public void chatter() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("chapter_005/src/main/java/ru/job4j/chatconsole/textForBot.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("chapter_005/src/main/java/ru/job4j/chatconsole/savedDialog.txt", true));
             Scanner scanner = new Scanner(System.in)) {

            String botTextLine;
            List<String> stringArrayList = new ArrayList<>();

            while ((botTextLine = bufferedReader.readLine()) != null) {
                stringArrayList.add(botTextLine);
            }
            boolean stopFlag = false;
            String humanText = scanner.nextLine();
            while (!"finish".equalsIgnoreCase(humanText)) {
                if ("stop".equalsIgnoreCase(humanText)) {
                    stopFlag = true;
                }
                if (humanText.equalsIgnoreCase("continue")) {
                    stopFlag = false;
                }
                bufferedWriter.write(humanText + "\n");
                if (!stopFlag) {
                    String botSay = stringArrayList.get(getIndex(stringArrayList));
                    System.out.println(botSay);
                    bufferedWriter.write(botSay + "\n");
                }
                humanText = scanner.nextLine();
            }
            bufferedWriter.write(humanText);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndex(List<String> stringArrayList) {
        return new Random().nextInt(stringArrayList.size());
    }
}