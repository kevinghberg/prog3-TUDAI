package com.prog3.clase1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterator<T> {

    private Node<T> first;
    private int contador;
    private Node<T> last;

    public MySimpleLinkedList() {
        this.first = null;
        this.contador = 0;
        this.last = null;
    }

    public void insertFront(T info) {
        Node<T> aux = new Node<T>(info, null); // creamos un nodo con valor (info) que apunte a null
        aux.setNext(this.first); //                 // el nodo aux ahora apunta a el primero de la lista
        this.first = aux;                           // el primero nodo ahora aux ( con el valor (info)) y este ahora apunta a el nodo inicial de la lista en su origen
        if (this.contador == 0)                     // si el this.contador que es el tamanio de la lista es 0 ..
            this.last = this.first;                 // el primer nodo tambien es el ultimo
        this.contador++;                            // aumentamos el contador para aumentar un 1 el tamanio de la lista
    }

    // metodo con atributo del ultimo nodo de la lista
    public void insertLast2(T info) {
        Node<T> aux = new Node<T>(info, null);  // creamos un nodo con valor (info) que apunte a null
        if (this.size() == 0) {                      // si tamanio de la lista es 0
            insertFront(info);                       // insertamos un nodo
            this.first = this.last;                    // este primer nodo tambien es el ultimo ya que hay 1 solo elemento en la lista
        } else {
            this.last.setNext(aux);                 //si hay elementos en la lista, el ulitmo nodo apunta al nodo auxiliar
            this.last = aux;                         // y ahora ultimo es auxilar
            contador++;                             // incrementamos contador 1 aumentando el tamanio de la lista en 1 porqe insetamos un nodo al final
        }
    }

    public T extractFront() {
        if (!this.isEmpty()) {              // si la lista esta vacia retorno null, sino.. sigue
            Node<T> aux = this.first;       // creo un nodo que apunta al primero de la lista
            this.first = first.getNext();   // ese primer nodo apunta al siguien, asi se 'descenlasa' de la lista
            if (this.first == null)         // si el primer nodo de la lista es null, quiere decir qe la lista esta vacia
                this.last = null;           // si esta vacia debemos pasar el atributo last a null
            contador--;                     // reducimos el tamanio de la lista
            return aux.getInfo();           // retornamos el nodo qe eliminamos
        }
        return null;                        // en caso de que la lista este vacia.
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    // metodo para obtener el valor de un nodo en una posicion dada (index) dentro de una lista

    public T get(int index) {
        if (index >= 0 && index < this.size()) {      //verifica que el valor sea mayor a 0, pero no mas grande qe el tamanio de la lista.
            Node<T> aux = this.first;                 //creamos un nodo y lo igualamos al primero de la lista
            int contador = 0;                         // contador en 0 para usarlo al iterar sobre la lista
            while (contador != index) {               // mientras que el contador sea distinto de la posicion dada (index)
                contador++;                           // +1 al contador por cada vez que itera
                aux = aux.getNext();                  // el nodo va a apuntar al siguiente
            }
            return aux.getInfo();                     // al llegar a la posicion dada(index) retornamos el valor en dicha posicion
        }
        return null;                                  // retorna null en caso de que la lista este vacia o la posicion dada sea menor a  0
    }

    //complejidad O(1)
    public int size() {
        return contador;
    }


    // metodo para encontrar el indice de un nodo y retornar su valor
    public int indexOf(T info) {
        Node<T> aux = this.first;
        int contador = 0;
        while (aux != null && !aux.getInfo().equals(info)) {                // mientras haya un siguiente nodo en la lista y el valor del nodo sea dif al que buscamos. usa equals porqe compara 2 objetos
            contador++;                                                     // aumenta el contador en 1
            aux = aux.getNext();                                            // el nodo apunta al siguiente en cada iteracion
        }
        if (aux != null && aux.getInfo().equals(info)) {                                    // verifica si el nodo actual (aux) contiene el valor buscado (info).
            return contador;                                                // retorna el contador ( este representa el indice del nodo en la lista)
        } else
            return -1;                                                      // retorna -1 en caso de que el elemento no esta en la lista
    }

    public MySimpleLinkedList<T> unirListasElementosComun(MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<T>();

        Node<T> aux1 = this.first;
        while (aux1 != null) {
            Node<T> aux2 = lista2.first;
            while (aux2 != null) {
                if (aux1.getInfo().equals(aux2.getInfo()) && newList.indexOf(aux1.getInfo()) == -1) {
                    newList.insertFront(aux1.getInfo());
                }
                aux2 = aux2.getNext();
            }
            aux1 = aux1.getNext();
        }
        return newList;
    }

    public MySimpleLinkedList<T> unirListasConElementosDistintos(MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<T>();
        Node<T> aux1 = this.first;
        while (aux1 != null) {
            if (newList.indexOf(aux1.getInfo()) == -1 && lista2.indexOf(aux1.getInfo()) == -1) {
                newList.insertFront(aux1.getInfo());
            }
            aux1 = aux1.getNext();
        }
        Node<T> aux2 = lista2.first;
        while (aux2 != null) {
            if (newList.indexOf(aux2.getInfo()) == -1 && this.indexOf(aux2.getInfo()) == -1) {
                newList.insertFront(aux2.getInfo());
            }
            aux2 = aux2.getNext();
        }
        return newList;
    }

    public MySimpleLinkedList ordenarListaMenorAMayor(MySimpleLinkedList<T> lista) {

        return null;
    }

    @Override
    public String toString() {
        String todo = "";
        Node<T> aux = this.first;
        while (aux != null) {
            todo = todo + aux.getInfo();
            aux = aux.getNext();
            if (aux != null) {
                todo = todo + ",";
            }
        }
        return "[" + todo + "]";
    }

    @Override
    public boolean hasNext() {
        return this.first != null;
    }

    @Override
    public T next() {
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        return info;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}