package L05;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    static <T> boolean isEq(T n1, T n2) {
        System.out.println(n1.getClass());
        System.out.println(n2.getClass());
        return n1.equals(n2);
    }

    public static void main(String[] args) {

        System.out.println(isEq(2, 2));
        System.out.println(isEq(2.0, 2));
        System.out.println(isEq("bob", "bob"));
        System.out.println(isEq('s', "bob"));
        System.out.println(isEq(true, true));
        System.out.println(isEq(new ArrayList<>(), 1));


    }
}

