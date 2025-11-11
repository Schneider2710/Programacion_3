import java.util.*;

class Burbuja { 
    public static void ordenar(int[] arr) { 
        int n = arr.length; // Guardamos el tamaño del arreglo
        for (int i = 0; i < n - 1; i++) { // Ciclo externo: número de pasadas
            for (int j = 0; j < n - i - 1; j++) { // Ciclo interno: comparaciones en cada pasada
                if (arr[j] > arr[j + 1]) { // Si el elemento actual es mayor que el siguiente
                    int temp = arr[j]; // Guardamos el elemento actual en temporal
                    arr[j] = arr[j + 1]; // Movemos el siguiente elemento a la posición actual
                    arr[j + 1] = temp; // Ponemos el temporal en la siguiente posición
                }
            }
        }
    }
    
    public static void main(String[] args) { // Método principal
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // Creamos arreglo de prueba
        System.out.println("Original: " + Arrays.toString(arr)); // Mostramos arreglo original
        ordenar(arr); // Llamamos al método de ordenamiento
        System.out.println("Burbuja: " + Arrays.toString(arr)); // Mostramos arreglo ordenado
    }
}