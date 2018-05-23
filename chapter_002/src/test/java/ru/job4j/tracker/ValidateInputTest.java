package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * //TODO add comments.
 *
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Incorrect value. Please enter correct value: %n")
                )
        );
    }

    @Test
    public void whenFirstAnswerIsCorrect() {
        ValidateInput validateInput = new ValidateInput(new StubInput(new String[]{"13"}));
        validateInput.ask("Введите число: ", new int[]{10, 13, 5});
        assertThat(this.mem.toString(), is(""));
    }

    @Test
    public void whenFirstNotNumberAndSecondAnswerIsCorrect() {
        ValidateInput validateInput = new ValidateInput(new StubInput(new String[]{"aaa", "10"}));
        validateInput.ask("Введите число: ", new int[]{10, 13, 5});
        assertThat(this.mem.toString(), is("Incorrect value. Please enter correct value: " + System.lineSeparator()));
    }

    @Test
    public void whenFirstNotNumberAndSecondNotNumberAndThirdAnswerIsCorrect() {
        ValidateInput validateInput = new ValidateInput(new StubInput(new String[]{"aaa", "ghfghfgh", "10"}));
        validateInput.ask("Введите число: ", new int[]{10, 13, 5});
        assertThat(this.mem.toString(), is("Incorrect value. Please enter correct value: " + System.lineSeparator()
                                        + "Incorrect value. Please enter correct value: " + System.lineSeparator()));
    }

    @Test
    public void whenFirstIncorrectNumberSecondNotNumberThirdAgainIncorrectNumberFirthIsCorrect() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"222", "sfdsfdfsdf", "333", "555"}));
        input.ask("Enter", new int[]{131, 111, 555});
        assertThat(this.mem.toString(), is("Please enter correct value from 0-5: " + System.lineSeparator()
                                        + "Incorrect value. Please enter correct value: " + System.lineSeparator()
                                        + "Please enter correct value from 0-5: " + System.lineSeparator()));
    }
}