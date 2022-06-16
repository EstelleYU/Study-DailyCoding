import java.util.Scanner;

/* ------------------------------
16_isIsogram
Daily Coding from CodeStates
Thu 16 June 2022

Return whether String array is isogram or not.
Isogram means a word or phrase in which each letter occurs the same number of times.

문자열을 입력받아 아이소그램인지 여부를 리턴해야 합니다.
아이소그램(isogram)은 각 알파벳을 한번씩만 이용해서 만든 단어나 문구를 말합니다.
----------------------------- */

public class isIsogram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(" 문자열 입력 : ");
        String str = sc.next();
        String strLower = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (strLower.charAt(i) == strLower.charAt(j) ) System.out.println("false");
            }
        }
        System.out.println("true");
    }
}

/*  Reference

package com.codestates.coplit;
import java.util.*;

public class Solution {
	public boolean isIsogram(String str) {
    //입력된 문자열이 공백일 경우 true를 리턴합니다.
    if(str.length() == 0) return true;

    //사용된 알파벳을 저장할 HashMap을 선언합니다.
    HashMap<Character, String> cache = new HashMap<Character, String>();

    //입력된 전체 문자열을 모두 소문자로 변환합니다.
    str = str.toLowerCase();

    //입력된 문자열을 순회하며
    for(int i = 0; i < str.length(); i++) {
      //HashMap에 이미 해당 알파벳이 저장되어 있다면
      if(cache.containsKey(str.charAt(i))) {
        //false를 리턴합니다.
        return false;
      }
      //HashMap에 해당 문자열이 저장되어 있지 않다면, 저장합니다.
      cache.put(str.charAt(i), "Exists");
    }
    //모든 문자열을 순회한다면 true를 리턴합니다.
    return true;
  }
}


 */