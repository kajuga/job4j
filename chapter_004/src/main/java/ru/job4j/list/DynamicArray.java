package ru.job4j.list;

import java.util.Iterator;

public class DynamicArray <E> implements Iterable<E> {
    private Object[] container = new Object[10];
    private int index;



    // TODO: 01.08.18 добавить элемент - по умолчанию - в конец.
 public void add(E value){
     this.container[index++] = value;


 }

    // TODO: 01.08.18 реализовать динамику контейнера - расширение если нужно
// public void



    // TODO: 01.08.18 возвратить элемент по индексу
 public E get(int index){


     return null;
 }





    // TODO: 01.08.18 с этой херью в конце разобраться
    @Override
    public Iterator<E> iterator() {

        return null;
    }

}
