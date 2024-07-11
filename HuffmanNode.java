public class HuffmanNode implements Comparable<HuffmanNode>{

  private int frequency;
  private char character;
  private HuffmanNode next;
  // HuffmanNode left;
  // HuffmanNode right;

  public HuffmanNode(char character){
    this.character = character;
    this.frequency = 1;
  }

  public char getChar() {
    return this.character;
  }

  public int getFrequency() {
    return this.frequency;
  }

  public HuffmanNode getNext() {
    return this.next;
  }

  public void setChar(char character) {
    this.character = character;
  }

  public void setFrequency(int frequency) {
    this.frequency = frequency;
  }

  public void setNext(HuffmanNode next) {
    this.next = next;
  }

  public void addOneFreq() {
    this.frequency++;
  }

  @Override
  public int compareTo(HuffmanNode o) {
    if(this.getFrequency() > o.getFrequency()) return 1;
    if(this.getFrequency() < o.getFrequency()) return -1;
    return 0;
  }
}
