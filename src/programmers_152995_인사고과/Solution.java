package programmers_152995_인사고과;

/**
 문제이해
 사원의 근무태 점수와 동료 평가 점수 목록을 보고 완호의 석차를 출력해라.

 제한사항
 조건 1.
 만약 어떤 사원이
 다른 임의의 사원보다 두 점수가 모두 낮은 경우가 한 번이라도 있다면
 그 사원은 인센티브를 받지 못합니다.

 조건 2.
 두 점수의 합이 높은 순으로 석차를 내어 석차에 따라 인센티브가 차등 지급

 조건 3.
 두 점수의 합이 동일한 사원들은 동석차이며,
 동석차의 수만큼 다음 석차는 건너 뜁니다.
 -> 석차는 생각할 필요 X (완화 몇번째인지 구하면 된다.)

 - 1 ≤ scores의 길이 ≤ 100,000
 - scores의 각 행은
 - 한 사원의 근무 태도 점수와 동료 평가 점수를 나타내며
 [a, b] 형태입니다.
 - scores[0]은 완호의 점수
 완호가 인센티브를 받지 못하는 경우 -1

 풀이과정
 [[2,2],[1,4],[3,2],[3,2],[2,1]]
 1. 먼저 근무 태도 점수로 내림차순 정렬을 한다.
 2. 만약 근무 태도 점수가 동일하면 오름차순 정렬을 한다.
 3. 가장 큰 값을 저장해두고 값이 같을 때와 큰 값을 비교한다.

 1,4/ 2,1 / 2,2 / 3,2 / 3, 2

 **/
import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        // 완호값을 저장해두기
        int[] wanho = {scores[0][0], scores[0][1]};
        int wanhoSum = scores[0][0] + scores[0][1];

        // 내림차순으로 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        // 탈락자 선정
        int max = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            if (scores[i][1] < max) {
                if (wanho[0] <= scores[i][0] && wanho[1] <= scores[i][1])
                    return -1;
                scores[i][0] = -1;
            } else if (scores[i][1] > max) max = scores[i][1];
        }

        // 총합
        int answer = 1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] == -1) continue;
            if (scores[i][0] + scores[i][1] > wanhoSum) answer++;
        }

        return answer;
    }
}
