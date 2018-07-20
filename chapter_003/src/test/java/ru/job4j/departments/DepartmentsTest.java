package ru.job4j.departments;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentsTest {

    /**
     * Сортирует массив по возрастанию, вставляя пропущенные "департаменты";
     * @throws Exception
     */
    @Test
    public void sortDeposAsc() throws Exception {
        Departments dep = new Departments();
        String[] input = {"K5\\SK2", "K5\\SK1", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] expect = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K5", "K5\\SK1", "K5\\SK2"};
        String[] result = dep.sortDeposAsc(input);
        assertArrayEquals(expect, result);
    }

    /**
     * Сортировка массива по убыванию
     * @throws Exception
     */
    @Test
    public void sortDeposDesc() throws Exception {
        Departments dep = new Departments();
        String[] input = {"K3", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K3\\SK1"};
        String[] expect = {"K3", "K3\\SK1", "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        String[] result = dep.sortDeposDesc(input);
        assertArrayEquals(expect, result);
    }
}