package com.prog3.clase1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <T> void main(String[] args) {

        MySimpleLinkedList lista = new MySimpleLinkedList();
        MySimpleLinkedList lista2 = new MySimpleLinkedList();

        lista.insertLast2(1);
        lista.insertLast2(20);
        lista.insertLast2(10);
        lista.insertLast2(102);
        lista.insertLast2(102);
        lista.insertLast2(30);
        lista.insertLast2(455);
        lista.insertLast2(786);



        lista2.insertLast2(1);
        lista2.insertLast2(1);
        lista2.insertLast2(20);
        lista2.insertLast2(786);
        lista2.insertLast2(10);
        lista2.insertLast2(107);

        lista2.insertLast2(455);



        //System.out.println("la cantidad de nodos en la lista es de:" + " " +lista.size());
        //lista.extractFront();
        // System.out.println("El valor del elemento en la posicion de la lista que pediste es:"+lista.get(1));
        // System.out.println(lista.size());
        System.out.println(lista.indexOf(10));
        System.out.println(lista);
        System.out.println(lista2);


        MySimpleLinkedList listaElementosComun = new MySimpleLinkedList();

        listaElementosComun= lista.unirListasElementosComun(lista2);

        System.out.println(listaElementosComun);


        // iterable iterator
        MySimpleLinkedList<Integer> lista3 = new MySimpleLinkedList<>();

        lista3.insertLast2(1);
        lista3.insertLast2(20);
        lista3.insertLast2(30);

        while (lista3.hasNext()) {
            System.out.println(lista3.next());
        }

        // construir lista con elementos de lista 1 pero sin los de la lista2 (iguales)

        MySimpleLinkedList<T> listaElementosDistintos = new MySimpleLinkedList<T>();

        //listaElementosDistintos=lista.unirListasConElementosDistintos(lista2);

        System.out.println(listaElementosDistintos);

    }
}