import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() {
            return tam == 0;
        }

        public boolean estaLlena() {
            return tam == datos.length;
        }

        public void encolar(int x) {
            if (estaLlena())
                throw new IllegalStateException(" Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length;
            tam++;
        }

        public int desencolar() {
            if (estaVacia())
                throw new IllegalStateException(" Cola vacia ");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    // (50 pts ) Calcula el balance de parentesis encolando +1 y -1.
    public static int balanceConCola(String s) {

        // Crear cola con capacidad igual a la longitud de la cadena
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

        // Recorrer la cadena y encola +1 por "'('"" y -1 por "')'""
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cola.encolar(1);
            } else if (c == ')') {
                cola.encolar(-1);
            }
        }

        // Desencola y sumar todos los valores 

        int suma = 0;
        while (!cola.estaVacia()) {
            suma = suma + cola.desencolar();
        }

        return suma;
    }

    // (50 pts ) Registra intentos por nombre en un mapa.
    public static int registrarIntento(Map<String, Integer> intentos, String nombre) {
        
        // Verificar si el nombre(llave) ya existe en el mapa

        if (intentos.containsKey(nombre)) {

            // Obtener el valor actual

            int valorActual = intentos.get(nombre);

            // Incrementar en 1

            intentos.put(nombre, valorActual + 1);

            // Retornar el nuevo valor

            return valorActual + 1;

        } else {
            // Si no existe, iniciar en 1
            
            intentos.put(nombre, 1);
            
            // Retornar 1
            
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println(" Balance cola : " + balanceConCola(cadena));
        Map<String, Integer> intentos = new HashMap<String, Integer>();
        System.out.println(" Intentos ( Ana ): " + registrarIntento(intentos, "Ana"));
        System.out.println(" Intentos ( Ana ): " + registrarIntento(intentos, "Ana"));

        sc.close();
    }
}