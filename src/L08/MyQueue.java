package L08;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] objects;
    private int size;
    private int indexToInsert;
    private int indexToRemove;

    public MyQueue() {
        this.objects =new Object[DEFAULT_CAPACITY];
        this.size=0;
        this.indexToInsert=this.indexToRemove=0;
    }

    public MyQueue(int capacity) {
        if(capacity<=0)
            throw new IllegalArgumentException();
        this.objects =new Object[capacity];
        this.size=0;
        this.indexToInsert=this.indexToRemove=0;
    }

    // insert()
    public boolean add(E e){
        if(size==objects.length)
            return false;
        //[1,2,3]
        objects[indexToInsert]=e;
        // size=5
        // 0=[0,5,10,15,20] ,[1,6,11,16,21] , [2] , [] ,[]
        indexToInsert =(indexToInsert+1)%objects.length ;
        size++;
        // indexToInsert =(indexToInsert==objects.length)?0:indexToInsert+1 ;
       return true;
        //[null,null,null]
        // insert=0
        //add(1)
        //[1,null,null]
        // insert=1
        //add(2)
        //[1,2,null]
        // insert=2
        //add(3)
        //[1,2,3]
        // insert=0

    }

    public E remove(){
        if(size==0)
            throw new NoSuchElementException();
       E item = (E)objects[indexToRemove];
        objects[indexToRemove]=null;
        indexToRemove =(indexToRemove+1)%objects.length ;
        size--;
        return item;

        //[null,null,null]
        // insert=0
        // remove=0
        //add(1)
        //[1,null,null]
        // insert=1
        // remove=0
        //add(2)
        //[1,2,null]
        // insert=2
        // remove=0
        //add(3)
        //[1,2,3]
        // insert=0
        // remove=0

        //remove()
        //[null,2,3]
        // insert=0
        // remove=1

        //remove()
        //[null,null,3]
        // insert=0
        // remove=2

        //remove()
        //[null,null,null]
        // insert=0
        // remove=0

        //add(7)
        //[7,null,null]
        // insert=1
        // remove=0

        //add(70)
        //[7,70,null]
        // insert=2
        // remove=0

        //remove()
        //[null,70,null]
        // insert=2
        // remove=1

        //remove()
        //[null,null,null]
        // insert=2
        // remove=2

    }
    // top()
    public E peek() {
        if (size == 0)
            throw new NoSuchElementException();
        E item = (E) objects[indexToRemove];
        return item;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {

        //[-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10]
        // remove() x4
        //[null,null,null,null,1,2,3,4,5,6,7,8,9,10]
        // add(11,12,13,14)
        //[11,12,13,14,1,2,3,4,5,6,7,8,9,10]
        //             |
        //[1,2,3,4,5,6,7,8,9,10,11,12,13,14]
        StringBuilder s = new StringBuilder();
        s.append("[");
        int sizeValues = this.size;
        for (int i = indexToRemove;sizeValues!=0; i=(i+1)%objects.length,sizeValues--) {
            s.append(objects[i]+((sizeValues==1)?"":", "));
        }
        s.append("]");
//        System.out.println("------ object ------");
//        System.out.println(Arrays.toString(objects));
//        System.out.println("---------------------");
        return s.toString();
    }
}

//[11,12,13,14,1,2,3,4,5,6,7,8,9,10]
//             |
//      (insert,remove)
// add(15)

//[11,12,13,14,null,null,1,2,3,4,5,6,7,8,9,10]
//             |         |
//      (insert)       (remove)
//[11,12,13,14,1,2,3,4,5,6,7,8,9,10]
//             |
//      (insert,remove)
// add(15)


//[11,12,13,14,1,2,3,4,5,6,7,8,9,10]
//             |
//      (insert,remove)
// add(15)
//[11,12,13,14,1,2,3,4,5,6,7,8,9,10,null,null]
//[11,12,13,14,1,2,3,4,5,6,7,8,9,10,null,null]
//[11,12,13,14,1,2,3,4,5,6,7,8,9,10,null,10]
//[11,12,13,14,1,2,3,4,5,6,7,8,9,10,9,10]
//[11,12,13,14,1,2,3,4,5,6,7,8,9,8,9,10]
//[11,12,13,14,1,2,3,4,5,6,7,8,7,8,9,10]
//[11,12,13,14,1,2,3,4,5,6,7,6,7,8,9,10]
//[11,12,13,14,1,2,3,4,5,6,5,6,7,8,9,10]
//[11,12,13,14,1,2,3,4,5,4,5,6,7,8,9,10]
//[11,12,13,14,1,2,3,4,3,4,5,6,7,8,9,10]
//[11,12,13,14,1,2,3,2,3,4,5,6,7,8,9,10]
//[11,12,13,14,15,2,1,2,3,4,5,6,7,8,9,10]
// add(16)
//[11,12,13,14,15,16,1,2,3,4,5,6,7,8,9,10]