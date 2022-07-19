import java.util.Arrays;

/*---------------------------------------
37_radixSort
Daily Coding from CodeStates
Monday, July 18th, 2022
---------------------------------------
radixSort
문제
정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 0 이상의 정수
arr.length 100,000 이하

출력
int 타입을 요소로 갖는 배열을 리턴해야 합니다.
배열의 요소는 오름차순으로 정렬되어야 합니다.
arr[i] <= arr[j] (i < j)

주의사항
기수 정렬을 구현해야 합니다.
Arrays.sort 사용은 금지됩니다.
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
입출력 예시


 ---------------------------------------*/
public class radixSort {
    public static void main(String[] args) {
    int[] arr =  {3, 1, 21, 7};
    int[] result = sort(arr);
    System.out.println(Arrays.toString(result));

}
    public static int[] sort(int[] arr) {
        // 최대값을 먼저 구합니다.
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }

        // Counting Sort를 사용하여 자릿수 기준으로 정렬합니다.
        for (int digit = 1; digit <= maxValue; digit *= 10) {
            arr = countingSort(arr, digit);
        }
        return arr;
    }

    public static int[] countingSort(int[] arr, int digit) {
        int[] temp = new int[arr.length]; // 임시로 사용할 공간
        int[] counting = new int[10]; // 카운팅 배열

        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10; // 해당 자리수의 숫자 추출
            counting[num]++;
        }

        // 누적합을 배열로 만듭니다.
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 배열의 가장 마지막 인덱스부터 시작합니다. 가장 큰 수가 가장 뒤로 정렬되어야 하기 때문에, 안정적으로 정렬하기 위해서는 마지막 요소부터 순회하는것이 좋습니다.
        for (int i = arr.length - 1; i >= 0; i--) {
            // 현재 배열의 자릿수를 구합니다.
            int num = (arr[i] / digit) % 10;
            // 해당 자릿수를 인덱스로 counting 배열의 요소를 1씩 뺀 후,
            counting[num]--;
            // 구한 값을 인덱스로 배열의 요소를 삽입합니다.
            temp[counting[num]] = arr[i];
        }
        //해당 배열을 반환합니다.
        return temp;
    }
}
