class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left;
    HuffmanNode right;
    
    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    
    HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}