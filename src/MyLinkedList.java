import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private int size = 0;
    Node header = new Node(null, null, null);

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    public void add(T element){
        if(size == 0) {
            header.next = header.prev = header;
        }
        Node<T> newObjNode = new Node(header.prev, element, header);

        newObjNode.prev.next = newObjNode;
        newObjNode.next.prev = newObjNode;
        size++;
    }

    public int size(){
        return size;
    }

    public T get(int index) {
        Node<T> res = header.next;
        if (res == null || index > size() || index < 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < index; i++)
            res = res.next;
        return res.item;
    }

    public void clear(){
        for (Node<T> res = header.next; res != null; ) {
            Node<T> next = res.next;
            res.item = null;
            res.prev = null;
            res.next = null;
            res = next;
        }
        header.next = header.prev = header;
        size = 0;
    }

    public T remove(int index) {
        Node<T> res = header.next;
        if (res == null || index > size() || index < 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < index; i++) {
            res = res.next;
        }

        T element = res.item;
        Node<T> next = res.next;
        Node<T> prev = res.prev;

        if (prev == null) {
            header.next = next;
        } else {
            prev.next = next;
            res.prev = null;
        }

        if (next == null) {
            header.prev = prev;
        } else {
            next.prev = prev;
            res.next = null;
        }
        res.item = null;
        size--;
        return element;
    }
}
