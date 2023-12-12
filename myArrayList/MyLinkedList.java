package com.myArrayList;

import java.util.Collection;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            Node<E> newNode = new Node  (element, head);
            head = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            Node<E> newNode = new Node (element, prev.next);
            prev.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> node = getNode(index);
        return node.item;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            E removed = head.item;
            head = head.next;
            size--;
            return removed;
        } else {
            Node<E> prev = getNode(index - 1);
            E removed = prev.next.item;
            prev.next = prev.next.next;
            size--;
            return removed;
        }
    }

    public void addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
