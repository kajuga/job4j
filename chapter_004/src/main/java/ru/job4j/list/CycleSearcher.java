package ru.job4j.list;

class CycleSearcher {

    /**
     * Method hasCycle - проверяет список на наличие замыканий
     *
     * @param first first
     * @return result
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        if (first != null) {
            Node slow = first;
            Node fast = first;
            while (fast != null && fast.next != null & fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}

class Node<T> {
    T value;
    Node<T> next;
    public Node(T value) {
        this.value = value;
    }
}




