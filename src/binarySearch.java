

/*---------------------------------------
41_binarySearch
Daily Coding from CodeStates
Tuesday, July 26th, 2022
---------------------------------------
문제
오름차순 정렬된 정수의 배열(arr)과 정수(target)를 입력받아 target의 인덱스를 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 정수
인자 2 : target
int 타입의 정수

출력
int 타입을 리턴해야 합니다.

주의사항
이진탐색 알고리즘(O(logN))을 사용해야 합니다.
단순한 배열 순회(O(N))로는 통과할 수 없는 테스트 케이스가 존재합니다.
target이 없는 경우, -1을 리턴해야 합니다.
 */

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int target = 2; // output = 2
        int output = bSearch(arr, target);
        System.out.println(output);
    }
    public static int bSearch(int[] arr, int target) {
        // 좌측 기준점
        int left = 0;
        // 우측 기준점
        int right = arr.length - 1;
        // 기준점이 서로에게 도달할때까지 반복합니다.
        while (left <= right) {
            // 중앙 기준점
            int middle = (right + left) / 2;
            // 현재 기준이 타겟과 일치한다면 해당 값을 반환합니다.
            if (arr[middle] == target) return middle;
            // 기준점보다 크다면 우측을 줄이고
            if (target < arr[middle]) {
                right = middle - 1;
                //기준점보다 작다면 좌측을 줄입니다.
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
