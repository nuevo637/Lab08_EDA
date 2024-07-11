public class LinkedListHuffman implements List<HuffmanNode>{

  private HuffmanNode first;
  private HuffmanNode last;

  public HuffmanNode getMiddle(HuffmanNode current) {

    if(current == null) return current;

    HuffmanNode slow = current, fast = current;

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    return slow;

  }

  public HuffmanNode merge(HuffmanNode left, HuffmanNode right) {
    if(left == null) return right;
    if(right == null) return left;

    HuffmanNode result;
    if (left.compareTo(right) <= 0) {
      result = left;
      result.setNext(merge(left.getNext(), right));
    } else {
      result = right;
      result.setNext(merge(left, right.getNext()));
    }
    return result;
  }

  public HuffmanNode mergeSort(HuffmanNode current) {
    if(current == null || current.getNext() == null) return current;

    HuffmanNode middle = getMiddle(current);
    HuffmanNode nextMiddle = middle.getNext();
    middle.setNext(null);

    HuffmanNode left = mergeSort(current);
    HuffmanNode right = mergeSort(nextMiddle);

    HuffmanNode sorted = merge(left, right);

    return sorted;
  }

  public void sort() {

    first = mergeSort(first);

    if(first == null){
      last = null;
    }else{
      HuffmanNode current = first;
      while(current.getNext() != null)
        current = current.getNext();
      last = current;
    }
  }
  
}
