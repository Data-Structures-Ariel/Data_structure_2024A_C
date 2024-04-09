package L08;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    public static void main(String[] args) {
        int N = 4;
        MyQueue<Integer> qN = nLevel(N);
        System.out.println(qN);

        Queue<Integer> qNLevel = Level(N);
        System.out.println(qNLevel);


        boolean bool = isNLevel(qNLevel, N);
    }

    private static boolean isNLevel(Queue<Integer> q, int N) {
        if (q == null || q.isEmpty() || N <= 0 /*|| queue.peek() != 1 */)
            return false;

        //q=[1,2,2,3,3,3]
        // N=4
        //[1,2,2,3,3,3,4,4,4,4]

        //q=[1,2,2,3,3,3]
        //N=2
        //[1,2,2]
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (q.isEmpty())
                    return false;
                if (i != q.remove())
                    return false;

            }
        }
        //q=[1,2,2,4,6,3,67,2,6,2,6,2,546,2,5]
        //N=2
        //[1,2,2]
        return q.isEmpty();
    }

    private static boolean isNLevelWithNLevel(Queue<Integer> queue, int N) {
        if (queue == null || queue.isEmpty() || N <= 0 /*|| queue.peek() != 1 */)
            return false;
        Queue<Integer> q = Level(N);

        while (!queue.isEmpty() && !q.isEmpty())
            if (queue.remove() != q.remove())
                return false;

        return queue.isEmpty() && q.isEmpty();
    }

    // n*(n+1)/2 ->  O(n^2)
    private static Queue<Integer> Level(int n) {

        if (n <= 0)
            return null;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                q.add(i);
            }
        }
        return q;

    }

    private static MyQueue<Integer> nLevel(int n) {

        if (n <= 0)
            return null;
        // (1,2,3,4,5,6,7,......)
        // (0,1,3,6,10,15,21,...)

        // size =  (4*(4+1)/2;
        int size = (n * (n + 1)) / 2;

        MyQueue<Integer> q = new MyQueue<>(size);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                q.add(i);
            }
        }
        return q;
    }
}
