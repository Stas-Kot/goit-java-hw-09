import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 10;

    private Object[] data;
    private int index;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    public void add(T item) {
        if (index == data.length) {
            resize();
        }
        data[index] = item;
        index++;
    }

    private void resize() {
        Object[] newData = new Object[index * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public int size() {
        return index;
    }

    public T get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index is not correct, please insert correct index");
        }
        if (index == 0) {
            throw new IndexOutOfBoundsException("List is Empty");
        }

        return (T) data[i];
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
            index = 0;
        }
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
            System.out.println(temp + " successful deleted");
        }
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


