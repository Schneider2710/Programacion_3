import java.util.Vector;
import java.util.Collections;

public class EjemploVector {
    public static void main(String[] args) {
        // 1. Crear un Vector de Strings
        Vector<String> vector = new Vector<>();

        // 2. Agregar elementos
        vector.add("Elemento 1");
        vector.add("Elemento 2");
        vector.addElement("Elemento 3"); // método antiguo, pero válido
        vector.add(1, "Elemento 1.5"); // insertar en posición específica

        System.out.println("Vector inicial: " + vector);

        // 3. Acceder a elementos
        System.out.println("Primer elemento: " + vector.firstElement());
        System.out.println("Último elemento: " + vector.lastElement());
        System.out.println("Elemento en índice 1: " + vector.get(1));

        // 4. Modificar elementos
        vector.set(1, "Elemento modificado");
        System.out.println("Después de modificar índice 1: " + vector);

        // 5. Eliminar elementos
        vector.remove("Elemento 2"); // eliminar por objeto
        vector.remove(0); // eliminar por índice
        vector.removeElement("Elemento 3");// otra forma de eliminar
        System.out.println("Después de eliminaciones: " + vector);

        // 6. Verificar contenido
        System.out.println("¿Contiene 'Elemento 1.5'? " + vector.contains("Elemento 1.5"));
        System.out.println("Tamaño actual: " + vector.size());
        System.out.println("Capacidad actual: " + vector.capacity());

        // 7. Recorrer el Vector
        System.out.print("Recorrido con forEach: ");
        vector.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 8. Sublista
        vector.add("A");
        vector.add("B");
        vector.add("C");
        System.out.println("Vector ampliado: " + vector);
        System.out.println("Sublista (0,2): " + vector.subList(0, 2));

        // 9. Ordenar
        Collections.sort(vector);
        System.out.println("Vector ordenado: " + vector);

        // 10. Vaciar
        vector.clear();
        System.out.println("Vector después de clear(): " + vector);
        System.out.println("¿Está vacío? " + vector.isEmpty());
    }
}