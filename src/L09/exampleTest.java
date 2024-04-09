package L09;

import java.util.NoSuchElementException;
import java.util.Stack;

public class exampleTest {


    public static void main(String[] args) {
        Stack<Character> s = new Stack<>(){{
            push('3');
            push('$');
            push('A');
            push('@');
            push('&');

        }};
        int k=4;
       char ch= deepStack(s,k);
    }

    private static int getLast(Node<Integer> chain) {
        if(chain==null)
            return -1;
        int index=0;

        while(chain!=null){
            index++;
            chain=chain.getNext();
        }

        return index-1;
    }

    private static boolean isSort(Node<Integer> chain) {
        if(chain==null)
            return true;

        while(chain.getNext()!=null){
            if(chain.getValue()>chain.getNext().getValue())
                return false;
            chain=chain.getNext();
        }

        return true;
    }
    private static char deepStack(Stack<Character> s, int k) {
        if(s==null || s.isEmpty() || k<=0)
            throw new NoSuchElementException();

        Stack<Character> temp = new Stack<>();
       while (!s.isEmpty() && k!=0){
           temp.push(s.pop());
           k--;
       }
       if(k!=0)
           throw new NoSuchElementException();

        char ch = temp.peek();

        while (!temp.isEmpty()){
            s.push(temp.pop());
        }

        return ch;
    }
}
