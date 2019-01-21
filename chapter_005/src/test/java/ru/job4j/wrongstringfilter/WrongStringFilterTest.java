package ru.job4j.wrongstringfilter;

import org.junit.Test;
import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WrongStringFilterTest {
    private WrongStringFilter wrongStringFilter = new WrongStringFilter();
    private String[] abuse = {"one", "three", "four"};

    @Test
    public void whenFindAbuseWordsShouldDelete() {
        try (InputStream in = new ByteArrayInputStream("one one two three four five four four one".getBytes());
             OutputStream out = new ByteArrayOutputStream()) {

        System.setOut(new PrintStream(out));
        wrongStringFilter.dropAbuses(in, out, abuse);
        assertThat(out.toString(), is("two five "));

        final String target = "two five ";
        assertThat(out.toString(), is(target));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}