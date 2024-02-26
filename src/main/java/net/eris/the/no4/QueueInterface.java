package net.eris.the.no4;

public interface QueueInterface<T> {
    void push(T item);
    T pop();
    T peek();
    int getSize();
}
