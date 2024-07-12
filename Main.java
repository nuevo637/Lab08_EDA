import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a phrase to codify:");
        Map<Character, Integer> frequencies =  calcularFrecuencias(sc.nextLine());

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

    private static Map<Character, Integer> calcularFrecuencias(String frase) {
    Map<Character, Integer> frecuencias = new HashMap<>();

    for (char c : frase.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            c = Character.toLowerCase(c);
            frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
        }
    }

    return frecuencias;
  }

}
