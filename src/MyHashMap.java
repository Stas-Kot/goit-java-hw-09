import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int INIT_SIZE = 10;

    Node<K, V>[] data;
    int size = 0;

    public <K, V> MyHashMap() {
        this.data = new Node[INIT_SIZE];
    }

    public MyHashMap(int initialCapacity) {
        this.data = new Node[initialCapacity];
    }

    public void put(K key, V value) {
        Node<K, V> newElement = new Node(key, value);
        Node<K, V> temp = data[counterInHashArray(newElement.hashCode())];
        if (temp == null) {
            data[counterInHashArray(newElement.hashCode())] = newElement;
            size++;
        } else {
            if (temp.equals(newElement)) {
                newElement.next = temp.next;
                data[counterInHashArray(newElement.hashCode())] = newElement;
            } else {
                while (temp.next != null) {
                    if (temp.next.equals(newElement)) {
                        temp.next.setValue(newElement.value);
                        size--;
                    }
                    temp = temp.next;
                }
                temp.next = newElement;
                size++;
            }
        }
    }

    public int counterInHashArray(int hash) {
        int counterInHashArray = hash % data.length;
        return counterInHashArray;
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        Node<K, V> newElement = new Node(key, null);
        Node<K, V> temp = data[counterInHashArray(newElement.hashCode())];
        V res = null;
        if (temp != null) {
            if (temp.equals(newElement)) {
                res = temp.getValue();
            } else {
                while (temp.next != null) {
                    if (temp.next.equals(newElement)) {
                        res = temp.next.getValue();
                    }
                    temp = temp.next;
                }
                if (temp.equals(newElement)) {
                    res = temp.getValue();
                }
            }
        }
        return res;
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public void remove(Object key) {
        Node<K, V> newElement = new Node(key, null);
        Node<K, V> temp = data[counterInHashArray(newElement.hashCode())];
        if (temp == null) {
            System.out.println("Element with key " + key + " does not exist");
        } else {
            if (temp.next == null) {
                if (temp.equals(newElement)) {
                    temp.next = null;
                    data[counterInHashArray(newElement.hashCode())] = null;
                    size--;
                } else {
                    System.out.println("Element with key " + key + " does not exist");
                }
            } else {
                if (temp.equals(newElement)) {
                    data[counterInHashArray(newElement.hashCode())] = temp.next;
                    size--;

                }
                while (temp.next != null) {
                    if (temp.next.equals(newElement)) {
                        temp.next = temp.next.next;
                        size--;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> other = (Node<?, ?>) o;
            return key.equals(other.getKey());
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return Math.abs(Objects.hash(getKey()));
        }
    }
}
//    remove(Object key) удаляет пару по ключу
//    clear() очищает коллекцию