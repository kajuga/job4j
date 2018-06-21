package ru.job4j.cofeemaker;

public class CofeeMaker {

    public int[] changes(int value, int price) {
        int changes = value - price;
        int tenCounter = (changes / 10);
        int fiveCounter = ((changes - (tenCounter * 10)) / 5);
        int twoCounter = ((changes - ((tenCounter * 10) + (fiveCounter * 5))) / 2);
        int oneCounter = (changes - ((tenCounter * 10) + (fiveCounter * 5) + (twoCounter * 2)));

        int[] result = new int[tenCounter + fiveCounter + twoCounter + oneCounter];
        for (int i = 0; i < tenCounter; i++) {
            result[i] = 10;
        }
        for (int i = tenCounter; i < tenCounter + fiveCounter; i++) {
            result[i] = 5;
        }
        for (int i = tenCounter + fiveCounter; i < tenCounter + fiveCounter + twoCounter; i++) {
            result[i] = 2;
        }
        for (int i = tenCounter + fiveCounter + twoCounter; i < tenCounter + fiveCounter + twoCounter + oneCounter; i++) {
            result[i] = 1;
        }
        return result;
    }
}




