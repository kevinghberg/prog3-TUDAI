package tp2;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};

        int[] arr2 = {1, 4, 2, 5, 3};

        int[] arr3 = {-3, -1, 0, 2, 4, 6, 10};

        System.out.println(estaOrdenado(arr2));

        System.out.println(buscarElemento(3, arr1, 0, arr1.length - 1));

        System.out.println(convertirABinario(26));

        System.out.println(calcularFibonacci(6));


        // ordenamiento seleccion
        int[] arr = {64, 25, 12, 22, 11};
        ordenamientoPorSeleccion(arr);
        System.out.println("\n"+"Arreglo ordenado por selección:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        //ordenamiento burbujeo
        int[] arrSe = {64, 34, 25, 12, 22, 11, 90};
        ordenamientoPorBurbuja(arrSe);
        System.out.println("\n"+"Arreglo ordenado por burbuja:");
        for (int num : arrSe) {
            System.out.print(num + " ");
        }


        // mergesort

        int[] arrMS = {12, 11, 13, 5, 6, 7};
        System.out.println("\n"+"Arreglo original:");
        printArray(arrMS);

        mergeSort(arrMS, 0, arrMS.length - 1);

        System.out.println("Arreglo ordenado por Merge Sort:");
        printArray(arrMS);
    }

    private static boolean estaOrdenadoRecursivo(int[] arr, int tamanio) {
        if (tamanio >= arr.length - 1) {
            return true;
        } else if (arr[tamanio] > arr[tamanio + 1]) {
            return false;
        }
        return estaOrdenadoRecursivo(arr, tamanio + 1);
    }

    public static boolean estaOrdenado(int[] arr) {
        return estaOrdenadoRecursivo(arr, 0);
    }

    public static int buscarElemento(int elem, int[] arr, int inicio, int fin) {
        int medio = 0;
        if (fin < inicio)
            return -1;
        else
            medio = (inicio + fin) / 2;
        if (elem > arr[medio]) {
            return buscarElemento(elem, arr, medio + 1, fin);
        } else if (elem < medio) {
            return buscarElemento(elem, arr, inicio, medio - 1);
        } else
            return medio;
    }

    public static String convertirABinario(int i) {
        if (i == 0) {
            return "0";
        }
        if (i == 1) {
            return "1";
        } else
            return convertirABinario(i / 2) + (i % 2);
    }

    private static int calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    private static boolean estaEnPosicion(int[] arr, int i) {
        if (i >= arr.length - 1) {
            return false;
        } else if (i == arr[i]) {
            return true;
        }
        return estaEnPosicion(arr, i + 1);
    }

    // Merge Sort es muy eficiente y tiene una complejidad de  O(nlog n) en todos los casos,
    // lo que lo hace adecuado para ordenar grandes conjuntos de datos.

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Encuentra el punto medio
            int m = (l + r) / 2;

            // Ordena la primera y la segunda mitad recursivamente
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Mezcla las mitades ordenadas
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        // Encuentra los tamaños de los subarreglos para ser mezclados
        int n1 = m - l + 1;
        int n2 = r - m;

        // Arrays temporales para almacenar los subarreglos
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arrays temporales L[] y R[]
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        // Índices iniciales de los primeros y segundos subarreglos
        int i = 0, j = 0;

        // Índice inicial del arreglo mezclado
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L[], si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R[], si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }




    //  Este algoritmo tiene una complejidad de  O(n elevado 2 ) en todos los
    //  porque siempre realiza n(n−1)/2 comparaciones independientemente de la organización inicial de los elementos.
    public static void ordenamientoPorSeleccion(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambiar el mínimo elemento encontrado con el primer elemento
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

        }

    }

    // El algoritmo tiene una complejidad de 𝑂 ( n elevado 2 ) en el caso promedio y peor, pero puede alcanzar  O(n)
    // si se introduce una optimización para detener el algoritmo cuando no se realicen intercambios durante una pasada (esto indica que la lista ya está ordenada).
    public static void ordenamientoPorBurbuja(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambios, la lista ya está ordenada
            if (!swapped) break;
        }
    }
}