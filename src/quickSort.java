
/*---------------------------------------
35_quickSort
Daily Coding from CodeStates
Thursday, July 14th, 2022
---------------------------------------

Return the matrix of integer numbers in ascending order
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

input
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 정수
arr.length는 100,000 이하

output
int 타입을 요소로 갖는 배열을 리턴해야 합니다.
배열의 요소는 오름차순으로 정렬되어야 합니다.
arr[i] <= arr[j] (i < j)

주의사항
퀵 정렬을 구현해야 합니다.
arr.sort 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

example
int[] output = quickSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
 --------------------------------------- */

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args){
        int[] input = {3, 1, 21};
        int[] output = new int[input.length];
        output = quickSort(input);
        System.out.println(Arrays.toString(output));
    }
    public static int[] quickSort(int[] arr) {
        //빈 배열일 경우
        if (arr.length == 0) return arr;

        int left = 0;
        int right = arr.length - 1;

        return sort(arr, left, right);
    }

    //퀵 정렬 메서드
    private static int[] sort(int[] arr, int left, int right) {
        //partition 메서드를 활용하여 정렬
        int part = partition(arr, left, right);
        if (left < part - 1) arr = sort(arr, left, part - 1);
        if (right > part) arr = sort(arr, part, right);

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 배열의 중앙을 기준으로
        int pivot = arr[(left + right) / 2];
        //좌측이 우측보다 작을 경우, 즉 아직 모든 배열을 순회하지 않은 경우 반복
        while (left <= right) {
            //좌측의 수가 기준점보다 작다면
            while (arr[left] < pivot) left++;
            //우측의 수가 기준점보다 크다면
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}

