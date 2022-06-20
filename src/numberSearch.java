/* ------------------------------
18_numberSearch
Daily Coding from CodeStates
Mon 20 June 2022

Input a String and Sum all the numbers in the string.
Divide the sum by the length of rest of the string (except for numbers and spaces).
Return the share rounded to the integer.

문자열을 입력받아 문자열에서 숫자를 모두 찾아 더한 뒤에
해당 값을 (숫자와 공백을 제외한 나머지) 문자열의 길이로 나눈 값을
정수로 반올림하여 리턴해야 합니다.
----------------------------- */
public class numberSearch {
    public static void main(String[] args) {
        String str = "Hello6 9World 2,";
        double strLength = 0 ;
        double sum = 0;
        double output = 0;
        if (str.length() == 0) System.out.println("str is Empty!");
        for (int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))==true) {
                sum += ( str.charAt(i) - '0' );
            } else if (str.charAt(i)==' '){
                sum += 0;
            } else {
                strLength++;
            }
        }
        System.out.println("sum of Digit is "+sum);
        System.out.println("strLength is "+strLength);
        output = sum / strLength;
        System.out.println(output);
        System.out.println(Math.round(output));
    }
}