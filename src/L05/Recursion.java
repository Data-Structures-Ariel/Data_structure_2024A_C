package L05;

public class Recursion {

    public static void main(String[] args) {
        int n = 6; // 1*1*2*3*4*5*6 = 720*7
        // f(n) =
        // f(2) = 2
        // f(3) = 6
        // f(4) = 24 // f(3) * 4
        //-----------------------------
        // n=10
        // f(10) = f(9) * 10
        // f(9) = f(8) * 9
        // f(8) = f(7) * 8
        // f(7) = f(6) * 7
        // f(6) = f(5) * 6
        // f(5) = f(4) * 5
        // f(4) = f(3) * 4
        // f(3) = f(2) * 3
        // f(2) = f(1) * 2
        // f(1) = 1 * 1

        // n=10

        // f(10) = 362880 * 10 = 3628800
        // f(9) = 40320 * 9
        // f(8) = 5040 * 8
        // f(7) = 720 * 7
        // f(6) = 120 * 6
        // f(5) = 24 * 5
        // f(4) = 6 * 4
        // f(3) = 2 * 3
        // f(2) = 1 * 2
        // f(1) = 1*1
        // f(0) =1


        // factorial(n) = factorial(n-1)*n
        int f = factorial(n); //(1,1,2,6,24,120,720,.,.,.,.,3628800,...)
        System.out.println(f);
        // dis = 1
        // (1,2,3,4,..,
        // dis =2
        // (10,12,14,16,18,..

        f = factorial(3) * 4;
        System.out.println(f);

        // dis = 1
        // (0,1,2,3,4,5,6,7,8,9,...)
        // (0, 0+1 ,0+1+2 , 0+1+2+3 ,0+1+2+3+4, sumN(4)+5
        // sumN(n) = sumN(n-1) + (0+(n-1)*1)

        // dis = 2
        // (0,2,4,6,8,10,12,14,16,18,...)
        // (0, 0+2 ,0+2+4 , 0+2+4+6, 0+2+4+6+8,...
        // sumN2(n) = sumN2(n-1) +n*2
        // sumN2(4) = sumN2(3) +  4*2

        int s = sumN(n);
        System.out.println(s);

        //2^n (1,2,4=(2*2) ,8=(2*2*2)
        // base^exp (1, base*base,base*base*base,base*base*base*base
        // pow(base,exp) = pow(base,exp-1)*base
        int base = 2;
        int exp = 3;
        int p = pow(base, exp);
        System.out.println(p);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        int num = 10;
        int index = binarySearch(arr, num, 0, arr.length - 1);
        System.out.println(index);
        // [ 1,2,3,4,5,6,7,8,9,10]
        // ((0,arr.len),((0,mid),(mid,arr.len)),
        // num= 10
        // bin(n,num)=bin(n/2,num)


        // fib (1,1,2,3,5,8,13,21,34,55,89,....,)
        // fib(n) = fib(n-1)+fib(n-2)
        int fibNumber =fib(n);
        System.out.println(fibNumber);

    }

    private static int fib(int n) {
        if(n==0 || n==1)
            return 1;

        return fib(n-1)+fib(n-2);
    }

    private static int binarySearch(int[] arr, int num, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == num)
            return mid;

        if (arr[mid] > num)
            return binarySearch(arr, num, low, mid - 1);

        return binarySearch(arr, num, mid + 1, high);

    }


    private static int pow(int base, int exp) {
        if (exp == 0)
            return 1;
        return pow(base, exp - 1) * base;
    }

    private static int sumN(int n) {
        if (n == 0)
            return 0;
        return sumN(n - 1) + n;
    }
    // sum(n) = sum


    private static int factorial(int n) {
        if (n == 0)
            return 1;
        return factorial(n - 1) * n;
    }


}
