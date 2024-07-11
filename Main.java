public class Main {
    public static void main(String[] args) {
        ListaEnlazada<HuffmanNode> lista = new ListaEnlazada<>();

        // Crear nodos HuffmanNode
        HuffmanNode nodo1 = new HuffmanNode('a', 5);
        HuffmanNode nodo2 = new HuffmanNode('b', 10);
        HuffmanNode nodo3 = new HuffmanNode('c', 15);

        // Agregar nodos a la lista enlazada
        lista.add(nodo1);
        lista.add(nodo2);
        lista.add(nodo3);

        // Imprimir la lista enlazada
        System.out.println("Lista de nodos Huffman:");
        lista.printList();

        // Ejemplo de búsqueda
        HuffmanNode nodoBuscado = nodo2;
        System.out.println("¿El nodo " + nodoBuscado + " está en la lista? " + lista.search(nodoBuscado));

        // Obtener un nodo por índice
        int indice = 1;
        HuffmanNode nodoObtenido = lista.get(indice);
        if (nodoObtenido != null) {
            System.out.println("Nodo en el índice " + indice + ": " + nodoObtenido);
        } else {
            System.out.println("No hay nodo en el índice " + indice);
        }

        // Limpiar la lista
        lista.clean();
        System.out.println("Lista después de limpiar:");
        lista.printList();
    }
}
