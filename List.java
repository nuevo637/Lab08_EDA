public interface List<T> extends Iterable<T>{
    void add(T e);
    T getFirst();
    T getLast();
    T removeFirst();
    void addLast(T e);
    boolean isEmpty();
}