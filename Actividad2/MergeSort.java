import java.util.*;

class MergeSort { // Clase para ordenamiento por mezcla
    public static void ordenar(int[] arr, int izq, int der) { // Método recursivo principal
        if (izq < der) { // Si hay más de un elemento
            int medio = (izq + der) / 2; // Calculamos el punto medio
            ordenar(arr, izq, medio); // Ordenamos la mitad izquierda
            ordenar(arr, medio + 1, der); // Ordenamos la mitad derecha
            merge(arr, izq, medio, der); // Mezclamos las dos mitades ordenadas
        }
    }

    private static void merge(int[] arr, int izq, int medio, int der) { // Método que mezcla dos subarreglos
        int n1 = medio - izq + 1; // Tamaño del subarreglo izquierdo
        int n2 = der - medio; // Tamaño del subarreglo derecho
        int[] L = new int[n1]; // Creamos arreglo temporal izquierdo
        int[] R = new int[n2]; // Creamos arreglo temporal derecho

        for (int i = 0; i < n1; i++)
            L[i] = arr[izq + i]; // Copiamos datos al arreglo izquierdo
        for (int j = 0; j < n2; j++)
            R[j] = arr[medio + 1 + j]; // Copiamos datos al arreglo derecho

        int i = 0, j = 0, k = izq; // Inicializamos índices: i para L, j para R, k para arr
        while (i < n1 && j < n2) { // Mientras ambos arreglos tengan elementos
            if (L[i] <= R[j]) { // Si el elemento de L es menor o igual
                arr[k++] = L[i++]; // Copiamos de L a arr y avanzamos ambos índices
            } else { // Si el elemento de R es menor
                arr[k++] = R[j++]; // Copiamos de R a arr y avanzamos ambos índices
            }
        }
        while (i < n1)
            arr[k++] = L[i++]; // Copiamos elementos restantes de L
        while (j < n2)
            arr[k++] = R[j++]; // Copiamos elementos restantes de R
    }

    public static void main(String[] args) { // Método principal
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 }; // Creamos arreglo de prueba
        System.out.println("Original: " + Arrays.toString(arr)); // Mostramos arreglo original
        ordenar(arr, 0, arr.length - 1); // Ordenamos todo el arreglo
        System.out.println("MergeSort: " + Arrays.toString(arr)); // Mostramos arreglo ordenado
    }
}