
public interface List<E> extends Iterable<E>{
  void add(E e);
  E getFirst();
  E getLast();
  E removeFirst();
  void addLast(E e);
  boolean isEmpty();

}
