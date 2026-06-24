package programmers_86971_전력망을_둘로_나누기;

/**
 문제이해
 전선들 중 하나를 끊어서 송전탑 개수가 비슷하도록 두 전력망을 나누었을 때,
 송전탑의 개수 차이를 return 해라.

 제한사항
 송전탑의 개수 n, 그리고 전선 정보 wires
 n은 2 이상 100 이하인 자연수
 wires는 길이가 n-1인 정수형 2차원 배열

 풀이과정
 [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
 1 3 2
 5 4 6
 8 7 9

 [[1,2],[2,3],[3,4]]
 1 2 3 4

 [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]
 1 2 7 3 4 5
 6

 1. 처음 배열을 분리
 2. 1 / 3
 3. 그리고 1과 이어지는 개수 3과 이어지는 개수를 파악
 4. 둘의 차이를 구한다.
 5. 전역 min보다 차이가 적으면 갱신
 6. 반복

 **/

class Solution {

    boolean[] visit;

    public int solution(int n, int[][] wires) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            visit = new boolean[n + 1];

            int n1 = dfs(wires, wires[i][0], i);
            int n2 = n - n1;

            int cnt = Math.abs(n1 - n2);
            if (min > cnt) {
                min = cnt;
            }
        }

        int answer = min;
        return answer;
    }

    int dfs (int[][] wires, int num, int idx) {
        visit[num] = true;
        int cnt = 1;

        for (int i = 0; i < wires.length; i++) {
            if (i == idx) {
                continue;
            }

            int n1 = wires[i][0];
            int n2 = wires[i][1];

            if (n1 == num && !visit[n2]) {
                cnt += dfs(wires, n2, idx);
            } else if (n2 == num && !visit[n1]) {
                cnt += dfs(wires, n1, idx);
            }
        }

        return cnt;
    }
}
