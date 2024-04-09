package L08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    static Random rd = new Random();

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>() {{
            int size = rd.nextInt(10) + 2;
            for (int i = 0; i < size; i++)
                add(rd.nextInt(20));
        }};

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q);
        //[ 1 ,2, 3 ,4,5,6,7] ->>
        //  |                  |
        //  r                  i
        //[ null ,null, 3 ,4,5,6,7]
        //   |          |
        //   i          r
        //add(8)
        //add(9)
        //[ 8 ,9, 3 ,4,5,6,7]
        //       ||
        //       ir
        //[ 8 ,9 ->>, 3 ,4,5,6,7]
        //       ||
        //       ir
        //add(10)
        //[ 8 ,9,10,null 3 ,4,5,6,7]
        //          |    |
        //          i    r

        System.out.println("---------------MyQueue------------------");
        MyQueue<Integer> mq = new MyQueue<>(14){{
            for (int i = -3; i <15 ; i++) {
            add(i);
            }
        }};
        System.out.println(mq);
        mq.remove();
        mq.remove();
        mq.remove();
        mq.remove();
        System.out.println(mq);

        mq.add(11);
        mq.add(12);
        mq.add(13);
        mq.add(14);

        System.out.println(mq);



    }

}
