package programmers_68645_삼각_달팽이;

/**
 문제이해
 반시계 방향으로 달팽이 채우기를 진행한 후 출력해라.

 제한사항
 n은 1 이상 1,000 이하

 풀이과정
 n = 4, [1,2,9,3,10,8,4,5,6,7]
 1, 2는 고정
 1
 2 9
 3 10 8
 4 5 6 7

 **/
class Solution {
    public int[] solution(int n) {
        // 2차원 배열
        int[][] matrix = new int[n][n];

        int row = -1; // 아래로 내려감
        int col = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    // 0, 3, 6... 번째 방향: 아래로 이동
                    row++;
                } else if (i % 3 == 1) {
                    // 1, 4, 7... 번째 방향: 오른쪽으로 이동
                    col++;
                } else if (i % 3 == 2) {
                    // 2, 5, 8... 번째 방향: 대각선 위로 이동
                    row--;
                    col--;
                }
                matrix[row][col] = num++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[num++] = matrix[i][j];
            }
        }

        return answer;
    }
}
