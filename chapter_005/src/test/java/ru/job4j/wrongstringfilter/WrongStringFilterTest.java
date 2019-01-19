package ru.job4j.wrongstringfilter;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class WrongStringFilterTest {
    private WrongStringFilter wrongStringFilter = new WrongStringFilter();
    private String[] filterThisShit = {"beach", "fuck", "KISS MY ASS", "kill", "assholes", "drugs", "shit"};

    @Test
    public void whenFileHaveNonFilteredTextThenVzheekAndAllClear() {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/chapter_005/src/test/java/ru/job4j/wrongstringfilter/rapsongOut.txt")));
             DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/chapter_005/src/test/java/ru/job4j/wrongstringfilter/rapsongIn.txt"))) {

             }
             }
}





