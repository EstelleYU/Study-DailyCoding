
/*---------------------------------------
38_mergeSort
Daily Coding from CodeStates
Tuesday, July 19th, 2022
---------------------------------------
문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 정수
arr.length 100,000 이하

출력
int 타입을 요소로 갖는 배열을 리턴해야 합니다.
배열의 요소는 오름차순으로 정렬되어야 합니다.
arr[i] <= arr[j] (i < j)

주의사항
병합 정렬을 구현해야 합니다.
Arrays.sort 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
---------------------------------------*/

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr =  {3, 1, 21, 7};
        int[] result = mSort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mSort(int[] arr) {
        sort(arr);
        return arr;
    }

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sort(int[] arr, int left, int right) {
        if(left < right) {
            // 가운데 인덱스를 구합니다.
            int mid = (left + right) / 2;
            // 배열의 중앙을 기준으로 2개의 그룹으로 분할합니다.
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            // 정렬, 병합 과정을 실행합니다.
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // 임시로 사용할 배열을 선언합니다.
        int[] temp = new int[arr.length];
        // 해당 배열에 기존 arr 배열을 복사합니다.
        System.arraycopy(arr, 0, temp, 0, arr.length);

        // leftIdx : 좌측 배열의 시작 인덱스
        int leftIdx = left;
        // rightIdx : 우측 배열의 시작 인덱스
        int rightIdx = mid + 1;
        // index: 정렬된 값을 병합된 배열에 넣을 인덱스
        int index = left;

        // 좌측 배열, 우측 배열 두 배열중 한쪽의 요소가 모두 없어질 때까지 반복합니다.
        while(leftIdx <= mid && rightIdx <= right) {
            if(temp[leftIdx] <= temp[rightIdx]) {
                arr[index++] = temp[leftIdx++];
            } else {
                arr[index++] = temp[rightIdx++];
            }
        }

        // 좌측 배열의 요소가 남았을 경우, 남은 요소를 넣어줍니다.
        // 오른쪽 그룹의 원소가 남는 경우는 따로 처리하지 않아도 됩니다.
        for(int i=0; i<=mid-leftIdx; i++) {
            arr[index+i] = temp[leftIdx+i];
        }
    }
}

