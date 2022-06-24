/* ------------------------------

21_largestProductOfThree
Daily Coding from CodeStates
Fri 24 June 2022

Return maximum value multiplied by three elements from integer array as input.
정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴해야 합니다.

------------------------------- */
import java.util.Arrays;

public class largestProductOfThree {
    public static void main(String[] args) {
        // int[] arr = {2, 1, 3, 7};  // 42
        int[] arr = {-1, 2, -5, 7};  // 35

        Arrays.sort(arr);
        int head = arr[0] * arr[1] * arr[arr.length - 1]; //제일작은음수2개*제일큰양수
        int tail = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3]; //제일큰양수3개
        if (head > tail) System.out.println(head);
        else System.out.println(tail);
    }
}
