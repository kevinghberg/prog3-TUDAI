package tp2Arboles;

import java.util.*;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void add(int valor) {
        if (this.raiz == null)
            this.raiz = new Nodo(valor);
        else
            add(valor, this.raiz);
    }

    private void add(int valor, Nodo nodo) {
        if (valor < nodo.getKey()) {
            if (nodo.getLeft() == null) {
                Nodo nodoNuevo = new Nodo(valor);
                nodo.setLeft(nodoNuevo);
            } else
                add(valor, nodo.getLeft());
        } else {
            if (nodo.getRight() == null) {
                Nodo nodoNuevo = new Nodo(valor);
                nodo.setRight(nodoNuevo);
            } else
                add(valor, nodo.getRight());
        }
    }

    public Nodo getRoot() {
        return this.raiz;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public boolean hasElem(int valor) {
        if (this.raiz == null) {
            return false;
        } else {
            return hasElem(valor, this.raiz);
        }
    }

    private boolean hasElem(int valor, Nodo nodo) {

        if (valor == nodo.getKey())
            return true;

        if (valor < nodo.getKey() && nodo.getLeft() != null)
            return hasElem(valor, nodo.getLeft());

        if (valor > nodo.getKey() && nodo.getRight() != null)
            return hasElem(valor, nodo.getRight());

        return false;
    }

    public int getHeight() {
        int contador = 0;
        if (isEmpty()) {
            return contador;
        } else {
            contador++;
            return getHeight(contador, raiz);
        }

    }

    private int getHeight(int contador, Nodo nodo) {
        int contadorIzquierda = contador;
        int contadorDerecha = contador;
        if (nodo.getLeft() != null) {
            contadorIzquierda = 1 + getHeight(contadorIzquierda, nodo.getLeft());
        }
        if (nodo.getRight() != null) {
            contadorDerecha = 1 + getHeight(contadorDerecha, nodo.getRight());
        }
        if (contadorIzquierda > contadorDerecha) {
            return contadorIzquierda;
        }
        if (contadorDerecha > contadorIzquierda) {
            return contadorDerecha;
        }
        return contadorIzquierda;
    }

    private void imprimirEnOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        imprimirEnOrden(nodo.getLeft());
        System.out.print(nodo.getKey() + " ");
        imprimirEnOrden(nodo.getRight());
    }

    public void imprimirEnOrden() {
        imprimirEnOrden(this.raiz);
    }

    public void imprimirPreOrder() {
        imprimirPreOrder(this.raiz);
    }

    private void imprimirPreOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getKey() + " ");
        imprimirPreOrder(nodo.getLeft());
        imprimirPreOrder(nodo.getRight());

    }

    public void imprimirPostOrden() {
        imprimirPostOrden(this.raiz);
    }

    private void imprimirPostOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        imprimirPostOrden(nodo.getLeft());
        imprimirPostOrden(nodo.getRight());
        System.out.print(nodo.getKey() + " ");
    }

    public List<Integer> getRamaMasLarga() {
        return getRamaMasLarga(this.raiz);
    }

    private List<Integer> getRamaMasLarga(Nodo nodo) {
        if (nodo == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> izq = getRamaMasLarga(nodo.getLeft());
        List<Integer> der = getRamaMasLarga(nodo.getRight());

        izq.add(0, nodo.getKey());
        der.add(0, nodo.getKey());

        if (izq.size() > der.size()) {
            return izq;
        } else {
            return der;
        }
    }

    private ArrayList<Integer> getFrontera(Nodo nodo, ArrayList<Integer> listaHojas) {
        if (nodo.getLeft() == null && nodo.getRight() == null) {
            listaHojas.add(nodo.getKey());
        }
        if (nodo.getLeft() != null)
            getFrontera(nodo.getLeft(), listaHojas);
        if (nodo.getRight() != null)
            getFrontera(nodo.getRight(), listaHojas);
        return listaHojas;
    }

    public ArrayList<Integer> getFrontera() {
        if (this.raiz != null) {
            ArrayList<Integer> lista = new ArrayList<>();
            return getFrontera(this.raiz, lista);
        }
        return new ArrayList<>();
    }

    public int getMaxElemento() {
        if (this.raiz != null) {
            return getMaxElemento(this.raiz);
        }
        return -1;
    }

    private int getMaxElemento(Nodo nodo) {
        if (nodo.getRight() == null) {
            return nodo.getKey();
        } else {
            return getMaxElemento(nodo.getRight());
        }
    }

    public ArrayList<Integer> getElemAtLevel(int nivel) {
        if (this.raiz != null) {
            ArrayList<Integer> lista = new ArrayList<>();
            getElemAtLevel(this.raiz, lista, nivel, 1);
            return lista;
        }
        return new ArrayList<>();
    }

    private List<Integer> getElemAtLevel(Nodo nodo, List<Integer> lista, int nivel, int contNivel) {
        if (nivel == contNivel) {
            lista.add(nodo.getKey());
        } else {
            if (nodo.getLeft() != null)
                getElemAtLevel(nodo.getLeft(), lista, nivel, contNivel + 1);
            if (nodo.getRight() != null)
                getElemAtLevel(nodo.getRight(), lista, nivel, contNivel + 1);
        }
        return lista;
    }
///

    public boolean delete(int key) {
        if (raiz != null) {
            this.raiz = delete(key, this.raiz);
            return true;
        }
        return false;
    }

    private Nodo delete(int key, Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        //Recorre
        if (key < nodo.getKey()) {
            nodo.setLeft(delete(key, nodo.getLeft()));
        } else if (key > nodo.getKey()) {
            nodo.setRight(delete(key, nodo.getRight()));
        } else {
            ///nodo sin hijos
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                return null;
            }

            /// nodo con un solo hijo
            else if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            //Nodo con dos hijos
            else {
                nodo.setKey(getMinElem(nodo.getRight()));
                nodo.setRight(delete(nodo.getKey(), nodo.getRight()));
            }
        }
        return nodo;
    }

    private int getMinElem(Nodo nodo) {
        if (nodo.getLeft() == null)
            return nodo.getKey();
        return getMinElem(nodo.getLeft());
    }


    public int sumarNodos() {
        return sumarNodos(this.raiz);
    }

    private int sumarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if ((nodo.getLeft() == null && nodo.getRight() == null)) {
            return 0;
        }
        return nodo.getKey() + sumarNodos(nodo.getLeft()) + sumarNodos(nodo.getRight());
    }

    public ArrayList<Integer> hojasMayores(int valor) {
        if (this.raiz != null) {
            ArrayList<Integer> hojas = new ArrayList<>();
            hojasMayores(this.raiz, valor, hojas);
            return hojas;
        }
        return new ArrayList<>();
    }

    private ArrayList<Integer> hojasMayores(Nodo nodo, int valor, ArrayList<Integer> lista) {
        if (nodo.getLeft() == null && nodo.getRight() == null && nodo.getKey() > valor) {
            lista.add(nodo.getKey());//si valor menor a la hoja , aniado a lista
        } else {
            if (nodo.getLeft() != null) { //recorro por izquierdaa
                hojasMayores(nodo.getLeft(), valor, lista);
            }
            if (nodo.getRight() != null) { //recorro pro derecha
                hojasMayores(nodo.getRight(), valor, lista);
            }
        }
        return lista;
    }


    public int llenarNodosInternos(){
       return  llenarNodosInternos(this.raiz);
    }

    private int llenarNodosInternos(Nodo nodo) {
        if (nodo == null) { // nodo nulo = 0
            return 0;
        }
        if (nodo.getLeft() == null && nodo.getRight() == null) {
            return nodo.getKey();                                    // si es hoja retorno el valor para usarlo
        }
        // recursividad para valores lado izq y valores lado der
        int valorIzq = llenarNodosInternos(nodo.getLeft());
        System.out.println(valorIzq);
        int valorDer = llenarNodosInternos(nodo.getRight());
        System.out.println(valorDer);

        nodo.setKey(valorDer-valorIzq); // key hijo derecho menos key hijo izquierdo al nodo actual

        return nodo.getKey();

    }


    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
}
