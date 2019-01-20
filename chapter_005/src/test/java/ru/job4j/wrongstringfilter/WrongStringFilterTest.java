package ru.job4j.wrongstringfilter;

import org.junit.Test;
import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WrongStringFilterTest {
    private WrongStringFilter wrongStringFilter = new WrongStringFilter();
    private String[] abuse = {"five", "three", "four"};

    @Test
    public void whenFindAbuseWordsShouldDelete() {
        try (InputStream in = new ByteArrayInputStream("one two three four five".getBytes());
             OutputStream out = new ByteArrayOutputStream()) {

        System.setOut(new PrintStream(out));
        wrongStringFilter.dropAbuses(in, out, abuse);
        assertThat(out.toString(), is("one two "));

        final String target = "one two ";
        assertThat(out.toString(), is(target));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}