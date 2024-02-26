package net.eris.the.no5;

public interface StackInterface<T> {
    void push(T item);
    T top();
    T pop();
    int getSize();
}
