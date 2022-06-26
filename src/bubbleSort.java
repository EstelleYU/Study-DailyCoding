

import java.util.Arrays;
import java.util.Scanner;


/* ------------------------------

22_bubbleSort
Daily Coding from CodeStates
Mon 27 June 2022

Return the int array in ascending order.
The bubble sort algorithm as below.
Step1. If the first element is larger than the second one, swap the positions of the two elements.
Step2. If the second element is larger than the third one, swap the positions of the two elements.
Step3. Repeat step1 and step2 until the end of array. (At the last, compare the second element and the last element)
Through step1 to step3 once, the largest element is pushed to the end of the array.
Step4~. Repeat step1 to step3 once again, the second largest element is pushed  to the second position from the back of the array
Repeat this process for n times (size of the array).
It is called bubble sort because it looks like 'like a bubble being pushed up'.

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.
버블 정렬(bubble sort)은 여러 정렬 알고리즘 (삽입 정렬, 퀵 정렬, 병합 정렬, 기수 정렬 등) 중 가장 기본적인 알고리즘입니다.
버블 정렬 알고리즘은 아래와 같습니다.
첫 번째 요소가 두 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
두 번째 요소와 세 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
1, 2를 마지막까지 반복합니다. (마지막에서 두 번째 요소와 마지막 요소를 비교)
1~3의 과정을 한 번 거치게 되면, 가장 큰 요소가 배열의 마지막으로 밀려납니다.
1~3의 과정을 첫 요소부터 다시 반복합니다.
5를 통해 두 번째로 큰 요소가 배열의 마지막 바로 두 번째로 밀려납니다.
1~3의 과정을 총 n번(배열의 크기) 반복합니다.
이 모습이 마치 '거품이 밀려 올라가는 것과 같은 모습'과 같아서 bubble sort라고 부릅니다.

----------------------------- */

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 43, 100, 100, 21};

        for(int i = 1; i < arr.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr [j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if(swapped == false) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

