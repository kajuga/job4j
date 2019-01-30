package ru.job4j.chatconsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private String botTextLine;
    private String humanTextLine;
    private boolean stopFlag = false;
    private List<String> stringArrayList;


    public void start(String fileIn, String fileOut) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut, true));
             Scanner scanner = new Scanner(System.in)) {

            stringArrayList = new ArrayList<>();
            while ((botTextLine = reader.readLine()) != null) {
                stringArrayList.add(botTextLine);
            }
            humanTextLine = scanner.nextLine();
            while (!"finish".equalsIgnoreCase(humanTextLine)) {
                if ("stop".equalsIgnoreCase(humanTextLine)) {
                    stopFlag = true;
                }
                if (humanTextLine.equalsIgnoreCase("continue")) {
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
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void stop() {
        stopFlag = true;
    }

    public int getIndex(List<String> stringArrayList) {
        return new Random().nextInt(stringArrayList.size());
    }
}