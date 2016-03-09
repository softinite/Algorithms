package com.softinite.algorithms.immutable;

/**
 * Defines the contract of a Queue
 * Created by Softinite on 2016-03-08.
 */
public interface Queue<T> {

    Queue<T> enQueue(T t);
    Queue<T> deQueue();
    T head();
    boolean isEmpty();

}
