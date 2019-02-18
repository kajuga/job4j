package ru.job4j.chatconsole;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private String botTextLine;
    private String humanTextLine;
    private boolean stopFlag = false;
    private List<String> stringArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.start(chat.getClass().getClassLoader().getResource("textForBot.txt").getPath(),
                chat.getClass().getClassLoader().getResource("savedDialog.txt").getPath(),
                System.in);
    }


    public void start(String fileIn, String fileOut, InputStream in) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
             Scanner scanner = new Scanner(in)){

            while ((botTextLine = reader.readLine()) != null) {
                stringArrayList.add(botTextLine);
            }

            humanTextLine = scanner.nextLine();
            while (!"finish".equalsIgnoreCase(humanTextLine)) {
                if ("stop".equalsIgnoreCase(humanTextLine)) {
                    stopFlag = true;
                }
                if ("continue".equalsIgnoreCase(humanTextLine)) {
                    stopFlag = false;
                }
                writer.write(humanTextLine + "\n");
                if (!stopFlag) {
                    String botSay = stringArrayList.get(getIndex(stringArrayList));
                    System.out.println(botSay);
                    writer.write(botSay + "\n");
                }
                humanTextLine = scanner.nextLine();
            }
            writer.write(humanTextLine);
//            writer.flush();
//            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List botAnswersToArrayList(String botTextLine, BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        while ((botTextLine = reader.readLine()) != null) {
            result.add(botTextLine);
        }
        return result;

    }

    public  void stop() {
        stopFlag = true;
    }

    public int getIndex(List<String> stringArrayList) {
        return new Random().nextInt(stringArrayList.size());
    }
}