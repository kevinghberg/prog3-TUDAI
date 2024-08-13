package com.prog3.clase1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MySimpleLinkedList lista = new MySimpleLinkedList();

        lista.insertFront(20);
        lista.insertFront(10);
        lista.insertFront(1);


        System.out.println("la cantidad de nodos en la lista es de:" + " " +lista.size());
        lista.extractFront();
        System.out.println("El valor del elemento en la posicion de la lista que pediste es:"+lista.get(1));
        System.out.println(lista.size());
}
}