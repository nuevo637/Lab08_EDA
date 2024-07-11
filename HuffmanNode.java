class HuffmanNode {
  int frequency;       // Frecuencia del carácter o suma de frecuencias en el nodo interno
  char character;      // Carácter representado por el nodo (solo para nodos hoja)
  HuffmanNode left;    // Referencia al hijo izquierdo
  HuffmanNode right;   // Referencia al hijo derecho
  
  // Constructor para nodos hoja (caracteres)
  HuffmanNode(char character, int frequency) {
      this.character = character;
      this.frequency = frequency;
  }
  
  // Constructor para nodos internos (suma de frecuencias)
  HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
      this.frequency = frequency;
      this.left = left;
      this.right = right;
  }
  
  // Método para verificar si un nodo es una hoja (no tiene hijos)
  boolean isLeaf() {
      return left == null && right == null;
  }

  //Imprimir
  @Override
    public String toString() {
        if (isLeaf()) {
            return "(" + character + ", " + frequency + ")";
        } else {
            return "(Internal, " + frequency + ")";
        }
    }
}