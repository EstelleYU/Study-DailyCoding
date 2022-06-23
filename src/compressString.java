/* ------------------------------

20_compressString
Daily Coding from CodeStates
Thu 23 June 2022

When a string is input and there are consecutive characters,
It should return a compressed string as a combination of a number
and a character to repeat consecutive sections.
문자열을 입력받아 연속되는 문자가 있을 경우,
연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴해야 합니다.

----------------------------- */

public class compressString {
    public static void main(String[] args) {
        String str = "wwwggoppopppp";
        char x = str.charAt(0);
        int count = 1;
        String output = "";
        String y = "";
        for (int i=1; i<str.length(); i++){
            if ( x == str.charAt(i)) count++;
            else {
                if (count>=3) output += Integer.toString(count) + x;
                else {
                    y = Character.toString(x);
                    output += y.repeat(count) ;
                }
                x = str.charAt(i);
                count = 1;
            }
        }
        System.out.println(output);
    }
}
