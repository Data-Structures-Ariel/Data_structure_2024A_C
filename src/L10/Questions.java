package L10;

import L09.Node;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;


public class Questions {

    public static void main(String[] args) {
        Node<Integer> chain = new Node<>(1, new Node<>(0, new Node<>(0, new Node<>(1, new Node<>(0, new Node<>(0, new Node<>(0, new Node<>(0, new Node<>(0, new Node<>(0, new Node<>(1, new Node<>(0, new Node<>(1)))))))))))));
        print(chain);
        int decimal = binToDec(chain);
        System.out.println(decimal);
        print(chain);

        Queue<Integer> q = new LinkedList<>() {{
            add(10);
            add(12);
            add(7);
            add(6);
            add(2);
            add(5);
        }};
        System.out.println(q);
        System.out.println(q.peek());

        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        System.out.println(s);
        System.out.println(s.peek());


        Queue<Integer> q1 = new LinkedList<>() {{
            add(10);
            add(12);
            add(7);
            add(6);
            add(2);
            add(5);
        }};
        System.out.println(q1);
        Stack<Integer> cp = copy(q1);
        System.out.println(cp);
        System.out.println(q1);
        Queue<Integer> copyQueue = cloneQ(q1);
        Stack<Character> sc = new Stack<>();
        char ch = deepStack(sc,4);

        boolean bool = sumS(s);

    }

    private static boolean sumS(Stack<Integer> s) {
        if(s==null || s.isEmpty())
            return true;
        Stack<Integer> temp = new Stack<>();
        int inx=1;
        int sum1=0,sum2=0;
        while(!s.isEmpty()){
            int num = s.pop();
            temp.push(num);
            if(inx%2!=0)
                sum2+=num;
            if(num%2!=0)
                sum1+=num;
        }
        while (!temp.isEmpty())
            s.push(temp.pop());

        return sum1==sum2;
    }

    public int getLast(Node head){
        if(head==null)
            return -1;
        int index=0;
        while (head!=null){
            index++;
            head=head.getNext();
        }
        return index-1;
    }

    public int isSorted(Node<Integer> head){
        if(head==null)
            return 1;
        while (head.hasNext()){
            if(head.getValue()>head.getNext().getValue())
                return 0;
            head=head.getNext();
        }
        return 1;
    }

    private static char deepStack(Stack<Character> s, int k) {
        if(s==null || s.isEmpty() || k<=0)
            throw new NoSuchElementException();

        Stack<Character> temp = new Stack<>();
        while (!s.isEmpty() && k!=0){
            temp.push(s.pop());
            k--;
        }
        char ch = temp.peek();

        while (!temp.isEmpty() ){
            s.push(temp.pop());
        }
        if(k!=0)
            throw new NoSuchElementException();

        return ch;

    }

    private static Queue<Integer> cloneQ(Queue<Integer> q) {
        if(q==null)
            return null;
        if(q.isEmpty())
            return new LinkedList<>();
        Queue<Integer> qTemp= new LinkedList<>();
        Queue<Integer> qCopy= new LinkedList<>();
        while(!q.isEmpty())
        {
            qTemp.add(q.peek());
            qCopy.add(q.poll());
        }
        while(!qTemp.isEmpty())
            q.add(qTemp.poll());

        return qCopy;
    }
    private static Stack<Integer> cloneS(Stack<Integer> s) {
        if(s==null)
            return null;
        if(s.isEmpty())
            return new Stack<>();
        Stack<Integer> sTemp= new Stack<>();
        Stack<Integer> sCopy= new Stack<>();
        while(!s.isEmpty())
            sTemp.add(s.pop());

        while(!sTemp.isEmpty()){
            sCopy.add(s.peek());
            s.add(sTemp.pop());
        }
        return sCopy;
    }
    private static Stack<Integer> copy(Queue<Integer> q) {
        if (q == null)
            return null;
        if (q.isEmpty())
            return new Stack<>();

        Queue<Integer> temp = new LinkedList<>();
        Stack<Integer> sCopy = new Stack<>();
        Stack<Integer> sTemp = new Stack<>();

        while (!q.isEmpty()) {
            temp.add(q.peek());
            sTemp.push(q.poll());
        }

        while (!sTemp.isEmpty()) {
            q.add(temp.poll());
            sCopy.push(sTemp.pop());
        }
        return sCopy;
    }
    private static int binToDec(Node<Integer> chain) {
        if (chain == null)
            return 0;
        int size = 0;
        int sum = 0;
        Node<Integer> temp = chain;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }

//     for (Node<Integer> temp1 = chain; temp != null; temp1 = temp1.getNext(), size++) ;


        while (chain != null) {
            sum += chain.getValue() * Math.pow(2, size - 1);
            size--;
            chain = chain.getNext();
        }

        return sum;
    }
    private static void print(Node<Integer> chain) {

        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }
}
