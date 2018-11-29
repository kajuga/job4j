package ru.job4j.count;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
    class Count {
    @GuardedBy("this")
    private int value;

    synchronized void increment() {
        this.value++;
    }
    synchronized int get() {
        return this.value;
    }
}
