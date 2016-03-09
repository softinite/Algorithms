package com.softinite.algorithms.immutable;

/**
 * Implements an immutable queue
 * Created by Softinite on 2016-03-08.
 */
public class QueueImpl<T> implements Queue<T> {

    static class Node<T> {
        final T content;
        final Node<T> precedent;
        Node(T t) {
            content = t;
            precedent = null;
        }

        Node(T t, Node<T> p) {
            content = t;
            precedent = p;
        }
    }

    private final Node<T> head;
    private final Node<T> tail;

    public QueueImpl() {
        head = null;
        tail = null;
    }

    protected QueueImpl(T t) {
        tail = head = new Node<>(t);
    }

    protected QueueImpl(Node<T> h, Node<T> p, T t) {
        head = h;
        tail = new Node<>(t, p);
    }

    protected QueueImpl(Node<T> h, Node<T> t) {
        head = h;
        tail = t;
    }

    public Queue<T> enQueue(T t) {
        if (isEmpty()) {
            return new QueueImpl<>(t);
        }
        return new QueueImpl<>(head, tail, t);
    }

    public Queue<T> deQueue() {
        if (isEmpty() || head == tail) {
            return new QueueImpl<>();
        }
        Node<T> newHead = tail;
        while(newHead.precedent != head) {
            newHead = newHead.precedent;
        }
        return new QueueImpl<>(newHead, tail);
    }

    public T head() {
        if (head != null) {
            return head.content;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
