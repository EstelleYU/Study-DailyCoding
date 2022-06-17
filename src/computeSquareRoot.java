
/* ------------------------------
17_computeSquareRoot
Daily Coding from CodeStates
Fri 17 June 2022

Input a number and return the square root value to two decimal places.
수를 입력받아 제곱근 값을 소수점 두 자리까지 리턴해야 합니다.
----------------------------- */

import static java.lang.Math.round;
import static java.lang.String.format;

public class computeSquareRoot {
    public static void main(String[] args) {
        double num = 10;
        double num1 = 1;
        while(true) {
            if(num1 * num1 < num ) num1++;
            else break;
        }

        while ( num-(num1*num1) > 0.1 ||  (num1*num1)-num > 0.1  ) {
            num1 = ( num1 + (num/num1) ) / 2 ;
            num1 = Math.round(num1 * 100) / 100.0;
            System.out.println("num1 = " + num1);
        }
        System.out.println(String.format("%.2f", num1));
    }
}
