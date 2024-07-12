class HuffmanNode implements Comparable<HuffmanNode> {
  private char character;
  private int frequency;
  private HuffmanNode left, right, next;

  public HuffmanNode(char character, int frequency) {
      this.character = character;
      this.frequency = frequency;
      this.left = null;
      this.right = null;
      this.next = null;
  }

  public HuffmanNode(int frequency) {
      this.frequency = frequency;
      this.left = null;
      this.right = null;
      this.next = null;
  }

  public char getCharacter() {
      return character;
  }

  public int getFrequency() {
      return frequency;
  }

  public HuffmanNode getLeft() {
      return left;
  }

  public void setLeft(HuffmanNode left) {
      this.left = left;
  }

  public HuffmanNode getRight() {
      return right;
  }

  public void setRight(HuffmanNode right) {
      this.right = right;
  }

  public HuffmanNode getNext() {
      return next;
  }

  public void setNext(HuffmanNode next) {
      this.next = next;
  }

  @Override
  public int compareTo(HuffmanNode o) {
      return Integer.compare(this.frequency, o.frequency);
  }
}
