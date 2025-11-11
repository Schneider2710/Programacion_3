import java.util.*;

class Seleccion { 
    public static void ordenar(int[] arr) { // Método de ordenamiento
        for (int i = 0; i < arr.length - 1; i++) { // Recorremos hasta el penúltimo elemento
            int min = i; // Asumimos que el mínimo está en la posición i
            for (int j = i + 1; j < arr.length; j++) { // Buscamos el mínimo en el resto
                if (arr[j] < arr[min]) min = j; // Si encontramos uno menor, actualizamos min
            }
            int temp = arr[min]; // Guardamos el mínimo en temporal
            arr[min] = arr[i]; // Movemos el elemento i a la posición del mínimo
            arr[i] = temp; // Colocamos el mínimo en la posición i
        }
    }
    
    public static void main(String[] args) { // Método principal
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // Creamos arreglo de prueba
        System.out.println("Original: " + Arrays.toString(arr)); // Mostramos arreglo original
        ordenar(arr); // Llamamos al método de ordenamiento
        System.out.println("Selección: " + Arrays.toString(arr)); // Mostramos arreglo ordenado
    }
}