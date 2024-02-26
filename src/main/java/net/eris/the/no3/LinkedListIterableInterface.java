package net.eris.the.no3;

public interface LinkedListIterableInterface<T> extends Iterable<T> {
    void add(T data);

    T get(int index);

    void delete(int index);

    int getSize();
}
