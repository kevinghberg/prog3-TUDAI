package tp2Arboles;

public class Nodo{

    private int key;
    private Nodo left;
    private Nodo right;
    private char letra;


    public Nodo(int key){
        this.key=key;
        this.left=null;
        this.right=null;
        this.letra=letra;
    }

    public Nodo(char letra){
        this.key=this.getKey();
        this.left=null;
        this.right=null;
        this.letra=letra;
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


    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}