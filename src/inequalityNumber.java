import java.util.Arrays;

/* -------------------------------
47_inequalityNumber
Thursday, August 4th, 2022
Daily Coding from CodeStates
------------------------------------
Make an "inequality number" following process
Up to nine inequality signs (<, >) are given.
A number between 0 and 9 must appear only once on either side of the inequality sign.
An integer formed by concatenating numbers by the inequality sign one after another is called an inequality number.
Return the difference between the maximum inequality number and the minimum inequality number.

최대 9개의 부등호(<, >)가 주어집니다.
부등호의 좌우에는 0부터 9사이의 숫자가 한 번씩만 들어가야 합니다.
부등호를 만족하는 숫자의 조합을 차례대로 이어 붙여 만든 정수를 부등호 수라고 한다.
부등호 기호들을 입력받아 부등호를 만족하는 최대 부등호 수와 최소 부등호 수의 차이를 리턴해야 합니다.

입력
인자 1 : signs
String 타입의 공백을 사이에 둔 부등호 기호들
signs.length()는 17 이하 (최대 9개의 부등호 기호)
출력
int 타입을 리턴해야 합니다.
주의사항
첫 자리가 0인 경우도 부등호 수에 포함되어야 합니다.
모든 입력에 답은 항상 존재합니다.

------------------------------ */


public class inequalityNumber {
    public static void main(String[] args) {

        long output = inFunction("<");
        System.out.println(output); // --> 88 (89 - 01)

        output = inFunction("<,>");
        System.out.println(output); // --> 876 (897 - 021)

        output = inFunction(">,<,>");
        System.out.println(output); // --> 8,754 (9,786 - 1,032)

    }

    public static long inFunction(String signs) {
        String[] arr = signs.split(",");
        int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reverseDigits = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        long min = aux(-1, arr, new String[]{}, digits, new boolean[10]);
        long max = aux(-1, arr,  new String[]{}, reverseDigits, new boolean[10]);
        return max - min;
    }

    public static int aux(int idx, String[] signs, String[] nums, int[] digits, boolean[] isVisited) {
        if(idx == signs.length) {
            // 부등호 수를 만든 경우
            String result = String.join("", nums);
            return Integer.parseInt(result);
        }

        String sign;

        if(idx != -1) {
            sign = signs[idx];
        } else {
            sign = "NULL";
        }
        for(int i = 0; i < digits.length; i++) {
            // 숫자를 차례대로 검토한다.
            // max를 구할 때는 9부터, min을 구할 때는 0부터
            int right = digits[i];
            // 이전 단계에서 사용한 숫자인 경우 스킵
            if (isVisited[right]) continue;

            // 첫번째 숫자가 아닌 경우에는 조건이 중요하다.
            if (idx >= 0) {
                // 항상 바로 직전의 숫자와 비교하면 된다.
                int left = Integer.parseInt(nums[nums.length - 1]);
                if(sign.equals("<") && left >= right) continue;
                if(sign.equals(">") && left <= right) continue;
            }

            // 조건을 만족하거나 첫번째 숫자인 경우
            isVisited[right] = true;
            String[] stringArr = Arrays.copyOf(nums, nums.length + 1);
            stringArr[stringArr.length - 1] = String.valueOf(right);
            int target = aux(idx + 1, signs, stringArr, digits, isVisited);

            if (target != -1) {
                // 부등호 수를 이미 찾은 경우 탐색을 더 할 필요가 없다.
                return target;
            }
            // 탐색에 실패한 경우, 시도한 숫자의 상태(사용중)를 원래대로(사용안함) 바꿔놔야 한다.
            isVisited[right] = false;
        }
        return -1;
    }





}
