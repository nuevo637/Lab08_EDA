import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class LinkedListHuffman implements List<HuffmanNode> {
  private HuffmanNode first;
  private HuffmanNode last;

  public LinkedListHuffman() {
    this.first = null;
    this.last = null;
  }

  public void add(HuffmanNode node) {
    if (isEmpty()) {
      first = node;
    } else {
      last.setNext(node);
    }
    last = node;
  }

  public HuffmanNode getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("List is empty");
    }
    return first;
  }

  public HuffmanNode getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("List is empty");
    }
    return last;
  }

  public HuffmanNode removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("List is empty");
    }
    HuffmanNode removedNode = first;
    first = first.getNext();
    if (first == null) {
      last = null;
    }
    return removedNode;
  }

  public void addLast(HuffmanNode node) {
    add(node);
  }

  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public Iterator<HuffmanNode> iterator() {
    return new Iterator<HuffmanNode>() {
      private HuffmanNode current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public HuffmanNode next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        HuffmanNode node = current;
        current = current.getNext();
        return node;
      }
    };
  }

  public HuffmanNode getMiddle(HuffmanNode current) {

    if (current == null)
      return current;

    HuffmanNode slow = current, fast = current;

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    return slow;

  }

  public HuffmanNode merge(HuffmanNode left, HuffmanNode right) {
    if (left == null)
      return right;
    if (right == null)
      return left;

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
    if (current == null || current.getNext() == null)
      return current;

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

    if (first == null) {
      last = null;
    } else {
      HuffmanNode current = first;
      while (current.getNext() != null)
        current = current.getNext();
      last = current;
    }
  }

  public HuffmanNode buildHuffmanTree() {
    while (first != null && first.getNext() != null) {
      HuffmanNode left = removeFirst();
      HuffmanNode right = removeFirst();

      HuffmanNode newNode = new HuffmanNode(left.getFrequency() + right.getFrequency());
      newNode.setLeft(left);
      newNode.setRight(right);

      add(newNode);

      sort();
    }
    return first;
  }

  public void assignHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
    if (root == null)
      return;

    if (root.getLeft() == null && root.getRight() == null) {
      huffmanCodes.put(root.getCharacter(), code);
    }

    assignHuffmanCodes(root.getLeft(), code + "0", huffmanCodes);
    assignHuffmanCodes(root.getRight(), code + "1", huffmanCodes);
  }

}
