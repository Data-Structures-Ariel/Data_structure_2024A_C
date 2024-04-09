package L06;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] objects;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.objects = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.objects = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public MyArrayList() {
        this.objects = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean add(E e) {
        if (size >= objects.length)
            init();

        objects[size] = e;
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void init() {
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = objects[i];
        }
        objects = temp;
    }

    // E -> Integer
    //[0, 1, 2, 3, null, null, null, null, null, null]
    //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    @Override
    public boolean remove(Object e) {
        if (isEmpty())
            return false;
        int i;
        for (i = 0; i < size; i++) {
            if (e.equals(objects[i]))
                break;
        }
        //[0, 1, 2, 4, 5, 6, 7, 8, 9, 9]
        if (i < size) {
            for (int j = i; j < size - 1; j++) {
                objects[j] = objects[j + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object e) {
        if (isEmpty())
            return false;

        for (int i = 0; i < size; i++) {
            if (e.equals(objects[i]))
                return true;;
        }

        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }
    // set(6,122)
    // [0, 1, 2, 4, 5, 6, 122, 8, 9, null]
    @Override
    public E set(int index, E element) {
        return null;
    }
    // add(6,122)
    // [0, 1, 2, 4, 5, 6, 122, 7, 8, 9]
    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }
    //indexOf(4 (object))
    // [0, 1, 2, 4, 4, 5, 6, 4, 7, 8, 9]
    // return index -> 3
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    //indexOf(4 (object))
    // [0, 1, 2, 4, 4, 5, 6, 4, 7, 8, 9]
    // return index -> 7
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append('[');
        for (int i = 0; i < objects.length; i++) {
            s.append(objects[i]);
            if (i != objects.length - 1)
                s.append(", ");
        }
        s.append(']');
        return s.toString();
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

}
