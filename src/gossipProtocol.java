/* -------------------------------
55_gossipProtocol
Thursday, December 1st 2022
Daily Coding from CodeStates
------------------------------------
문제
세로와 가로의 길이가 각각 M, N인 마을지도가 배열로 주어졌을 때, '1'은 주민이 있는 집을 의미하고 '0'은 주민이 없는 땅을 의미합니다.
이 마을은 소문이 시작되면 하루에 상하좌우 한 칸 바로 옆에 있는 집으로 퍼집니다.
특정 주민의 집 (R, C)으로부터 어떤 소문이 시작될 경우, 마을 전체로 소문이 퍼지는데 걸리는 시간(일)을 리턴해야 합니다.

입력
인자 1 : village
String 타입을 요소로 갖는 배열
village.length는 M
village[i]는 String 타입
village[i].length는 N
village[i][j]는 세로로 i, 가로로 j인 지점의 정보를 의미
village[i][j]는 '0' 또는 '1'
인자 2: row
int 타입의 0 이상의 정수
소문이 시작되는 집의 세로 위치
인자 3: col
int 타입의 0 이상의 정수
소문이 시작되는 집의 가로 위치

출력
int 타입을 리턴해야 합니다.

주의사항
M, N은 100 이하의 자연수입니다.
row, col에는 항상 주민이 살고 있습니다.
모든 집은 연결되어 있습니다. 즉, 한 집에서 다른 집으로 가는 경로가 항상 존재합니다.
village를 그래프로 구현하는 함수가 주어집니다.

입출력 예시
String[] village = new String[]{
  "0101", // 첫 번째 줄
  "0111",
  "0110",
  "0100",
];
int row = 1;
int col = 2;
int output = gossipProtocol(village, row, col);
System.out.println(output); // --> 3

// 배열로 바꾸기
// - BFS 구현
// 방문여부 체크 배열
// Queue 배열
// 카운팅 배열
// 좌표이동배열
// max값을 저장할 변수
// 유효성 검사 함수
------------------------------ */

import java.util.Arrays;

public class gossipProtocol {
    public static void main(String[] args) {

        String[] village = new String[]{ // 예시
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100"};
        int row = 1;
        int col = 2;
        int output = gossipProtocol2(village, row, col);
        System.out.println(output);  // 답 3
    }

    // 순환 큐에서 사용할 변수를 필드변수로 선언한다.
    static int front = 0;
    static int rear = 0;
    static int[][] queue;

    public static int gossipProtocol2(String[] village, int row, int col) {
        // bfs 구현을 위해 큐를 선언한다.
        // enQueue, deQueue시마다 인덱싱을 다시 하지 않기 위해
        // 순환 큐(circular queue)로 구현한다.
        // queue의 가능한 최대 크기만큼 배열을 선언한다.
        // 문제의 특성에 따라 큐에는 좌표 평면의 한 점이 삽입되고, 한번 삽입된 요소는 두 번 다시 삽입되지 않는다.
        int R = village.length;
        int C = village[0].length();
        int[][] matrix = createMatrix(village);
        int[][] MOVES = new int[][]{
                {-1, 0},  // UP
                {1, 0},   // DOWN
                {0, 1},   // RIGHT
                {0, -1}   // LEFT
        };

        int MAX_SIZE = R * C;
        queue = new int[MAX_SIZE][];
        int cnt = 0;
        enQueue(queue, new int[]{row, col}, MAX_SIZE);

        // 소문이 퍼지는 데 걸리는 시간을 저장한다.
        matrix[row][col] = 0;
        while (isEmpty()) {
            // 큐의 가장 앞 자리의 좌표를 얻는다.
            int[] pos = deQueue(queue, MAX_SIZE);
            row = pos[0];
            col = pos[1];
            cnt = matrix[row][col];

            // 현재 지점을 기준으로 네 방향을 검토한다.
            for(int[] move : MOVES) {
                int rDiff = move[0];
                int cDiff = move[1];
                int nextRow = row + rDiff;
                int nextCol = col + cDiff;
                if(isValid(nextRow, nextCol, R, C) && matrix[nextRow][nextCol] == 1) {
                    enQueue(queue, new int[]{nextRow, nextCol}, MAX_SIZE);
                    matrix[nextRow][nextCol] = matrix[row][col]+ 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return cnt;
    }
    public static void enQueue(int[][] queue, int[] pos, int MAX_SIZE) {
        // 실행 중에 큐가 가득차지는 않기 때문에 별도의 조건문을 작성할 필요가 없다.
        queue[rear] = pos;
        // 모듈러스 연산을 할 필요도 사실 없다.
        rear = (rear + 1) % MAX_SIZE;
    }
    public static boolean isEmpty() {
        return front != rear;
    }

    public static int[] deQueue(int[][] queue, int MAX_SIZE) {
        int[] pos = queue[front];
        front = (front + 1) % MAX_SIZE;
        return pos;
    }

    public static boolean isValid(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    public static int[][] createMatrix(String[] village) {
        int[][] matrix = new int[village.length][];
        for(int i = 0; i < village.length; i++) {
            String str = village[i];
            int[] row = new int[str.length()];
            for(int j = 0; j < str.length(); j++) {
                row[j] = Character.getNumericValue(str.charAt(j));
            }
            matrix[i] = row;
        }
        return matrix;
    }
}

