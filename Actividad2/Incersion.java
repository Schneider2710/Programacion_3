import java.util.*;
class Insercion { // Clase para ordenamiento por inserción
    public static void ordenar(int[] arr) { // Método de ordenamiento
        for (int i = 1; i < arr.length; i++) { // Empezamos desde el segundo elemento
            int clave = arr[i]; // Guardamos el elemento a insertar
            int j = i - 1; // j apunta al último elemento de la parte ordenada
            while (j >= 0 && arr[j] > clave) { // Mientras haya elementos mayores que la clave
                arr[j + 1] = arr[j]; // Movemos el elemento una posición a la derecha
                j--; // Retrocedemos una posición
            }
            arr[j + 1] = clave; // Insertamos la clave en su posición correcta
        }
    }
    
    public static void main(String[] args) { // Método principal
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // Creamos arreglo de prueba
        System.out.println("Original: " + Arrays.toString(arr)); // Mostramos arreglo original
        ordenar(arr); // Llamamos al método de ordenamiento
        System.out.println("Inserción: " + Arrays.toString(arr)); // Mostramos arreglo ordenado
    }
}