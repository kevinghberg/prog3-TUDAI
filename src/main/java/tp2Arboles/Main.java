package tp2Arboles;


import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Arbol ar = new Arbol();

        ar.add(9);
        ar.add(7);
        ar.add(5);
        ar.add(4);
        ar.add(6);
        ar.add(11);
        ar.add(15);


       // System.out.println(ar.getHeight());

       // ar.imprimirEnOrden();
       //ar.imprimirPreOrder();
       // ar.imprimirPostOrden();

        //System.out.println(ar.getRamaMasLarga());
        // System.out.println(ar.getFrontera());
        //System.out.println(ar.getElemAtLevel(2));

       // ar.imprimirPreOrder();

       // System.out.println('=');
       // ar.delete(5);
       // ar.imprimirPreOrder();
        //ar.imprimirEnOrden();

        //System.out.println(ar.sumarNodos());

        //System.out.println(ar.hojasMayores(7));

        Arbol ar2= new Arbol();



        Nodo raiz = new Nodo(0);
        ar2.setRaiz(raiz);
        raiz.setLeft(new Nodo(0));
        raiz.setRight(new Nodo(0));
        raiz.getLeft().setLeft(new Nodo(3));
        raiz.getRight().setLeft(new Nodo(5));
        raiz.getRight().setRight(new Nodo(2));
      //  ar2.imprimirEnOrden();

        //ar2.llenarNodosInternos();

       // ar2.imprimirEnOrden();





        Arbol ar3 = new Arbol();

        Nodo letra= new Nodo('M');

        letra.setLeft(new Nodo('A'));
        letra.setRight(new Nodo('I'));

        letra.getLeft().setLeft(new Nodo('L'));
        letra.getLeft().setRight(new Nodo('N'));

        letra.getLeft().getRight().setLeft(new Nodo('A'));
        letra.getLeft().getRight().setRight(new Nodo('O'));

        letra.getRight().setLeft(new Nodo('S'));
        letra.getRight().setRight(new Nodo('O'));

        letra.getRight().getLeft().setRight(new Nodo('A'));

        ar3.setRaiz(letra);

        for(String palabra : ar3.buscarPalabras(2)){
            System.out.println(palabra);
        }
}}