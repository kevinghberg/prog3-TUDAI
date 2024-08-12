package com.prog3.clase1;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size=0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        this.size--;
        return null;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public T get(int index) {
        // TODO
        return null;
    }

//complejidad O(1)
    public int size() {
        Node<T> cursor=this.first;
        int contador=0;
        while(cursor !=null){
            contador++;
            cursor = cursor.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

}