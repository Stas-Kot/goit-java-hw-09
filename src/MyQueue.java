import java.util.StringJoiner;

public class MyQueue<T> {
    private static final int INIT_SIZE = 10;

    private Object[] data;
    private int index;

    public MyQueue() {
        data = new Object[INIT_SIZE];
    }

    public void add(T item) {
        if (index == data.length) {
            resize();
        }
        data[index] = item;
        index++;
    }

    public int size() {
        return index;
    }

    private void resize() {
        Object[] newData = new Object[index * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void remove(int i) {
        if(i > size() || i < 0) {
            System.out.println("Incorrect index! Please enter a correct index");
        } else {
            Object temp = data[i];
            data[i] = null;
            Object[] newData = new Object[data.length];
            System.arraycopy(data, i + 1, data, i, index - i - 1);
            data[index - 1] = null;
            index--;
        }
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
            index = 0;
        }
    }

    public T peek(){
        if(size() > 0 ) {
           return (T) data[0];
        }
        return null;
    }

    public T poll(){
        if(size() > 0 ) {
            T temp = (T) data[0];
            remove(0);
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }
        return result.toString();
    }
}