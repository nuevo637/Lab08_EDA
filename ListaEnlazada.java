import java.util.Iterator;

public class ListaEnlazada<T> implements List<T> {
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

    @Override
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

    @Override
    public T getFirst() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }

    @Override
    public T getLast() {
        if (cabeza == null) {
            return null;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public T removeFirst() {
        if (cabeza == null) {
            return null;
        }
        T datoEliminado = cabeza.dato;
        cabeza = cabeza.siguiente;
        return datoEliminado;
    }

    @Override
    public void addLast(T dato) {
        add(dato);
    }

    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
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