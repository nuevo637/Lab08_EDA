import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put(' ', 5);
        frequencies.put('a', 9);
        frequencies.put('c', 2);
        frequencies.put('e', 1);
        frequencies.put('j', 1);
        frequencies.put('l', 2);
        frequencies.put('s', 1);
        frequencies.put('t', 2);

        // Crear lista enlazada de nodos de Huffman
        LinkedListHuffman list = new LinkedListHuffman();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Ordenar la lista
        list.sort();

        // Construir el árbol de Huffman
        HuffmanNode root = list.buildHuffmanTree();

        // Asignar códigos de Huffman
        Map<Character, String> huffmanCodes = new HashMap<>();
        list.assignHuffmanCodes(root, "", huffmanCodes);

        // Imprimir los códigos de Huffman
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
