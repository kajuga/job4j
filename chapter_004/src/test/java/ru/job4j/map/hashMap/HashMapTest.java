package ru.job4j.map.hashMap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashMapTest {
    HashMap<String, Integer> stringHashMap;

    @Before
    public void beforeTest() {
        stringHashMap = new HashMap <>();
        stringHashMap.insert("bob", 15);
        stringHashMap.insert("qwerty", 777);
        stringHashMap.insert("terminator", 888);
    }

    @Test
    public void whenGetValueByKey() {
        assertThat(stringHashMap.get("bob"), is(15));
        stringHashMap.insert("bob", 888);
        assertThat(stringHashMap.get("bob"), is(888));
//        assertThat(stringHashMap.get("qwerty"), is(777));

    }







}

/*

        list.delete();
        assertThat(list.get(0), is(2));
 */