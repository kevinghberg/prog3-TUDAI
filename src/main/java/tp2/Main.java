package tp2;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5};

        int[] arr2 = {1, 4, 2, 5, 3};

        System.out.println(estaOrdenado(arr2));

        System.out.println(buscarElemento(3,arr1,0,arr1.length-1));

        System.out.println(convertirABinario(26));

        System.out.println(calcularFibonacci(6));

    }

    private static boolean estaOrdenadoRecursivo(int[] arr, int tamanio) {
        if (tamanio >= arr.length-1) {
            return true;
        } else if (arr[tamanio] > arr[tamanio+1]) {
            return false;
        }
        return estaOrdenadoRecursivo(arr,tamanio+1);
    }

     public static boolean estaOrdenado(int[] arr) {
        return estaOrdenadoRecursivo(arr,0);
    }

    public static int buscarElemento(int elem, int[] arr, int inicio, int fin){
        int medio=0;
        if(fin<inicio)
            return -1;
        else
            medio = (inicio+fin)/2;
        if(elem>arr[medio]){
            return buscarElemento(elem,arr,medio+1,fin);
        } else if (elem < medio) {
            return buscarElemento(elem,arr,inicio,medio-1);
        }else
            return medio;
    }

    public static String convertirABinario(int i){
        if(i == 0){
            return "0";
        }if(i == 1){
            return "1";
        }else
            return convertirABinario(i/2)+(i%2);
    }

    private static int calcularFibonacci(int n){
        if(n <= 1){
            return n;
        }
        return calcularFibonacci(n-1) + calcularFibonacci(n-2);
    }
}
