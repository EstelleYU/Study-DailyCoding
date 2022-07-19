

/*---------------------------------------
39_heapSort
Daily Coding from CodeStates
Wednesday, July 20th, 2022
---------------------------------------
문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 -100,000 이상 100,000 이하의 정수
arr.length는 100,000 이하

출력
int 타입을 요소로 갖는 배열을 리턴해야 합니다.

주의사항
힙 정렬을 구현해야 합니다.
Arrays.sort 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
최소 힙(min heap)을 구현해야 합니다.
Java에서는 쉽게 heap을 사용할 수 있습니다.
PriorityQueue<Integer> heap = new PriorityQueue<Integer>()와 같은 방식으로 사용할 수 있습니다.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class heapSort {
    public static void main(String[] args) {
        int[] arr =  {3, 1, 21, 7};
        int[] result = hSort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] hSort(int[] arr) {
         // 힙 정렬에 사용될 힙(우선순위 큐)을 선언합니다.
         PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // 배열의 값을 힙에 모두 할당합니다.
        for(int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

            // 힙에서 우선순위가 가장 높은 원소(root노드)를 하나씩 배열에 넣어줍니다.
        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        return arr;
    }
}

