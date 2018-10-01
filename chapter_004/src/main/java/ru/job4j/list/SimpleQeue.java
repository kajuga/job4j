package ru.job4j.list;

import java.util.Stack;

/**
 * @author Fedorov Aleksandr (msg2fedorov@gmail.com).
 * realisation of queue via two stacks.
 * @param <T>
 */
public class SimpleQeue<T> {
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    /**
     * method add element in first stack.
     */
    public void push(T e) {
        stack1.push(e);
    }

    /**
     * method grab fist element in second stack added early from first.
     * @return element
     */
    public T poll() {
        if (stack2.isEmpty()) {
            stackCentipede();
        }
        return stack2.pop();
    }

    /**
     * method transfer date from first stack to second
     */
    private void stackCentipede() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}