import java.util.*;
class QuickSort { // Clase para ordenamiento rápido
    public static void ordenar(int[] arr, int bajo, int alto) { // Método recursivo de ordenamiento
        if (bajo < alto) { // Si hay más de un elemento para ordenar
            int pi = particion(arr, bajo, alto); // Particionamos y obtenemos posición del pivote
            ordenar(arr, bajo, pi - 1); // Ordenamos recursivamente la parte izquierda
            ordenar(arr, pi + 1, alto); // Ordenamos recursivamente la parte derecha
        }
    }
    
    private static int particion(int[] arr, int bajo, int alto) { // Método que reorganiza el arreglo
        int pivote = arr[alto]; // Tomamos el último elemento como pivote
        int i = bajo - 1; // Índice del elemento más pequeño
        for (int j = bajo; j < alto; j++) { // Recorremos desde bajo hasta antes del pivote
            if (arr[j] < pivote) { // Si el elemento es menor que el pivote
                i++; // Incrementamos índice de elemento pequeño
                int temp = arr[i]; // Guardamos arr[i] en temporal
                arr[i] = arr[j]; // Movemos elemento menor a la izquierda
                arr[j] = temp; // Completamos el intercambio
            }
        }
        int temp = arr[i + 1]; // Guardamos el elemento siguiente al último menor
        arr[i + 1] = arr[alto]; // Colocamos el pivote en su posición correcta
        arr[alto] = temp; // Completamos el intercambio
        return i + 1; // Retornamos la posición del pivote
    }
    
    public static void main(String[] args) { // Método principal
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // Creamos arreglo de prueba
        System.out.println("Original: " + Arrays.toString(arr)); // Mostramos arreglo original
        ordenar(arr, 0, arr.length - 1); // Ordenamos desde el inicio hasta el final
        System.out.println("QuickSort: " + Arrays.toString(arr)); // Mostramos arreglo ordenado
    }
}