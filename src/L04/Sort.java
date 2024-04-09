package L04;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {

        int[] arr = {317, 236, 139, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480};
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------------------");
        // input =  [317, 236, 139, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 317, 139, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 139, 317, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 716, 548, 353, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 548, 716, 353, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 548, 353, 716, 319, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 548, 353, 319, 716, 206, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 548, 353, 319, 206, 716, 8, 480]
        // input =  [236, 139, 184, 317, 200, 550, 614, 548, 353, 319, 206, 8, 480, 716]

        // input =  [139, 184, 236,200, 317, 550, 548, 353, 319, 206, 8, 480, 614, 716]

        // input =  [139, 184,200, 236, 317, 548, 353, 319, 206, 8, 480, 550, 614, 716]

        // input =  [139, 184,200, 236, 317, 353, 319, 206, 8, 480, 548, 550, 614, 716]

        // input =  [139, 184,200, 236, 317, 353, 319, 206, 8, 480, 548, 550, 614, 716]

        // output =  [8, 139, 184, 200, 206, 236, 317, 319, 353, 480, 548, 550, 614, 716]

        //O(n^2)
        for (int i = 0; i < arr.length; i++) {
        System.out.println("Bubble sort iter -> "+i);
            bubbleSortTest(arr);
            System.out.println(Arrays.toString(arr));
        }

        int[] arr2 = {317, 236, 139, 184, 550, 200, 614, 716, 548, 353, 319, 206, 8, 480};
        //{317, 236, 139, 184, 550, 200, 614, 480, 548, 353, 319, 206, 8, 716}
        //{317, 236, 139, 184, 550, 200, 8, 480, 548, 353, 319, 206, 614, 716}
        //{317, 236, 139, 184, 206, 200, 8, 480, 548, 353, 319, 550, 614, 716}
        System.out.println(Arrays.toString(arr2));

        selectionSort(arr2);
        max(arr2,arr.length);

        System.out.println(Arrays.toString(arr2));
    }

    //O(n^2)
    private static void selectionSort(int[] arr) {
        if(arr==null)
            return ;

        for (int i = 0; i <arr.length ; i++) {
            int lastIndexToSearch = arr.length-i;
            int maxIndex = max(arr,lastIndexToSearch); // n , n-1, n-2 ,...,n-i,...,1
            // n+(n-1)+(n-2)+...+1 -> (n(n+1))/2 -> O(n^2)
            swap(arr,maxIndex,lastIndexToSearch-1);
        }

    }

    private static void swap(int[] arr, int maxIndex, int lastIndexToSearch) {
        int temp = arr[maxIndex];
        arr[maxIndex]=arr[lastIndexToSearch];
        arr[lastIndexToSearch]=temp;
    }

    private static int max(int[] arr , int from ) {

        if(arr==null)
            return -1;
        int maxIndex=0;
        for (int i = 0; i <from; i++) {
            if(arr[maxIndex]<arr[i])
            {
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    private static void bubbleSortTest(int[] arr) {
        if(arr==null)
            return;
        for (int i = 0; i < arr.length-1 ; i++) {
            if(arr[i]>arr[i+1])
            {
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        if(arr==null)
            return;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
    }
}
