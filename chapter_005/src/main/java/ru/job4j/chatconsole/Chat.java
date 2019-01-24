package ru.job4j.chatconsole;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Chat {

    public void chatter() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/kajuga/projects/job4j/chapter_005/src/main/java/ru/job4j/chatconsole/textForBot.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/kajuga/projects/job4j/chapter_005/src/main/java/ru/job4j/chatconsole/savedDialog.txt", true));
             Scanner scanner = new Scanner(System.in)) {

            String humanText;
            String botTextLine;
            ArrayList<String> stringArrayList = new ArrayList<> ();

            while ((botTextLine = bufferedReader.readLine()) != null) {
                stringArrayList.add(botTextLine);
            }
            boolean stopFlag = false;
            while (!(humanText = scanner.nextLine()).equalsIgnoreCase("finish")) {
                if (humanText.equalsIgnoreCase("stop")){
                    stopFlag = true;
                }
                if (humanText.equalsIgnoreCase("continue")){
                    stopFlag = false;
                }
                bufferedWriter.write(humanText + "\n");
                if (!stopFlag) {
                    String botSay = stringArrayList.get(new Random().nextInt(stringArrayList.size()));
                    System.out.println(botSay);
                    bufferedWriter.write(botSay + "\n");
                }
            }
            bufferedWriter.write(humanText);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}