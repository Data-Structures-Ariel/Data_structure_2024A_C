package L06;

import java.util.*;

public class Main {
    static int[] arr;
    static int[] arr2 = new int[4];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        int[] temp = new int[101];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[100] = 100;
        arr = temp;

//        System.out.println(Arrays.toString(arr));
//        useArrayPrint();
        System.out.println("---------------------------------------");

        System.out.println("---------------------------------------");
        ArrayList<Integer> al = new ArrayList<>();

        int i = 0;
        while (i!=0) {
            System.out.println("Enter Number");
            if (arr2.length == i) {
                int[] tempArray = new int[arr2.length + 1];
                for (int j = 0; j < arr2.length; j++) {
                    tempArray[j] = arr2[j];
                }
                arr2 = tempArray;
            }
            int num = sc.nextInt();
//            al.add(num);
            arr2[i] = num;
            i++;
            System.out.println(Arrays.toString(arr2));
        }
        LinkedList<Integer> ll = new LinkedList<>();

        func(al);
        func(ll);

        MyArrayList<Integer> mal = new MyArrayList<>();
        for (int j = 0; j < 100; j++) {
            mal.add(j);
            System.out.println(mal);
        }

    }

    private static void func(List l) {


    }

    private static void useArrayPrint() {
        System.out.println(Arrays.toString(arr));
    }

    private static void use1ArrayPrint() {
        System.out.println(Arrays.toString(arr));
    }

    private static void use2ArrayPrint() {
        System.out.println(Arrays.toString(arr2));
    }

    private static void use3ArrayPrint() {
        System.out.println(Arrays.toString(arr2));
    }

}
