package net.eris.the.no4;

import net.eris.the.no3.MyLinkedList;

public class MyQueue<T> implements QueueInterface<T> {
    private final MyLinkedList<T> linkedList = new MyLinkedList<>();

    @Override
    public void push(T item) {
        linkedList.add(item);
    }

    @Override
    public T pop() {
        T ret = peek();
        linkedList.delete(0);
        return ret;
    }

    @Override
    public T peek() {
        return linkedList.get(0);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
