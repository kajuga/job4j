package ru.job4j.producerconsumer;

/**
 * Интерфейс с булевой переменной
 * Соорудил для последовательного запуска
 * общий смысл - producer после того как отстрелялся меняет ее состояние, а моя очередь
 * фиксирует изменение и отпускает монитор.
 */
public interface BlackFlag {
    boolean alldone = false;
}
