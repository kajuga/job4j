package ru.job4j.map.hashMap;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void whenAddKeySetThenGetValueByKey() {
        HashMap<String, String> stringHashMap = new HashMap <>();
        stringHashMap.insert("bob", "AAA");
        assertThat(stringHashMap.get("bob"), is("AAA"));
        stringHashMap.insert("bob", "BBB");
        assertThat(stringHashMap.get("bob"), is("BBB"));
        stringHashMap.insert("gaga", "qqq");
        assertThat(stringHashMap.get("gaga"), is("qqq"));
        assertThat(stringHashMap.delete("bob"), is(true));
    }

    @Test
    public void whenArrayIsFilledThenGrownTwice() {
        HashMap<String, String> stringHashMap = new HashMap <>();
        stringHashMap.insert("1", "a");
        stringHashMap.insert("2", "b");
        stringHashMap.insert("3", "c");
        stringHashMap.insert("4", "d");
        stringHashMap.insert("5", "e");
        stringHashMap.insert("6", "g");
        stringHashMap.insert("7", "h");
        stringHashMap.insert("8", "j");
        stringHashMap.insert("9", "k");
        stringHashMap.insert("10", "l");
        stringHashMap.insert("11", "m");
        stringHashMap.insert("12", "n");
        stringHashMap.insert("13", "o");
        stringHashMap.insert("14", "p");
        stringHashMap.insert("15", "LOL");
        stringHashMap.insert("16", "r");
        stringHashMap.insert("17", "s");
        System.out.println(stringHashMap.size());
        assertThat(stringHashMap.get("15"), is("LOL"));
        assertThat(stringHashMap.hashTableLength(), is(32));
    }
}