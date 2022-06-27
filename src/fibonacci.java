/*------------------------------
23_fibonacci
Daily Coding from CodeStates
Tue 28 June 2022

The 0th Fibonacci number is 0, and the 1st Fibonacci number is 1.
After the second Fibonacci number,
it is defined as the sum of the two previous preceding Fibonacci numbers.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

Use a recursive function.
Using of loops (for, while) is prohibited.
Use efficient algorithms using arrays.
 ------------------------------*/

import java.util.Scanner;

public class fibonacci {
    public static int[] arr = new int[10];
    public static int fib(int num) {
        if (arr[num] != 0) {
            // 이미 계산한 값
        } else {
            // 처음 계산되는 값
            arr[0] = 0;
            arr[1] = 1;
            if (num >= 2) {
                arr[num] = fib(num - 1) + fib(num - 2);
            }
        }
        return arr[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Input integer less than 10 : ");
        int num1 = sc.nextInt();
        for (int i=0; i<num1+1; i++) {
            System.out.println("fib(" + i + ")=" + fib(i));
        }
    }
}