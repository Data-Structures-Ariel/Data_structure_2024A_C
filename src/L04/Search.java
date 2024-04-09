package L04;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Search {

    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = new int[rd.nextInt(30)];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000);
        }

        System.out.println(Arrays.toString(arr));
        int num = rd.nextInt(1000);
        System.out.println(num);
        int index = linearSearch(arr, num);
        System.out.println(index);
//        System.out.println(arr[index]);

        // שאלה: בהינתן פונקציה לא רקורסיבית שאיננה מכילה לולאות מה נוכל להגיד על הסיבוכיות של הפונקציה?


        //algoSearch1 n
        //algoSearch2 1/2n

        //[0-19,0-19,..,0-19]
        // [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int mispar = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (mispar == arr[j])
                    count++;
            }
            if (count > max)
                max = count;
        }

//        int[] counter = new int[20];
//        //counter= [6,0,0,0,0,1,0,0,0,3,0,0,0,0,0,0,0,4]
//        for (int i = 0; i < arr.length; i++) {
//            int inx = arr[i];
//            counter[inx]++;
//        }

        int[] sortArr = new int[rd.nextInt(20)];


        for (int i = 0; i < sortArr.length; i++) {
            sortArr[i] = rd.nextInt(1000);
        }
        Arrays.sort(sortArr);

        System.out.println(Arrays.toString(sortArr));
        // n^1  n^(1/2)  n^(1/3)

        // [317, 236, 139, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480]
        // [ 184, 550, 200]
        // [ 184 ]

        // 1024 / 2 = 512
        // 512 / 2 = 256
        // 256 / 2 = 128
        // 128 / 2 = 64
        // 64 / 2 = 32
        // 32 / 2 = 16
        // 16 / 2 = 8
        // 8 / 2 = 4
        // 4 / 2 = 2
        // 2 / 2 = 1

        // num = 500                              midIndex = (lowIndex+highIndex)/2 (6)
        //          lowIndex = 0                   midIndex                   highIndex = 12
        //              |                             |                            |
        // sortArr = [131, 131, 232, 293, 367, 397, 445, 543, 738, 817, 885, 923, 940]
        //                                          lowIndex = 7  midIndex = 9 highIndex = 12
        //                                                |          |              |
        // sortArr = [131, 131, 232, 293, 367, 397, 445, 543, 738, 817, 885, 923, 940]
        //                                              l=m=7  h = 8
        //                                                ||   |
        // sortArr = [131, 131, 232, 293, 367, 397, 445, 543, 738, 817, 885, 923, 940]
        //                                           h =l=m=6
        //                                           |||
        // sortArr = [131, 131, 232, 293, 367, 397, 445, 543, 738, 817, 885, 923, 940]

        BinarySearch(sortArr, num);
    }
    // num = 447
    // sortArr = [131, 131, 232, 293, 367, 397, 445, 543, 738, 817, 885, 923, 940]
    private static int BinarySearch(int[] sortArr, int num) {

        if (sortArr == null) // 1
            return -1;

        int lowIndex = 0; // 1
        int highIndex = sortArr.length - 1; //1

        // arr.len = 256
        while (lowIndex < highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (sortArr[midIndex] == num)
                return midIndex;
            else if (sortArr[midIndex] < num)
                lowIndex = midIndex + 1;
            else
                highIndex = midIndex - 1;
        }

        // 2^10 =  2*2*2*2*2*2*2*2*2*2 = 1024
        // log(1024) = 10
        // log8(1024) =
        // 12*12 = 144
        // sqrt(144) = 12

        return -1;

    }

    // 3n+3
    private static int linearSearch(int[] arr, int num) {

        if (arr == null) // O(1)
            return -1;
        int i = 0; // 1 ->O(1)
        // נסמן את אורך המערך ב-n
        // 3n ->O(n)
        for (; i < arr.length /*1*/; i++ /*1*/) {
            if (arr[i] == num) /*1*/
                return i;
        }
        return -1; // O(1)
    }

    private static int algo1(int[] arr /*len = 8*/, int num) {

        if (arr == null) // O(1)
            return -1;
        if (arr[1] == num) /*1*/
            return 0;
        if (arr[1] == num) /*1*/
            return 1;
        if (arr[2] == num) /*1*/
            return 2;
        if (arr[3] == num) /*1*/
            return 3;
        if (arr[4] == num) /*1*/
            return 4;
        if (arr[5] == num) /*1*/
            return 5;
        if (arr[6] == num) /*1*/
            return 6;
        if (arr[7] == num) /*1*/
            return 7;
        if (arr[8] == num) /*1*/
            return 8;
        return -1;
    }

    // n
    private static int algo2(int[] arr, int num) {

        if (arr == null) // O(1)
            return -1;

        for (int i = 0; i < arr.length /*1*/; i++ /*1*/) {
            if (arr[i] == num) /*1*/
                return i;
        }
        return -1; // O(1)
    }
}
