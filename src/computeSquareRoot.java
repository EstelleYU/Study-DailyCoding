
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

/*

package com.codestates.coplit;
import java.util.*;

public class Solution {
	public String computeSquareRoot(int num) {
    //소수점 3자리부터 반올림하기 때문에, 배열에 소수점 자리만큼 double값을 선언, 할당합니다.
    double[] diffs = new double[]{1, 0.1, 0.01, 0.001};
    //초기값을 1로 설정합니다.
    double base = 1;

    //선언한 배열을 순회합니다.
    for(int i = 0; i < diffs.length; i++) {
      //초기값을 곱했을때, 입력된 값보다 작다면
      while (base * base < num) {
        //기본값에 배열의 인자(소숫점 초기값)을 더해줍니다.
        base = base + diffs[i];
      }
      //모두 더한 값이 입력된 num과 일치한다면 (더이상 낮은 숫자를 비교할 필요가 없을 경우)
      if(base * base == num) {
        //String.format을 사용하여 소수점 2자리까지의 값을 String값으로 변환하여 리턴합니다.
        return String.format("%.2f", base);
      }else {
        //기본 값에서 배열의 인자를 제외합니다
        //제외하여야 배열의 인자가 바뀌고, while문이 정상적으로 순회가 가능합니다.
        base = base - diffs[i];
      }
    }
    //String.format을 사용하여 소수점 2자리까지의 값을 String값으로 변환하여 리턴합니다.
    return String.format("%.2f", base);
  }
}


 */