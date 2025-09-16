
import java.util.Stack;

public class Clase7 {
    public static void main(String[] args) {
    
        //Creacion de una pila de numeros enteros
        Stack<Integer> pila = new Stack<>();
    
        //Insertar elementos de la pila
        pila.push(8);
        pila.push(4);
        pila.push(9);
        pila.push(10);
        pila.push(6);


    
        //Mostrat el elemento que esta en el tope de la pila son remover
        System.out.println("Tope de la pila: " + pila.peek());

        //Remover el elemento que se encuentra en el tope de la pila
        System.out.println("El elemento removido del tope de la pila: " + pila.pop());

        //Imprimir la pila
        System.out.println(pila);

        //Buscar y mostrar la posicion del elemento dentro de la pila
        System.out.println(pila.search(10));
        System.out.println(pila.search(9));
        System.out.println(pila.search(4));
        System.out.println(pila.search(8));
        System.out.println(pila.search(50));



    }
}
