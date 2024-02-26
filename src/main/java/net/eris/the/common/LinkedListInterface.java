package net.eris.the.common;

public interface LinkedListInterface<T> {
    void add(T data);

    T get(int index);

    void delete(int index);

    int getSize();
}
