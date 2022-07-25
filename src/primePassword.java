import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/*---------------------------------------
40_primePassword (Advanced)
Daily Coding from CodeStates
Thursday, July 21st, 2022
---------------------------------------
문제
다음의 조건을 만족하면서 현재의 비밀번호('curPwd')를 새 비밀번호(newPwd)로 변경하는 데 필요한 최소 동작의 수를 리턴해야 합니다.

한 번에 한 개의 숫자만 변경가능하다.
4자리의 소수(prime)인 비밀번호로만 변경가능하다.
비밀번호가 계속 소수를 유지하도록 숫자 한 개씩을 바꿔갈 때
현재 비밀번호에서 새 비밀번호로 바꾸는 데 최소 몇 개의 숫자를 변경해야 하는지를 리턴해야 합니다.

입력
인자 1 : curPwd
int 타입의 1,000 이상 9,999 이하의 자연수
인자 2 : newPwd
int 타입의 1,000 이상 9,999 이하의 자연수

출력
int 타입을 리턴해야 합니다.
주의사항
4자리인 소수는 1,000 이상의 소수를 말합니다.(0011, 0997 등은 제외)
새 비밀번호를 만들 수 없는 경우 -1을 리턴합니다.
---------------------------------------*/

public class primePassword {
    public static void main(String[] args) {
        int curPwd = 3733;
        int newPwd = 8779; // (3733 -> 3739 -> 3779 -> 8779)
        int output = Password(curPwd, newPwd);
        System.out.println(output);
    }
    public static int Password(int curPwd, int newPwd) {
        //변경된 비밀번호가 같을 경우
        if (curPwd == newPwd) return 0;
        // bfs를 위해 queue를 선언
        Queue<int[]> queue = new LinkedList<>();

        // 각 4자리의 방문 여부를 저장하는 배열
        // 한 번 방문한 수(가장 최소의 동작으로 만든 수)는 다시 방문할 필요가 없다.
        boolean[] isVisited = new boolean[10000];
        isVisited[curPwd] = true;
        // bfs를 위한 시작점
        // 큐에는 [필요한 동작 수, 비밀번호]가 저장된다.
        // 배열의 첫번째 인자는 동작 수, 두번째 인자는 비밀번호가 입력된다.
        queue.offer(new int[]{0, curPwd});
        // bfs는 큐가 빌(empty) 때까지 탐색한다.
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int step = data[0];
            int num = data[1];
            // 각 자리수 마다 변경이 가능하므로 4번의 반복이 필요하다.
            for (int i = 0; i < 4; i++) {
                int[] digits = splitNumber(num);
                // 0부터 9까지 시도한다.
                for (int d = 0; d < 10; d++) {
                    // 각 자리수마다 원래 있던 수(digits[i])는 피해야 한다.
                    if (d != digits[i]) {
                        // 현재 자리수의 수를 변경하고,
                        digits[i] = d;
                        // 변경한 후 4자리 수를 구한다.
                        int next = joinDigits(digits);
                        // 만약 이 수가 새 비밀번호와 같다면 리턴한다.
                        // next는 deQueue된 num으로부터 1단계 다음에 도달한 수이다.
                        if(next == newPwd) return step + 1;
                        // 1,000보다 큰 소수여야 하고, 방문된 적이 없어야 한다.
                        if(next > 1000 && isPrime(next) && !isVisited[next]) {
                            // 방문 여부를 표시하고,
                            isVisited[next] = true;
                            // 큐에 넣는다.
                            queue.offer(new int[]{step + 1 , next});
                        }
                    }
                }
            }
        }
        // 큐가 빌 때까지, 즉 모든 경우의 수를 탐색할 때까지 리턴되지 않은 경우
        // 현재 비밀번호에서 새 비밀번호를 만들 수 없다.
        return -1;
    }

    // 소수를 판별하는 메서드
    public static boolean isPrime(int num) {
        if(num % 2 == 0) return false;
        int sqrt = (int)(Math.sqrt(num));
        for(int divider = 3; divider <= sqrt; divider += 2) {
            if(num % divider == 0) {
                return false;
            }
        }
        return true;
    }

    // 4자리 수를 받아서 각 자리수의 수들의 배열로 변환하는 메서드
    //  int[] output = splitNum(3359);
    //  System.out.println(output); // --> [3, 3, 5, 9]
    public static int[] splitNumber(int num) {
        // Stream 사용하여 구현
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        // 반복문을 사용하여 구현

        // String temp = Integer.toString(num);
        // int[] digits = new int[temp.length()];
        // for (int i = 0; i < temp.length(); i++) digits[i] = temp.charAt(i) - '0';
        // return digits;
    }

    // 배열을 입력 받아서 각 자리수의 수들의 숫자로 변환하는 메서드
    //  int output = joinDigits(new int[]{3, 3, 5, 9});
    //  System.out.println(output); // 3359
    public static int joinDigits(int[] arr) {
        String[] tempArr = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {
            tempArr[i] = String.valueOf(arr[i]);
        }

        return Integer.parseInt(String.join("", tempArr));
    }
}
