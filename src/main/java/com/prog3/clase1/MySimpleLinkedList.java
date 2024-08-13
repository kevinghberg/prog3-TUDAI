package com.prog3.clase1;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int contador;

    public MySimpleLinkedList() {
        this.first = null;
        this.contador = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.contador++;
    }

    public T extractFront() {
        if(!this.isEmpty()){
            Node<T> aux = this.first;
            this.first = first.getNext();
            contador--;
            return aux.getInfo();
        }
        return null;
    }

    public boolean isEmpty() {

        return false;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        int contador = 0;
        while (contador != index) {
            contador++;
            aux = aux.getNext();
        }
        return aux.getInfo();
    }

    //complejidad O(1)
    public int size() {
        return contador;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

}