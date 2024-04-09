package L03;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = new int[rd.nextInt(15) + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));

        int c = aCommonNumber(arr);
        System.out.println(c);

        c = imACommonNumber(arr);

        int N = 10;
        arr = new int[]{10, 23, 40, 53, 54, 21, 45, 11, 355, 56};
        int sum = Q(N, arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
    // 4n+3
    // a = 4
    // b= 3
    // O(n)
    private static int Q(int num, int[] arr) {

        int sum = 0; //1
        for (int i = 0 /*1*/; i < arr.length ; i++) {
//            sum += (arr[i] % 2 == 0) ? arr[i] : 0;
            if (arr[i] % 2 == 0)
                sum += arr[i];
        }
        return sum;//1
    }

    private static int imACommonNumber(int[] arr) {

        int[] counter = new int[20]; // 1

        for (int i = 0; i < arr.length; i++) // 3n+1
            counter[arr[i]]++;

        int index = 0; // 1

        for (int i = 1; i < counter.length; i++) { // 4*20 +1 = 81 = O(1)
            if (counter[index] > counter[i])
                index = i;
        }

//        int max=0;
//        int number=0;
//
//        for (int i = 1; i < counter.length; i++) {
//            if(max<counter[i]) {
//                number = i;
//                max = counter[i];
//            }
//        }
        return index; // 1
        // 3n+85 -> O(n)
    }

    // n = גודל המערך
    // n(4n+7)+1 = 4n^2+7n+4 = O(n^2) an^2+bn+c
    private static int aCommonNumber(int[] arr) {

        int max = 0; // 1
        int number = arr[0]; // 1
        int count = 0; // 1


        for (int i = 0 /*1*/; i < arr.length /*1*/; i++ /*1*/) {
            for (int j = 0 /*1*/; j < arr.length /*n*/; j++ /*n*/) {
                if (arr[i] == arr[j]) // 1
                    count++; // 1

                // j=0 -> 4
                // j==1 ->4
                // j==2 ->4
                // j==3 ->4
                // j==4 ->4
                // j==5 ->4
                //...
                //...
                //...
                // j==n ->4
            } // 4n+1
            if (max < count) { // 1
                max = count; // 1
                number = arr[i]; // 1

            } // 3
            count = 0; // 1
            //4n+7

            // i=0 -> 4n+7
            // i==1 ->4n+7
            // i==2 ->4n+7
            // i==3 ->4n+7
            // i==4 ->4n+7
            // i==5 ->4n+7
            //...
            //...
            //...
            // i==n ->4n+7
        }

        return number;
    }


}
