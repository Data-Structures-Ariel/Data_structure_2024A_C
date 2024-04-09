package L07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] objects;
    private int size;

    public MyStack() {
        this.objects = new Object[DEFAULT_CAPACITY];
        size=0;
    }

    public E push(E item) {
        if(size== objects.length)
            init();
        objects[size]=item;
        size++;

        return item;
    }

    private void init() {
        Object[] temp = new Object[size+3];
        for (int i = 0; i < size; i++) {
            temp[i] = objects[i];
        }
        objects=temp;
    }

    public synchronized E pop() {
        E  obj;
        if(size==0)
            throw new EmptyStackException();
        obj = (E)objects[size-1];
        size--;
        return obj;
    }

    public synchronized E peek() {
        E  obj;
        if(size==0)
            throw new EmptyStackException();
        obj = (E)objects[size-1];
        return obj;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public synchronized int search(Object o) {
        if(isEmpty())
            return -1;
        for (int i = size-1; i >=0 ; i--) {
           if(o.equals(objects[i]))
                    return size-i;
        }
        return -1;
    }

    public void print(){
        System.out.println(Arrays.toString(objects));
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(objects[i]+((size-1==i)?"":", "));
        }
        s.append("]");
        return s.toString();
    }
}
