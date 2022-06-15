import java.util.ArrayList;
import java.util.Scanner;

/* ------------------------------
15_modulo
Daily Coding from CodeStates
Wed 15 June 2022

Input 2 numbers (num1, num2) and return remainder of dividing num1 by num2
( Not using operator divider / and operator remainder % ).
----------------------------- */

public class modulo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(" num1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print(" num2 입력  : ");
        int num2 = sc.nextInt();

        if (num2 == 0) System.out.println("null");
        else if (num1 == 0) System.out.println("0");

        while (num1 >= num2) {
            num1 -= num2;
        }
        System.out.println(num1);
    }
}
