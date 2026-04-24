package programmers_43105_정수_삼각형;

/**
 문제이해
 삼각형 꼭대기에서 이어지는 경로 중 거쳐간 숫자의 합이 가장 큰 경우를 찾아보자.
 이동은 대각선 방향으로 한 칸 오른쪽, 왼쪽으로만 이동 가능합니다.

 제한사항
 삼각형의 높이는 1~500
 숫자는 0 ~ 9999

 풀이과정
 [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]

 [7]
 [3, 8]
 [8, 1, 0]
 [2, 7, 4, 4]
 [4, 5, 2, 6, 5]

 1. dfs를 사용해서 모든 경우의 수를 확인해본다.
 2. 더 갈 곳이 없으면 멈춤 (depth)
 3. 갈수잇는 곳음 바로 아래와 아래 옆 dx = {0, 1} / dy = {1, 1};

 -> 시간초과

 풀이과정 2
 1. dp를 활용해서 그전 값을 저장한다.

 **/
class Solution {

    public int solution(int[][] triangle) {

        int n = triangle.length;

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 1. 왼쪽 끝인 경우: 바로 위(오른쪽 대각선 위)에서만 내려옴
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                // 2. 오른쪽 끝인 경우: 바로 위(왼쪽 대각선 위)에서만 내려옴
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 3. 중간인 경우: 위쪽의 두 경로 중 최댓값을 선택
                else {
                    dp[i][j] =
                            Math.max(dp[i-1][j-1], dp[i-1][j])
                                    + triangle[i][j];
                }
            }
        }

        // 마지막 줄에서 가장 큰 값 찾기
        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n-1][j]);
        }

        int answer = max;
        return answer;
    }
}

