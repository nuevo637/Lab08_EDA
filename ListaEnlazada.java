public class ListaEnlazada<T> {
    // Nodo interno de la lista
    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void add(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void delete(T dato) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public boolean search(T dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public int size() {
        int tamano = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }
        return tamano;
    }

    public T get(int indice) {
        if (indice < 0 || indice >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.dato;
            }
            contador++;
            actual = actual.siguiente;
        }
        return null;
    }
    
    public void clean() {
        cabeza = null;
    }

    public void printList() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato.toString() + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}