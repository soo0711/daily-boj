package programmers_42898_등굣길;
/**
 문제이해
 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는
 최단경로의 개수를 구하여라.

 제한사항
 최단경로의 개수를 1,000,000,007로 나눈 나머지
 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
 물에 잠긴 지역은 0개 이상 10개 이하입니다.
 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.

 풀이과정
 최단경로의 경우의 수를 구하는 것.
 1. dp를 활용하자
 2. 먼저 웅덩이 표시


 **/
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {

        // 초기화
        int[][] dp = new int[n + 1][m + 1];

        // 웅덩이 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // 시작점
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점은 패스
                if (i == 1 && j == 1) continue;

                // 웅덩이 만났을 때
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        int answer = dp[n][m];
        return answer;
    }
}
