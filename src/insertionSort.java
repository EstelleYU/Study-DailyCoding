

/*---------------------------------------
36_insertionSort
Daily Coding from CodeStates
Friday, July 15th, 2022

문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 정수
arr.length는 1,000 이하

출력
int 타입을 요소로 갖는 배열을 리턴해야 합니다.
배열의 요소는 오름차순으로 정렬되어야 합니다.
arr[i] <= arr[j] (i < j)

주의사항
삽입 정렬을 구현해야 합니다.
Arrays.sort() 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
---------------------------------------*/

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr =  {3, 1, 21};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));

    }
    public static int[] sort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target - 1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target - 1] = arr[target];
                arr[target] = temp;
                target--;
            }
        }
        return arr;
    }

}
