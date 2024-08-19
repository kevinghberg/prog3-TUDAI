package com.prog3.clase1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MySimpleLinkedList lista = new MySimpleLinkedList();
        MySimpleLinkedList lista2 = new MySimpleLinkedList();



        lista.insertLast2(1);
        lista.insertLast2(20);
        lista.insertLast2(10);
        lista.insertLast2(102);
        lista.insertLast2(102);


        lista2.insertLast2(1);
        lista2.insertLast2(1);
        lista2.insertLast2(20);
        lista2.insertLast2(10);
        lista2.insertLast2(107);



        //System.out.println("la cantidad de nodos en la lista es de:" + " " +lista.size());
        //lista.extractFront();
       // System.out.println("El valor del elemento en la posicion de la lista que pediste es:"+lista.get(1));
       // System.out.println(lista.size());
       System.out.println(lista.indexOf(10));

        System.out.println(lista);
        System.out.println(lista2);

        MySimpleLinkedList listaElementosComun = new MySimpleLinkedList();
        listaElementosComun=listaElementosComun.unirListasElementosComun(lista,lista2);

        System.out.println(listaElementosComun);

}
}