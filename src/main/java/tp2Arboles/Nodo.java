package tp2Arboles;

public class Nodo{

    private int key;
    private Nodo left;
    private Nodo right;

    public Nodo(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }

    public Nodo getRight(){
        return this.right;

    }

    public Nodo getLeft(){
        return this.left;
    }

    public void setRight(Nodo arbol){
        this.right=arbol;
    }

    public void setLeft(Nodo arbol){
        this.left=arbol;
    }

    public void setKey(int key){
        this.key=key;
    }
    public int getKey(){
        return this.key;
    }
}