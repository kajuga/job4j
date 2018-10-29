package ru.job4j.map.hashMap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashMapTest {
    HashMap<String, String> stringHashMap;

    @Before
    public void beforeTest() {
        stringHashMap = new HashMap <>();
        stringHashMap.insert("aaa", "bbbbb");
        stringHashMap.insert("xxx", "yyyyy");
        stringHashMap.insert("ccc", "ddddd");
    }

    @Test
    public void whenGetValueByKey() {
        assertThat(stringHashMap.get("aaa"), is("yyyyy"));
    }







}

/*

        list.delete();
        assertThat(list.get(0), is(2));
 */