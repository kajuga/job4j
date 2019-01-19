package ru.job4j.imputoutput;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.Assert.*;

public class ByteStreamAuditorTest {
    private ByteStreamAuditor byteStreamAuditor = new ByteStreamAuditor();

    /**
     * Поток читает целое четное числож
     */
    @Test
    public void whenInputStreamReadEvenThenIsNumberIsTrue() {
        int value = 123456788;
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            assertTrue(byteStreamAuditor.isNumber(byteArrayInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Поток считвывает целое нечетное число
     */
    @Test
    public void whenInputStreamReadOddThenIsNumberIsFalse() {
        int value = 123456789;
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            assertFalse(byteStreamAuditor.isNumber(byteArrayInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавил проверку произвольного небольшого четного числа
     */
    @Test
    public void whenInputStreamReadAnotherEvenThenIsNumberIsTrue() {
        int value = 992;
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            assertTrue(byteStreamAuditor.isNumber(byteArrayInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
