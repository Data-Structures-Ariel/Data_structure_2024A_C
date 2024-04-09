package L07;

import java.util.Random;
import java.util.Stack;

public class Main {

    static Random rd = new Random();
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>(){{
            for (int i = 0; i < 5; i++) {
                push(i);
            }
        }};

        System.out.println(st);

        String s = "1*(2-6)+(6*(2-1))";
        boolean bool;
        System.out.println(s);
        bool = balancedBrackets(s);
        System.out.println("balancedBrackets -> "+bool);
        for (int i = 0; i < 10; i++) {
            s="";
            for (int j = 0; j < 10; j++) {
                s+=(rd.nextBoolean())?"(":")";
            }
            System.out.println(s);
            bool = balanced(s);
            System.out.println("balance -> "+bool);
            bool = balancedBrackets(s);
            System.out.println("balancedBrackets -> "+bool);
        }

        MyStack<Integer> mst = new MyStack<>();
        for (int i = 0; i < 20 ; i++) {
            mst.push(i);
            System.out.println("----------------------------------");
            System.out.println(mst);
            mst.print();
            System.out.println("----------------------------------");
        }

    }
    private static boolean balanced(String s) {
    if(s==null || s.length()==0 || s.length()%2!=0 || s.charAt(0)!='(')
        return false;
        //((())
        // st -> (
        //(()))
        // st -> (
        // ())(
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
                st.push('(');
            else if(st.isEmpty())
                return false;
            else
                st.pop();
        }

        return st.isEmpty() ;
    }

    private static boolean balancedBrackets(String s) {
        if(s==null || s.length()==0)
            return false;

        // 1*(2-6)+(6*(2-1)))
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
                st.push('(');
            else if(st.isEmpty() && s.charAt(i)==')' )
                return false;
            else if(s.charAt(i)==')')
                st.pop();
        }
        return st.isEmpty() ;
    }
}
