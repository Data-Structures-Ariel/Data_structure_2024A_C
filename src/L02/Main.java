package L02;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        long[] arr = new long[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(600);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == new Random().nextInt()) {
                System.out.println("V");
                break;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Time of algo -> "+(end - start));

        String str ="abcdh";
        boolean bool =SearchD(str);
    }

    // 24 פעולות
    private static boolean SearchD(String str) {

        char ch = str.charAt(0); // 1
        int i=0; // 1
        for ( i = 0 /*1*/; i <str.length() /*5*/  && ch!='D' /*5*/; i++  /*5*/) {
            ch = str.charAt(i); /*5*/
        }

        if(i==str.length()) // 1
            return false;
        else
            return true;

    }

    // 22 פעולות
    private static boolean SearchD2(String str) {

        char ch = str.charAt(0); // 1
        int i=0; // 1
        for ( ; i <str.length() /*5*/  && ch!='D' /*5*/; i++  /*5*/) {
            ch = str.charAt(i); /*5*/
        }

        return i==str.length();

    }

    // בעבור מחרוזת כללית נסמן את אורך המחרוזת ב-n

    // b = 4
    // a = 4
    // an+b
    // 4n+4 runtime function
    private static boolean SearchD3(String str) {
        int n = str.length(); // 1
        char ch = str.charAt(0); // 1
        int i=0; // 1
        for ( ; i <str.length() /*n*/  && ch!='D' /*n*/; i++  /*n*/) {
            ch = str.charAt(i); /*n*/
        }

        return i==str.length(); // 1

    }

    // 3n+2
    // b = 2
    // a = 3
    // an+b = 3n + 2
    // n = the number of digits in the number
    private static int TestBuildRunTimeFunction(int number) {
        int counter=0;
       while(number!=0) {
           number /= 10;
           counter++;
       }

       return counter;
    }

    // 4n+2
    // n = the number of digits in the number
    private static int TestBuildRunTimeFunction(int number, String str) {
        int counter=0;
        while(number!=0) {
            number /= 10;
            counter++;
            str+=counter;
        }

        return counter;
    }

    // 43
    // n = the number of digits in the number
    private static int TestBuildRunTimeFunction(String str) {
        int counter=0; // 1

        for (int i = 0 /*1*/; i < 10 /*10*/; i++ /*10*/) {
            str+=i; /*10*/
            counter++; /*10*/
        }

        return counter; /*1*/
    }
    // 3n+2
    // n = the number of digits in the number
    // m = the length of the string
    // 4m+3
    // 4m+3n+5
    //  example:
    // number = 4675 -> n = 4
    // str = "ברק לא שומעים אותך" -> m = 18
    // 4 * 18 + 3 * 4 + 5 = 89
    // b = 5
    // a1 = 3
    // a2 = 4
    //a1*n +a2*m +b = 4m+3n+5
    private static void TestBuildRunTimeFunction(long number, String str) {

        int counter=0;
        while(number!=0) {
            number /= 10;
            counter++;
        }

        System.out.println(counter);

        char ch = str.charAt(0);
        int i=0;
        for ( ; i <str.length()   && ch!='D' ; i++  ) {
            ch = str.charAt(i);
        }

        System.out.println(str);

    }


    // בעבור מחרוזת כללית נסמן את אורך המחרוזת ב-n
    // c = 3
    // d = 5
    // runtime function is a*n+b
    // 3n+5 runtime function
    // str=Hello
    // O(n)
    private static boolean improvingSearchD3(String str) {
        str+='D'; // 1
        // str=HelDloD
        int n = str.length(); // 1
        char ch = str.charAt(0); // 1
        int i=0; // 1

        while ( ch!='D' /*n*/) {
            i++;  /*n*/
            ch = str.charAt(i); /*n*/
        }

        return i!=str.length()-1; // 1

    }
}
