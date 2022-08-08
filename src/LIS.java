
/* -------------------------------
49_LIS (Longest Increasing Subsequence)
Monday, August 8th, 2022
Daily Coding from CodeStates
------------------------------------
With a integer array as input, return the length of the longest increasing subsequence (LIS).

LIS: The longest non-contiguous sub-array of an array in which all elements are strictly in ascending order.

배열 [1, 2, 3]의 subseqeunce는 [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3] 입니다.
엄격한 오름차순: 배열이 동일한 값을 가진 요소없이 오름차순으로 정렬되어 있는 경우를 말합니다.

LIS를 계산하는 효율적인 알고리즘(O(N^2))이 존재합니다. 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
subsequence는 문자열 또는 배열같이 순서가 있는 데이터에서 순서의 대소 관계가 유지되는 모든 부분 문자열 또는 부분 배열을 의미합니다.
 sequence가 순서 또는 서열을 의미하기 때문에 subsequence는 부분 서열이라고 부르기도 합니다.
 반면 substring 또는 subarray는 연속된 형태의 부분 문자열 또는 부분 배열을 의미합니다.
 문자열 "abcd"의 subsequence와 substring은 각각 아래와 같습니다.
substring: "a", "b", "c", "d", "ab", "bc", "cd", "abc", "bcd", "abcd"
subsequence: "a", "b", "c", "d", "ab", "ac", "ad", "bc", "bd", "cd", "abc", "abd", "acd", "bcd", "abcd"
LIS의 길이 대신 LIS 자체를 리턴하는 함수를 구현해 보시기 바랍니다.

------------------------------ */


import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int output = LIS_f(new int[]{3, 2});
        System.out.println(output); // --> 1 (3 or 2)

        output = LIS_f(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // --> 3 (3, 10, 20)
    }

    public static int LIS_f(int[] arr) {
        int N = arr.length;
        // lis[i]는 i에서 끝나는 LIS의 길이를 저장
        // 최소한 각 요소 하나로 LIS를 만들 수 있으므로 1로 초기화한다.
        int[] lis = new int[N];
        Arrays.fill(lis, 1);
        for(int i = 1; i < N; i++) {
            // i에서 끝나는 LIS의 길이
            for (int j = 0; j < i; j++) {
                // i 이전의 인덱스만 검사하면 된다.
                // i는 1부터 시작하므로, 짧은 길이부터 검사한다. (bottom-up 방식)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
