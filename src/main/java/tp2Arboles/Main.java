package tp2Arboles;


public class Main {
    public static void main(String[] args) {

        Arbol ar = new Arbol();

        ar.add(7);
        ar.add(5);
        ar.add(9);
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

       System.out.println(ar.getElemAtLevel(2));
    }
}