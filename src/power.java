import java.util.Scanner;

/* ------------------------------
25_power
Daily Coding from CodeStates
Thu 30 June 2022

Input the base and the exponent, return base to the power of exponent.
 ------------------------------ */
public class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" input base : ");
        long base = sc.nextInt();
        System.out.print(" input exponent : ");
        long exponent = sc.nextInt();
        long result = 1;
        result = power(base, exponent);
        System.out.println(result);
    }
    public static long power(long base, long exponent) {
        long remainder = 1;
        long output = 1;

        output = power(base, exponent/2);
        if (exponent % 2 == 0) output *= output;
        else output *= output * base;

        return ( power(base, exponent) );
    }
}

