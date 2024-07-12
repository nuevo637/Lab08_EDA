import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la palabra a Codificar:");
        String frase = sc.nextLine();

        // Calcular frecuencias de caracteres en la frase
        Map<Character, Integer> frequencies = calcularFrecuencias(frase);

        // Crear lista enlazada de nodos de Huffman
        LinkedListHuffman list = new LinkedListHuffman();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Ordenar la lista según las frecuencias
        list.sort();

        // Construir el árbol de Huffman
        HuffmanNode root = list.buildHuffmanTree();

        // Asignar códigos de Huffman
        Map<Character, String> huffmanCodes = new HashMap<>();
        list.assignHuffmanCodes(root, "", huffmanCodes);

        // Codificar la frase usando los códigos Huffman
        StringBuilder fraseCodificada = new StringBuilder();
        for (char c : frase.toCharArray()) {
            fraseCodificada.append(huffmanCodes.get(c));
        }

        // Imprimir los códigos de Huffman generados
        System.out.println("\nCódigos Huffman generados:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Imprimir la frase codificada
        System.out.println("\nFrase codificada:");
        System.out.println(fraseCodificada.toString());
    }

    private static Map<Character, Integer> calcularFrecuencias(String frase) {
        Map<Character, Integer> frecuencias = new HashMap<>();

        for (char c : frase.toCharArray()) {
            frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
        }

        return frecuencias;
    }
}