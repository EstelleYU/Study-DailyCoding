
/*---------------------------------------
43_spiralTraversal
Daily Coding from CodeStates
Thursday, July 28th, 2022
---------------------------------------
문제
2차원 M x N 배열을 나선형(spiral)으로 순회해야 합니다.

입력
인자 1 : matrix
세로 길이(matrix.length)가 M, 가로 길이(matrix[i].length)가 N인 2차원 배열
matrix[i]는 Character 타입을 요소로 갖는 배열
matrix[i][j].length는 1

출력
String 타입을 리턴해야 합니다.

주의사항
순회는 좌측 상단 (0,0)에서 시작합니다.
배열의 모든 요소를 순서대로 이어붙인 문자열을 리턴해야 합니다.
--------------------------------------- */

public class spiralTraversal {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = sTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

//        matrix = new Character[][]{
//                {'T', 'y', 'r', 'i'},
//                {'i', 's', 't', 'o'},
//                {'n', 'r', 'e', 'n'},
//                {'n', 'a', 'L', ' '},
//        };
//        output = spiralTraversal(matrix);
//        System.out.println(output); // --> 'Tyrion Lannister'
    }

    public static String sTraversal(Character[][] matrix) {
        // 각 방향마다 row와 col의 변화를 저장
        int[] RIGHT = new int[]{0, 1};
        int[] DOWN = new int[]{1, 0};
        int[] LEFT = new int[]{0, -1};
        int[] UP = new int[]{-1, 0};
        // 각 방향을 위한 lookup table
        int[][] MOVES = new int[][]{
                RIGHT, DOWN, LEFT, UP
        };

        int M = matrix.length;
        int N = matrix[0].length;

        int cnt = 0;
        int row = 0, col = -1;
        int direction = 0;
        StringBuilder result = new StringBuilder();
        while (cnt < M * N) {
            int[] move = MOVES[direction];
            int rd = move[0], cd = move[1];

            row = row + rd;
            col = col + cd;
            while (isValid(row, col, M, N) && matrix[row][col] != null) {
                result.append(matrix[row][col]);
                matrix[row][col] = null;
                row = row + rd;
                col = col + cd;
                cnt++;
            }
            // row, col 이 행렬의 범위를 벗어났기 때문에,
            // 진행된 방향의 반대로 한 칸 이동한다.
            row = row - rd;
            col = col - cd;

            // 각 방향이 순환되기 때문에 모듈러 연산을 사용한다.
            direction = (direction + 1) % 4;
        }
        return result.toString();
    }

    public static boolean isValid(int row, int col, int M, int N) {
        return (row >= 0 && row < M && col >= 0 && col < N);
    }


}
