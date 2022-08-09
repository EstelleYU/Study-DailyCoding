/* -------------------------------
50_LPS (Longest Prefix which is also Suffix)
Tuesday, August 9th, 2022
Daily Coding from CodeStates
------------------------------------
A string array as input, return the length of the LPS (Longest Prefix which is also Suffix)
non-overlapping: It should be non-overlapped part between prefix and suffix.
Prefixes and suffixes must not overlap each other.
In other words, prefix and suffix must not have as elements a character located at the same index in the string.

문자열을 입력받아 다음의 조건을 만족하는 LPS*를 찾아 그 길이를 리턴해야 합니다.
LPS: 주어진 문자열의 가장 긴 접두어이자 접미어(Longest Prefix which is also Suffix)
non-overlapping: 접두어와 접미어는 서로 겹치는 부분이 없어야 합니다.
다시 말해, prefix와 suffix는 문자열의 동일한 인덱스에 위치한 문자를 요소로 가지면 안 됩니다.
------------------------------ */

public class LPS {
    public static void main(String[] args) {
        int output = LPS_f("abbbcc");
        System.out.println(output); // --> 0

        output = LPS_f("aaaa");
        System.out.println(output); // --> 2
        // prefix: str.substring(0, 2)
        // suffix: str.substring(2)
        // non-overlapping 조건이 없는 경우 정답은 4 입니다.

        output = LPS_f("aaaaa");
        System.out.println(output); // --> 2
        // prefix: str.substring(0, 2)
        // suffix: str.substring(3)
        // non-overlapping 조건이 없는 경우 정답은 5 입니다.

    }
    public static int LPS_f(String str) {
        if(str.length() < 2) return 0;

        // 문자열을 두 부분으로 나누고
        // 각 부분의 첫 인덱스를 저장
        int leftIdx = 0;
        // 문자열의 길이가 홀수일 수 있으므로, 올림한다.
        int rightIdx = (str.length() / 2);

        while (rightIdx < str.length()) {
            if (str.charAt(leftIdx) == str.charAt(rightIdx)) {
                // LPS 검사를 시작한 위치부터 지금까지 계속 같은 경우
                // 다음 문자도 같은지 확인하기 위해 인덱스를 이동한다.
                leftIdx++;
                rightIdx++;
            } else {
                // leftIdx가 0인 경우, 단순히 rightIdx를 1 증가 (suffix의 시작점을 뒤로 한 칸 이동)
                // prefix, suffix가 계속 일치하다가 중간에서 일치하지 않는 경우에도,
                // 현재 suffix의 시작점을 뒤로 한 칸 이동한다.
                rightIdx = rightIdx - leftIdx + 1;
                leftIdx = 0;
            }
        }
        // LPS가 없는 경우
        return leftIdx;
    }
}
