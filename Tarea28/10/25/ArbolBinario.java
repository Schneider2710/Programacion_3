import java.util.*;

class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }
    
    // RECORRIDO PREORDEN usando PILA
    public ArrayList<Integer> preorden() {
        ArrayList<Integer> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Stack<Nodo> pila = new Stack<>();
        pila.push(raiz);
        
        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();
            resultado.add(nodo.valor);
            
            // Primero derecho, luego izquierdo (porque la pila invierte el orden)
            if (nodo.derecho != null) pila.push(nodo.derecho);
            if (nodo.izquierdo != null) pila.push(nodo.izquierdo);
        }
        
        return resultado;
    }
    
    // RECORRIDO INORDEN usando PILA
    public ArrayList<Integer> inorden() {
        ArrayList<Integer> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Stack<Nodo> pila = new Stack<>();
        Nodo actual = raiz;
        
        while (actual != null || !pila.isEmpty()) {
            // Ir hasta el nodo más a la izquierda
            while (actual != null) {
                pila.push(actual);
                actual = actual.izquierdo;
            }
            
            // Procesar el nodo
            actual = pila.pop();
            resultado.add(actual.valor);
            
            // Ir al subárbol derecho
            actual = actual.derecho;
        }
        
        return resultado;
    }
    
    // RECORRIDO POSTORDEN usando PILA
    public ArrayList<Integer> postorden() {
        ArrayList<Integer> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Stack<Nodo> pila1 = new Stack<>();
        Stack<Nodo> pila2 = new Stack<>();
        
        pila1.push(raiz);
        
        while (!pila1.isEmpty()) {
            Nodo nodo = pila1.pop();
            pila2.push(nodo);
            
            if (nodo.izquierdo != null) pila1.push(nodo.izquierdo);
            if (nodo.derecho != null) pila1.push(nodo.derecho);
        }
        
        while (!pila2.isEmpty()) {
            resultado.add(pila2.pop().valor);
        }
        
        return resultado;
    }
    
    // RECORRIDO POR NIVELES usando COLA
    public ArrayList<Integer> porNiveles() {
        ArrayList<Integer> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            resultado.add(nodo.valor);
            
            if (nodo.izquierdo != null) cola.add(nodo.izquierdo);
            if (nodo.derecho != null) cola.add(nodo.derecho);
        }
        
        return resultado;
    }
    
    // PROFUNDIDAD DEL ÁRBOL usando COLA
    public int profundidad() {
        if (raiz == null) return 0;
        
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 0;
        
        while (!cola.isEmpty()) {
            int tamanioNivel = cola.size();
            
            for (int i = 0; i < tamanioNivel; i++) {
                Nodo nodo = cola.poll();
                
                if (nodo.izquierdo != null) cola.add(nodo.izquierdo);
                if (nodo.derecho != null) cola.add(nodo.derecho);
            }
            
            nivel++;
        }
        
        return nivel;
    }
    
    // PROFUNDIDAD DE CADA NODO usando COLA
    public ArrayList<String> profundidadPorNodo() {
        ArrayList<String> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Queue<Nodo> cola = new LinkedList<>();
        Queue<Integer> niveles = new LinkedList<>();
        
        cola.add(raiz);
        niveles.add(0);
        
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            int nivel = niveles.poll();
            
            resultado.add("Nodo " + nodo.valor + " -> Profundidad " + nivel);
            
            if (nodo.izquierdo != null) {
                cola.add(nodo.izquierdo);
                niveles.add(nivel + 1);
            }
            if (nodo.derecho != null) {
                cola.add(nodo.derecho);
                niveles.add(nivel + 1);
            }
        }
        
        return resultado;
    }
    
    // VERIFICAR SI ESTÁ BALANCEADO usando COLA
    public boolean estaBalanceado() {
        if (raiz == null) return true;
        
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            
            int alturaIzq = calcularAltura(nodo.izquierdo);
            int alturaDer = calcularAltura(nodo.derecho);
            
            if (Math.abs(alturaIzq - alturaDer) > 1) {
                return false;
            }
            
            if (nodo.izquierdo != null) cola.add(nodo.izquierdo);
            if (nodo.derecho != null) cola.add(nodo.derecho);
        }
        
        return true;
    }
    
    private int calcularAltura(Nodo nodo) {
        if (nodo == null) return 0;
        
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(nodo);
        int altura = 0;
        
        while (!cola.isEmpty()) {
            int tamanio = cola.size();
            for (int i = 0; i < tamanio; i++) {
                Nodo n = cola.poll();
                if (n.izquierdo != null) cola.add(n.izquierdo);
                if (n.derecho != null) cola.add(n.derecho);
            }
            altura++;
        }
        
        return altura;
    }
    
    // FACTORES DE BALANCE usando ARRAYLIST
    public ArrayList<String> factoresBalance() {
        ArrayList<String> resultado = new ArrayList<>();
        if (raiz == null) return resultado;
        
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            
            int alturaIzq = calcularAltura(nodo.izquierdo);
            int alturaDer = calcularAltura(nodo.derecho);
            int fb = alturaIzq - alturaDer;
            
            resultado.add("Nodo " + nodo.valor + " -> FB: " + fb + 
                         " (Izq: " + alturaIzq + ", Der: " + alturaDer + ")");
            
            if (nodo.izquierdo != null) cola.add(nodo.izquierdo);
            if (nodo.derecho != null) cola.add(nodo.derecho);
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 65};
        
        for (int valor : valores) {
            arbol.insertar(valor);
        }
        
        System.out.println("==================================================");
        System.out.println("ÁRBOL BINARIO - MÉTODOS ITERATIVOS");
        System.out.println("==================================================");
        
        System.out.println("\nPROFUNDIDAD DEL ÁRBOL: " + arbol.profundidad());
        
        System.out.println("\nESTÁ BALANCEADO: " + (arbol.estaBalanceado() ? "SÍ" : "NO"));
        
        System.out.println("\nRECORRIDOS:");
        System.out.println("   PreOrden:    " + arbol.preorden());
        System.out.println("   InOrden:     " + arbol.inorden());
        System.out.println("   PostOrden:   " + arbol.postorden());
        System.out.println("   Por Niveles: " + arbol.porNiveles());
        
        System.out.println("\nPROFUNDIDAD POR NODO:");
        ArrayList<String> profundidades = arbol.profundidadPorNodo();
        for (String p : profundidades) {
            System.out.println("   " + p);
        }
        
        System.out.println("\nFACTORES DE BALANCE:");
        ArrayList<String> factores = arbol.factoresBalance();
        for (String f : factores) {
            System.out.println("   " + f);
        }
        
        System.out.println("\n==================================================");
    }
}