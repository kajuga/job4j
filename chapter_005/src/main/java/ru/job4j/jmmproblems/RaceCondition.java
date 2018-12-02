package ru.job4j.jmmproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Race condition example
 */
public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
//        public static volatile boolean isWinnerFound = false;
        public static boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            try {
                if (!OnlineGame.isWinnerFound) {
                    for (String sstr : OnlineGame.steps) {
                        sleep(1000 / rating);
                        System.out.println(getName() + " " + sstr);
                    }
                    System.out.println(getName() + " победитель!!");
                    OnlineGame.isWinnerFound = true;
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " проиграл");
            }
        }
    }
}